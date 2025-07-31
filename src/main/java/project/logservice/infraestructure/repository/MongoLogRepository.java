package project.logservice.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.logservice.domain.model.Level;
import project.logservice.domain.model.LogEvent;
import project.logservice.domain.repository.LogRepository;

import java.time.Instant;
import java.util.List;

@Repository
public class MongoLogRepository implements LogRepository {
  private final MongoLogSpringRepository springRepository;

  public MongoLogRepository(MongoLogSpringRepository springRepository) {
    this.springRepository = springRepository;
  }

  @Override
  public LogEvent save(LogEvent logEvent) {
    return springRepository.save(logEvent);
  }

  @Override
  public List<LogEvent> findAll() {
    return springRepository.findAll();
  }

  @Override
  public List<LogEvent> findByApplicationAndLevelAndTimestampBetween(String application, Level level, Instant start, Instant end) {
    return springRepository.findByApplicationAndLevelAndTimestampBetween(application, level, start, end);
  }
}
