package karinz.webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import karinz.webmvc.model.HelloRequest;
import karinz.webmvc.model.HelloResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void bodyHello() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Karinz");

        // Menjadikan HalloRequest menjadi JSON string
        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/body/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Karinz"))
        ).andExpect(result -> {

            // Mendapatkan response body sebagai JSON string
            String responseJson = result.getResponse().getContentAsString();

            // Menggunakan ObjectMapper untuk mengubah JSON string menjadi HelloResponse object
            HelloResponse response = objectMapper.readValue(responseJson, HelloResponse.class);
            assertEquals("Hello Karinz", response.getHello());
        });

    }
}
