package karinz.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Karinz")
                        .param("middleName", "Maria")
                        .param("lastName", "Muren")
                        .param("email", "karin@gmail.com")
                        .param("phone", "08123456789")
                        .param("address.street", "Jalan Raya No. 1")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "12345")

                        // Menggunakan array untuk mengirimkan data yang memiliki banyak nilai
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedia[0].name", "Facebook")
                        .param("socialMedia[0].url", "https://www.facebook.com/karinz")
                        .param("socialMedia[1].name", "Instagram")
                        .param("socialMedia[1].url", "https://www.instagram.com/karinz")

        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Karinz Maria Muren " +
                        "with email karin@gmail.com and phone 08123456789" +
                        " with address Jalan Raya No. 1, Jakarta, Indonesia, 12345"))
        );
    }

    @Test
    void createPersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Maria")
                        .param("lastName", "Muren")
//                        .param("email", "karin@gmail.com")
                        .param("phone", "08123456789")
                        .param("address.street", "Jalan Raya No. 1")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "12345")

                        // Menggunakan array untuk mengirimkan data yang memiliki banyak nilai
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedia[0].name", "Facebook")
                        .param("socialMedia[0].url", "https://www.facebook.com/karinz")
                        .param("socialMedia[1].name", "Instagram")
                        .param("socialMedia[1].url", "https://www.instagram.com/karinz")

        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data"))
        );
    }
}
