/**
 * Closure de controle de cadastro de carros
 */
let CarModule = (function() {

    /**
     * Objeto de informações do módulo com os valores utilizados nos selects e afins
     * @type {{}}
     */
    let modInfo = {};

    /**
     * Mapa de elementos jQuery previamente carregados para manipulação de dom
     * @type {{}}
     */
    let elementMap = {};

    /**
     * Objeto que representa o módulo encarceirado
     * @type {{}}
     */
    let carModule = {};

    /**
     * Inicialização do módulo
     */
    const init = async () => {
        await mapElements();
        await getModuleInitInfo();
        await mountSelects();
        await fillList();
        await bindFunctions();
    };

    /**
     * Mapeia os elementos do dom para o elementMap
     */
    const mapElements = async () => {
        elementMap.moduleContainer = $('div#carModule');
        elementMap.form = $('form', elementMap.moduleContainer);
        elementMap.views = {};
        elementMap.views.lst = $('div#viewLst', elementMap.moduleContainer);
        elementMap.views.edt = $('div#viewEdt', elementMap.moduleContainer);
        elementMap.inputs = {};
        elementMap.inputs.carId = $('input#carId', elementMap.form);
        elementMap.inputs.carName = $('input#carName', elementMap.form);
        elementMap.inputs.carOwner = $('select#carOwner', elementMap.form);
        elementMap.inputs.carBrand = $('select#carBrand', elementMap.form);
        elementMap.inputs.carType = $('select#carType', elementMap.form);
        elementMap.buttons = {};
        elementMap.buttons.newCar = $('button#newCar', elementMap.views.lst);
        elementMap.buttons.saveEdt = $('button#saveEdt', elementMap.views.edt);
        elementMap.buttons.cancelEdt = $('button#cancelEdt', elementMap.views.edt);
        elementMap.tables = {};
        elementMap.tables.carTable = $('table#carTable', elementMap.views.lst);
    };


    /**
     * Consulta as informações iniciais para montar os componentes de seleção do módulo
     * @returns {Promise<void>}
     */
    const getModuleInitInfo = async () => {
        await $.get("car/initinfo", result => modInfo = result);
    };

    /**
     * Mapeia os eventos para os elementos do módulo
     */
    const bindFunctions = async () => {
        elementMap.buttons.newCar.off('click').on('click', CarModule.onNewCarButtonClick);
        elementMap.buttons.saveEdt.off('click').on('click', CarModule.onSaveEdtButtonClick);
        elementMap.buttons.cancelEdt.off('click').on('click', CarModule.onCancelEdtButtonClick);
    };

    /**
     * Monta as opções dos selects com as informações carregadas do back-end
     */
    const mountSelects = async () => {
        modInfo.owners
               .forEach(owner => elementMap.inputs.carOwner.append(optionBuilder(owner.id, owner.name)));
        modInfo.brands
               .forEach(brand => elementMap.inputs.carBrand.append(optionBuilder(brand.id, brand.name)));
        Object.keys(modInfo.types)
              .forEach(type => elementMap.inputs.carType.append(optionBuilder(type, modInfo.types[type])));
    };

    /**
     * Monta uma tag option para elementos do tipo select com o valor e a label informadas
     * @param value utilizado no atributo de valor da opção
     * @param label utilizado como texto da opção
     * @returns {string}
     */
    const optionBuilder = (value, label) => `<option value="${value}">${label}</option>`;

    /**
     * Realiza uma requisição e preenche a listagem com o resultado
     */
    const fillList = async () => {
        await $.get('car/lst')
               .done(result => {
                   const $tBody = elementMap.tables.carTable.find('tbody');
                   $tBody.empty();
                   console.log(result, $tBody);
                   result.forEach(car => $tBody.append(rowBuilder(car)));
               })
               .fail(error => console.log(error));
    };

    const rowBuilder = car => `
        <tr>
        <td>${car.id}</td>
        <td>${car.name}</td>
        <td>${car.owner.name}</td>
        <td>${car.brand.name}</td>
        <td>${car.type}</td>
        </tr>
    `;

    /**
     * Função utilizada para a troca de views
     * @param {jQuery} origin
     * @param {jQuery} target
     */
    const changeView = (origin, target) => {
        origin.hide();
        target.show();
    };

    /**
     * Reseta o formulário de edição
     */
    const clearFormEdt = () => {
        elementMap.inputs.carId.val('');
        elementMap.inputs.carName.val('');
        elementMap.inputs.carOwner.val('');
        elementMap.inputs.carBrand.val('');
        elementMap.inputs.carType.val('');
    };

    /**
     * Handler do botão de inserção de carros
     * @param event
     */
    const onNewCarButtonClick = () => {
        clearFormEdt();
        changeView(elementMap.views.lst, elementMap.views.edt);
    };

    /**
     * Handler do botão de salvamento de edição
     * @param event
     */
    const onSaveEdtButtonClick = async () => {
        await $.post("car/save", elementMap.form.serialize())
               .done(result => CarModule.onSaveSuccessCallback(result))
               .fail(error => console.error(error));
    };

    /**
     * Mostra mensagem no console, atualiza a listagem e navega de volta para a listagem
     * @param result
     * @returns {Promise<void>}
     */
    const onSaveSuccessCallback = async result => {
        await fillList();
        clearFormEdt();
        changeView(elementMap.views.edt, elementMap.views.lst);
        console.log('Registro salvo com sucesso.', result)
    };

    /**
     * Handler do botão de cancelamento de edição
     * @param event
     */
    const onCancelEdtButtonClick = () => {
        clearFormEdt();
        changeView(elementMap.views.edt, elementMap.views.lst);
    };

    carModule.init = init;
    carModule.onNewCarButtonClick = onNewCarButtonClick;
    carModule.onSaveEdtButtonClick = onSaveEdtButtonClick;
    carModule.onCancelEdtButtonClick = onCancelEdtButtonClick;
    carModule.onSaveSuccessCallback = onSaveSuccessCallback;

    return carModule;

})();