package karinz.webmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import karinz.webmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Untuk menjadikan class ini sebagai controller, perlu di tambahakan @Controller annotation.
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    // Untuk mengatur request mapping, kita bisa menggunakan @RequestMapping annotation.
    // Kita bisa mengatur path dan method yang akan digunakan.
//    @RequestMapping(path="/hello", method = RequestMethod.GET)
    /**
     * Selain itu juga ada cara lebih singkat untuk mengatur request mapping, yaitu dengan menggunakan @GetMapping annotation.
     * utnuk anootation bisa juga di guanakn utnuk post, put, delete, patch, dan lain-lain.
     */
    @GetMapping(path = "/hello")
    public void helloWorld(
            @RequestParam(name = "name", required = false) String name,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        // Karena kita menggunakan @RequestParam, maka kita bisa mendapatkan parameter name dari request.
        // Sehingga bagian ini tidak perlu
//        String name = request.getParameter("name");

        String responseBody = helloService.hello(name);
        // Mengembalikan nama view yang akan ditampilkan
        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false) String name) {

        /**
         * Melakukan redirect ke halaman lain
         */
        if (Objects.isNull(name)) {
            return new ModelAndView("redirect:/hello?name=Guest");
        }

        /**
         * ModelAndView adalah class yang digunakan untuk mengembalikan view dan model
         */
       return new ModelAndView("hello", Map.of(
               "title", "Belajar View",
               "name", name
       ));
    }
}
