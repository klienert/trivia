package com.triviabuild.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Category")
@Table(name= "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // not auto-incremented...
    private int id;

    @Column
    private String topic;

    // additional constructor

    public Category (String topic) {
        this.topic = topic;
    }

}
