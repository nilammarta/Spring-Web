package karinz.webmvc.controller;

import karinz.webmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    public String getUser(
            /**
             * Annotation @SessionAttribute digunakan untuk mengambil data dari session
             */
            @SessionAttribute(name = "user") User user
    ){
        return "Hello " + user.getUsername();
    }
}
