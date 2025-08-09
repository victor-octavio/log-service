package project.logservice.interfaces.rest.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import project.logservice.domain.model.Level;

import java.time.Instant;

public record LogSearchRequest(
        @NotBlank String application,
        Level level,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant start,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        Instant end
) {
    @AssertTrue(message = "start time should be less or equal end time")
    public boolean isStartBeforeEnd() {
        return start == null || end == null || !start.isAfter(end);
    }
}
