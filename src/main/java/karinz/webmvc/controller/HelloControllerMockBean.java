package karinz.webmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import karinz.webmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloControllerMockBean {
    @Autowired
    private HelloService helloService;

    @RequestMapping(path="/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String responsebody = helloService.hello(name);
        // Mengembalikan nama view yang akan ditampilkan
        response.getWriter().println(responsebody);
    }
}
