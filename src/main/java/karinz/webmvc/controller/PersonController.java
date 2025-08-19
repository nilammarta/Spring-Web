package karinz.webmvc.controller;

import jakarta.validation.Valid;
import karinz.webmvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createPerson(
            /**
             * Menggunakan annotation @ModelAttribute untuk mendapatkan data dari FORM-urlencoded
             * sehingga jika ada banyak field, kita tidak perlu menambahkan
             * @RequestParam satu per satu, cukup dengan membuat class model
             */
            @ModelAttribute

            /**
             * Penggunaan annotation @Valid untuk melakukan validasi pada objek CreatePersonRequest
             */
            @Valid
            CreatePersonRequest request

    ){

        System.out.println(request);

        return new StringBuilder().append("Success create person ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(" ")
                .append("with email ").append(request.getEmail()).append(" ")
                .append("and phone ").append(request.getPhone()).append(" ")
                .append("with address ").append(request.getAddress().getStreet()).append(", ")
                .append(request.getAddress().getCity()).append(", ")
                .append(request.getAddress().getCountry()).append(", ")
                .append(request.getAddress().getPostalCode())
                .toString();
    }
}
