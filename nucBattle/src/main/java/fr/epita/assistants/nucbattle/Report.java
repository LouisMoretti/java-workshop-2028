package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {
    ReportType type;
    String player;
    Map<String, Integer> outcome;
}
