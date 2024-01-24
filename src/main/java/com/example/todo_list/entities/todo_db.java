package com.example.todo_list.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_app")
public class todo_db {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    private int id;
    private String Task;
    public todo_db(int id, String task) {
        this.id = id;
        Task = task;
    }
    public todo_db() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTask() {
        return Task;
    }
    public void setTask(String task) {
        Task = task;
    }
    @Override
    public String toString() {
        return "todo_db [id=" + id + ", Task=" + Task + "]";
    }
    

}
