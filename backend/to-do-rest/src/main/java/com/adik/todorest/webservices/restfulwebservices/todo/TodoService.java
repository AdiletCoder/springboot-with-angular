//package com.adik.todorest.todo;
//
//import org.springframework.stereotype.Service;
//
//import java.math.BigInteger;
//import java.security.SecureRandom;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TodoService {
//    private static List<Todo> todos = new ArrayList<>();
//
//    static {
//        Todo todo = new Todo("Todo1", "This is my first todo", LocalDate.now(), false);
//        Todo todo1 = new Todo("Todo2", "This is my second todo", LocalDate.now(), false);
//        Todo todo2 = new Todo("Todo3", "This is my third todo", LocalDate.now(), false);
//       todos.add(todo);
//       todos.add(todo1);
//       todos.add(todo2);
//    }
//
//    public List<Todo> retrieveTodos(){
//        return todos;
//    }
//    public String addTodo(Todo todo){
//        todo.setId(generateRandomId());
//        todo.setTargetDate(LocalDate.now());
//        todo.setDone(false);
//        todos.add(todo);
//        return todo.getId();
//    }
//
//    private static String generateRandomId() {
//        SecureRandom secureRandom = new SecureRandom();
//        String randomId = new BigInteger(32, secureRandom).toString();
//        return randomId;
//    }
//
//}
