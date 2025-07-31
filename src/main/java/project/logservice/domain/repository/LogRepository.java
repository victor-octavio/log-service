package project.logservice.domain.repository;

import lombok.extern.java.Log;
import project.logservice.domain.model.Level;
import project.logservice.domain.model.LogEvent;

import java.time.Instant;
import java.util.List;

public interface LogRepository {
  LogEvent save(LogEvent logEvent);
  List<LogEvent> findAll();
  List<LogEvent> findByApplicationAndLevelAndTimestampBetween(String application, Level level, Instant start, Instant end);
}
