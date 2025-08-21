package karinz.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StaticResourceTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Ketika menjalankan aplikasi, Spring Boot secara otomatis mengkonfigurasi
     * atau mencari file controller, jika tidak ditemukan maka akan mencari
     * file statis di dalam folder src/main/resources/static.
     * @throws Exception
     */
    @Test
    void testStatic() throws Exception {
        mockMvc.perform(
                get("index.html") // Mengakses file statis index.html
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Static"))
        );
    }
}
