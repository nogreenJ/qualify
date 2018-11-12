## Avaliação de desempenho técnico

* O projeto é uma aplicação spring boot básica
    * Banco H2 embutido
    * Sem biblioteca de templating (o front-end fica localizado em src/main/resources/static, é independente e consome o back-end via ajax)
    * Para rodar basta usar o runner já configurado acima
    * Acesso padrão em http://localhost:8080
    * A cesso ao banco em http://localhost8080/h2
* Lembre-se que a qualidade de seu código será avaliada então documente, limpe e entregue somente 
aquilo pelo qual realmente quer ser avaliado...
* Não altere nada em branches que não forem a sua.
* Faça quantos commits quiser/precisar, lembre-se de fazer push. 
* Só será avaliado o código que for enviado para o repositório remoto.

### front-end

1. Na coluna "tipo" da listagem deve aparecer a descrição do tipo ao invés do nome da enumeração
2. Criar um botão ao lado do boão "Novo Carro" do tipo Info (azul), com ícone à escolher e rótulo "Hello Ajax"
3. Ao selecionar o tipo "esportivo" no formulário de edição deve mostrar um texto informativo abaixo do componente de seleção de tipo com a mensagem "rodas de liga" com o tipo info (azul)
4. Mapear o botão criado no passo anterior e criar um evento de clique para ele que irá consumir a url car/helloajax via get e imprimir no console do navegador o retorno da chamada
5. Criar o fluxo de edição de registro de carros no front-end

### back-end

1. Incluir campo cor do tipo string na entidade Car
2. Mapear regra para as entidades que possuem nome para que o nome não seja nulo
3. Criar entidade CarMaintenanceIssue e relacionar com a entidade Car (um carro pode ter vários registros de manutenção mas um registro pertence à apenas um carro) a entidade deve ter id no mesmo padrão das demais, data de registro e uma pessoa responsavel
4. Criar regra de negócio para o cadastro de carros que recebe uma lista de carros e remove os carros do tipo hatch apenas
5. Escreva o teste de integração do endpoint "helloajax" no cenário de cobertura da api de carros.
6. Criar o fluxo de edição de registro de carros no back-end
7. Criar um endpoint que retorna apenas as pessoas que possuem carro esporte

### full-stack

1. Implementar um filtro por nome do carro na listagem
