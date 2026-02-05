package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {
    ReportType type;
    String player;
    Map<String, Float> outcome;
}
