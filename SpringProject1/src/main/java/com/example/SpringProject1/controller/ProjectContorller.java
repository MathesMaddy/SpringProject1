package com.example.SpringProject1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProject1.model.Model;
import com.example.SpringProject1.repository.Project1Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")

public class ProjectContorller {
    @Autowired
    Project1Repository project1Repository;

    @GetMapping("/show_all")
    public List<Model> getAllModel(){
        return (List<Model>) project1Repository.findAll();
    }

    @PostMapping("/create_new")
    public ResponseEntity<Model> createModel(@RequestBody Model model){
        Model _Model = project1Repository
            .save(new Model(model.getUsername(),model.getFirstname(),model.getLastname(),model.getAge()));
            return new ResponseEntity<Model>(_Model, HttpStatus.OK);
        
    }

    @DeleteMapping("/delete_all")
    public ResponseEntity<HttpStatus> deleteAllModel(){
        project1Repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/insert/{id}")

    public ResponseEntity<Model> updateModel(@PathVariable("id") Long id,@RequestBody Model model){
        Optional<Model> __model=project1Repository.findById(id);
        if(__model.isPresent()){

            Model _model = __model.get();

            _model.setUsername(model.getUsername());
            _model.setFirstname(model.getFirstname());

            _model.setLastname(model.getLastname());
            _model.setAge(model.getAge());

            return new ResponseEntity<>(project1Repository.save(_model),HttpStatus.OK);           

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
