package com.triviabuild.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Difficulty")
@Table(name= "difficulty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Difficulty {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column
    private String difficulty;

    //additional constructor

    public Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
