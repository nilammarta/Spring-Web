package karinz.webmvc.resolver;

import jakarta.servlet.http.HttpServletRequest;
import karinz.webmvc.model.Partner;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        /**
         * Bagian ini akan memberikan parameter maana yang akan di-resolve
         */
        return parameter.getParameterType().equals(Partner.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // Bagian ini akan melakukan resolusi terhadap parameter Partner
        // Misalnya, kita akan mengambil dari header HTTP atau query parameter
        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        // Mengambil API key dari header HTTP
        String apikey = servletRequest.getHeader("X-API-KEY");


        if (apikey != null) {
            // Melakukan query ke database atau sumber data lain untuk mendapatkan Partner berdasarkan apikey
            return new Partner(apikey, "Sample Partner");
        }

        throw new RuntimeException("Unauthorized Exception");
    }
}
