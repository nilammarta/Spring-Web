package karinz.webmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Mengubah halaman error bawaan Spring Boot, pada web aplikasi ini
 */
@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping(path = "/error")
    public ResponseEntity<String> error(HttpServletRequest request) {
        // Bagian ini digunakan untuk mengambil informasi statsus error
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        // Bagian ini digunakan untuk mengambil pesan error
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        String html = """
                <html>
                <body>
                <h1>$status - $message</h1>
                </body>
                </html>
                """.replace("$status", status.toString().replace("$message", message));

        return ResponseEntity.status(status).body(html);
    }
}
