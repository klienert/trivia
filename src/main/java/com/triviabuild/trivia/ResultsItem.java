package com.triviabuild.trivia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ResultsItem{

	@JsonProperty("difficulty")
	private String difficulty;

	@JsonProperty("question")
	private String question;

	@JsonProperty("correct_answer")
	private String correctAnswer;

	@JsonProperty("incorrect_answers")
	private List<String> incorrectAnswers;

	@JsonProperty("category")
	private String category;

	@JsonProperty("type")
	private String type;
}