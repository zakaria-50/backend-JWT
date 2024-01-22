package com.project.backend.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "parfums")

public class Parfum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id  ;
    @JsonProperty("name")
    private String name ;
    @JsonProperty("price")
    private double price ;
}
