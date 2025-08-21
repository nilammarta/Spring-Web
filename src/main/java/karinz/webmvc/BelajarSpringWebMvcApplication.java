package karinz.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication

/**
 * Meregitrasikan servlet scan, sehingga bisa menemukan servlet yang ada di dalam
 * package ini atau sub-package di bawahnya.
 */
@ServletComponentScan
public class BelajarSpringWebMvcApplication {

    /**
     * Membuat RestTemplate sebagai bean, sehingga bisa digunakan di seluruh aplikasi
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                // ini sudah di-remove oleh Spring Boot 3.0
//                .setConnectTimeout(Duration.ofSeconds(2L))
//                .setReadTimeout(Duration.ofSeconds(2L))
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringWebMvcApplication.class, args);
	}

}
