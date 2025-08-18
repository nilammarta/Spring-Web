package karinz.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    public String header(
            // Menggunakan annotation @RequestHeader untuk mendapatkan Http request header
            @RequestHeader(name = "X-TOKEN") String token
    ){
        if ("KARINZ".equals("KARINZ")) {
           return "OK";
        } else {
            return "KO";
        }
    }
}
