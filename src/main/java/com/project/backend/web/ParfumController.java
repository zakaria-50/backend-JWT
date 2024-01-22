package com.project.backend.web;



import com.project.backend.Config.ResourceNotFoundException;
import com.project.backend.entities.Parfum;
import com.project.backend.repository.ParfumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/web/store/")
public class ParfumController {

    @Autowired
    private ParfumRepository parfumRepository ;


    @GetMapping("/Parfums")
    public List<Parfum> getAllParfums(){


        return parfumRepository.findAll() ;
    }


    @PostMapping("/newParfum")
    public Parfum createparfum (@RequestBody Parfum parfum){

        return parfumRepository.save(parfum) ;
    }

    @GetMapping("/parfums/{id}")
    public ResponseEntity<Parfum> getParfumById(@PathVariable Long id){
        Parfum parfum = parfumRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Parfum does not exist with id:"+id));
        return ResponseEntity.ok(parfum) ;
    }
    @PutMapping("/parfums/{id}")
    public ResponseEntity<Parfum> updateParfum(@PathVariable Long id , @RequestBody Parfum parfumDetails){
    Parfum parfum = parfumRepository.findById(id).
            orElseThrow(()-> new ResourceNotFoundException("Parfum does not exist with this id:"+id));

    parfum.setName(parfumDetails.getName());
    parfum.setPrice(parfumDetails.getPrice());
    Parfum updatedParfum = parfumRepository.save(parfum) ;
    return ResponseEntity.ok(updatedParfum);

    }

    @DeleteMapping("/parfums/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteParfum(@PathVariable Long id){
        Parfum parfum = parfumRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Parfum not found"));
        parfumRepository.delete(parfum);
        Map<String,Boolean> response = new HashMap<>() ;
        response.put("deleted", Boolean.TRUE) ;
        return ResponseEntity.ok(response) ;
    }

}

