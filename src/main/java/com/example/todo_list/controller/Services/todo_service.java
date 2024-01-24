package com.example.todo_list.controller.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_list.dao.todo_list_reprository;
import com.example.todo_list.entities.todo_db;

@Service
public class todo_service {
    @Autowired
    private todo_list_reprository todo_repo;
    public List<todo_db> get_all_todos()
    {
        List<todo_db> todo_list = (List<todo_db>) this.todo_repo.findAll();
        return todo_list;
        
    }
    public todo_db add_todo(todo_db todo) {
        // TODO Auto-generated method stub
        todo_db todos = this.todo_repo.save(todo);
        return todos;
    }
    
    public void del_todo(int id){
        this.todo_repo.deleteById(id);
    }
    public void update_todo(todo_db todo, int id){
        todo.setId(id);
        this.todo_repo.save(todo);
    }
}
