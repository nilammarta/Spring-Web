package karinz.webmvc;

import karinz.webmvc.interception.SessionInterception;
import karinz.webmvc.resolver.PartnerArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Konfigurasi Web MVC untuk aplikasi Spring Boot.
 *
 * Kelas ini mengimplementasikan WebMvcConfigurer untuk menyesuaikan konfigurasi web MVC.
 * Saat ini, kelas ini kosong, tetapi dapat diisi dengan konfigurasi tambahan jika diperlukan.
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterception sessionInterception;

    @Autowired
    private PartnerArgumentResolver partnerArgumentResolver;

    /**
     * Metode ini digunakan untuk menambahkan resolvers untuk menangani argumen metode.
     * Dalam hal ini, kita menambahkan PartnerArgumentResolver yang akan digunakan untuk
     * mengatasi parameter Partner dalam metode handler.
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(partnerArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterception).addPathPatterns("/user/*");
    }
}
