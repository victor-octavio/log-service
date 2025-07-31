package project.logservice.interfaces.rest.dto;

import lombok.Data;
import project.logservice.domain.model.Level;

import java.time.Instant;
import java.util.Map;

@Data
public class LogEventRequest {
  private String application;
  private Level level;
  private String message;
  private Instant timestamp;
  private Map<String, Object> metadata;
}
