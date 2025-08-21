package karinz.webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @RestController akan langsung menggabungkan @Controller dan @ResponseBody
 * yang artinya secara otomatis semua return Controller Method tersebut dianggap sebagai Response Body
 */
@RestController
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @PostMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> addTodo(
            @RequestParam(name = "todo") String todo
    ){
        todos.add(todo);
        return todos;
    }

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getTodos(){
        return todos;
    }

}
