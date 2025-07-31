package project.logservice.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "log_events")
@Data
@Builder
public class LogEvent {
  @Id
  private String id;
  private String application;
  private Level level;
  private String message;
  private Instant timestamp;
  private Map<String, Object> metadata;
}
