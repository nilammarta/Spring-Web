package karinz.webmvc.controller;

import karinz.webmvc.model.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    @GetMapping("partner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    /**
     * Method ini digunakan untuk mengambil data partner dari session.
     * Tidak ada parameter yang digunakan, karena data partner diambil dari session.
     * @param partner objek Partner yang diambil dari session
     * @return String yang berisi ID dan nama partner
     *
     * CATATAN: karena pada file partner-argument-resolver, diperlukan header HTTP X-API-KEY
     * untuk mendapatkan objek Partner, maka pada saat melakukan request ke endpoint ini, maka perlu menambahkan header tersebut.
     */
    public String getPartner (Partner partner){
        return partner.getId() + " : " + partner.getName();
    }
}
