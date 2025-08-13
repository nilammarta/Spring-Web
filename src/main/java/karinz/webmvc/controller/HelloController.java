package karinz.webmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Untuk menjadikan class ini sebagai controller, perlu di tambahakan @Controller annotation.
 */
@Controller
public class HelloController {

    @RequestMapping(path="/hello")
//    @ResponseBody
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (name == null) {
            name = "Guest";
        }
        // Mengembalikan nama view yang akan ditampilkan
        response.getWriter().println("Hello " + name + "!");
    }
}
