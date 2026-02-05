package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ReportType {
    @JsonProperty("winner") WINNER,
    @JsonProperty("cheater") CHEATER,
    @JsonProperty("error") ERROR,
    @JsonProperty("unfinished") UNFINISHED;
}
