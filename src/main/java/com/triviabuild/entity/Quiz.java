package com.triviabuild.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Quiz")
@Table(name= "quiz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Quiz {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="Category_id", foreignKey = @ForeignKey(name = "Quiz_Category"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Difficulty_id", foreignKey = @ForeignKey(name = "Quiz_Difficulty"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "User_id", foreignKey = @ForeignKey(name = "Quiz_User"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Column(name = "created_at")
    private Date createdAt;

    // additional constructors
    public Quiz (String description, Category category, Difficulty difficulty, User user, Date createdAt) {
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Quiz (String description, Date createdAt) {
        this.description = description;
        this.createdAt = createdAt;
        // This is just for testing...
    }
}
