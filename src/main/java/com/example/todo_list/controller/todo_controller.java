package com.example.todo_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_list.controller.Services.todo_service;
import com.example.todo_list.entities.todo_db;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class todo_controller {
    @Autowired
    private todo_service todo_service_;

    @GetMapping("/todos")
    public List<todo_db> getTodos() {
        return this.todo_service_.get_all_todos();
    }

    @PostMapping("/add_todos")
    public todo_db add_todo(@RequestBody todo_db todo) {
        //TODO: process POST request
        todo_db todo_ = this.todo_service_.add_todo(todo);
        return todo_;
        
    }

    @DeleteMapping("/delete_todo/{id}")
    public void delete_todo(@PathVariable("id") int id)
    {
        this.todo_service_.del_todo(id);
    }
    @PutMapping("update_todo/{id}")
    public todo_db update_todos(@PathVariable("id") int id, @RequestBody todo_db todo) {
        //TODO: process PUT request
        
        this.todo_service_.update_todo(todo, id);
        return todo;
    }
    
}
