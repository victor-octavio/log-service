package project.logservice.infraestructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.logservice.domain.model.Level;
import project.logservice.domain.model.LogEvent;

import java.time.Instant;
import java.util.List;

public interface MongoLogSpringRepository extends MongoRepository<LogEvent, String> {
  List<LogEvent> findByApplicationAndLevelAndTimestampBetween(String application, Level level, Instant timestamp, Instant timestamp2);
}
