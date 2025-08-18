package karinz.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodeController {

    @DeleteMapping(path = "/products/{id}")
    @ResponseBody
    // ResponseStatus digunakan untuk mengubah status code dari response
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        //delete data
    }
}
