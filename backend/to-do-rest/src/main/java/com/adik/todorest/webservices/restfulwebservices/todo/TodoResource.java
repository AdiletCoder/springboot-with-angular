package com.adik.todorest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return  todoService.findAll();
    }

    @DeleteMapping("/user/{username}/todos/{id}")
    public  ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
       Todo todo =  todoService.deleteById(id);
       if (todo !=null){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){

        return  todoService.findById(id);
    }

    @RequestMapping(value="users/{username}/todos/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id,
                                           @RequestBody Todo todo){
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @RequestMapping(value="users/{username}/todos/", method=RequestMethod.POST)
    public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


//    public TodoService todoService;
//
//    public TodoResource(TodoService todoService) {
//        this.todoService = todoService;
//    }
//
//    @RequestMapping("/todos")
//    public List<Todo> retrieveTodos() {
//        return todoService.retrieveTodos();
//    }
//
//    @RequestMapping(value = "/todos/", method= RequestMethod.POST)
//    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
//        String todoId = todoService.addTodo(todo);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{todoId}").buildAndExpand(todoId).toUri();
//        return ResponseEntity.created(location).build();
//
//    }
}
