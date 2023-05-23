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
public class Trivia{

	@JsonProperty("response_code")
	private int responseCode;

	@JsonProperty("results")
	private List<ResultsItem> results;
}