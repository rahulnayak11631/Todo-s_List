package com.example.todo_list.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.todo_list.entities.todo_db;


public interface todo_list_reprository extends CrudRepository<todo_db,Integer> {
    public todo_db findById(int id);
}
