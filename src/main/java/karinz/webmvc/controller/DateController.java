package karinz.webmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @GetMapping(path = "/date")
    // Penggunaan response body
    @ResponseBody
    public String getDate(
            @RequestParam(name = "date") Date date
//            HttpServletResponse response
            ) throws Exception {
//        response.getWriter().println(
//                "Date : " + dateFormat.format(date)
//        );

        // Karena menggunkana annotation @ResponseBody, maka kita bisa langsung mengembalikan string
        return "Date : " + dateFormat.format(date);
    }
}
