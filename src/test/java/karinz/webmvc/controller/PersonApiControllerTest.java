package karinz.webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import karinz.webmvc.model.CreatePersonRequest;
import karinz.webmvc.model.CreateSocialMediaRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Karinz");
        request.setMiddleName("Maria");
        request.setLastName("Muren");
        request.setEmail("karin@gmail.com");
        request.setPhone("08123456789");
        request.setHobbies(List.of("Coding", "Reading", "Gaming"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/karinz"));
        request.getSocialMedia().add(new CreateSocialMediaRequest("Instagram", "instagram.com/karinz"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(request) )
        );
    }

    @Test
    void createPersonValidationError() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddleName("Maria");
        request.setLastName("Muren");
        request.setHobbies(List.of("Coding", "Reading", "Gaming"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("Facebook", "facebook.com/karinz"));
        request.getSocialMedia().add(new CreateSocialMediaRequest("Instagram", "instagram.com/karinz"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }

}
