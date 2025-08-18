package karinz.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/profile")
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "profile") MultipartFile profile
    ) throws IOException {
        // Menyimpan file ke dalam folder upload
        Path path = Path.of("upload/" + profile.getOriginalFilename() );

        // untuk melakukan penyimpanan upload file ke dalam folder upload
        // secara manual, dapat dilakukan dengan
//        Files.write(path, profile.getBytes());

        // melakukand transfer file dari MultipartFile ke Path
        profile.transferTo(path);
        return "Success upload profile " + name + " to " + path;
    }
}
