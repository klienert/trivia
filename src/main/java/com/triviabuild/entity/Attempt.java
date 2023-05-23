package com.triviabuild.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Attempt")
@Table(name= "attempt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Attempt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "attempt_date")
    private Date attemptDate;

    @Column(name = "finished_date")
    private Date finishedDate;

    @Column
    private int score;

    @ManyToOne
    @JoinColumn(name = "User_id", foreignKey = @ForeignKey(name = "Attempt_User"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "Quiz_id", foreignKey = @ForeignKey(name = "Attempt_Quiz"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Quiz quiz;

    // additional constructors
    public Attempt(Date attemptDate, int score) {
        this.attemptDate = attemptDate;
        this.score = score;
    }
    public Attempt(Date attemptDate, int score, User user, Quiz quiz) {
        this.attemptDate = attemptDate;
        this.score = score;
        this.user = user;
        this.quiz = quiz;
    }

    public Attempt(Date attemptDate, Date finishedDate, int score, User user, Quiz quiz) {
        this.attemptDate = attemptDate;
        this.finishedDate = finishedDate;
        this.score = score;
        this.user = user;
        this.quiz = quiz;
    }
}
