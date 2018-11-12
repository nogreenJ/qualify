package com.tn3.qualify.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class description
 *
 * @author fabio.f
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarRestApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInitInfo() throws Exception {
        this.mockMvc.perform(get("/car/initinfo"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.brands").exists())
                    .andExpect(jsonPath("$.owners").exists())
                    .andExpect(jsonPath("$.types").exists());
    }

    @Test
    public void getCarList() throws Exception {
        this.mockMvc.perform(get("/car/lst"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(5)));
    }
}
