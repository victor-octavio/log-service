package project.logservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.logservice.domain.model.Level;
import project.logservice.domain.model.LogEvent;
import project.logservice.domain.repository.LogRepository;
import project.logservice.interfaces.rest.dto.LogSearchRequest;

import java.time.Instant;
import java.util.List;

@Service
public class LogService {

  @Autowired
  private LogRepository logRepository;

  public LogEvent createLog(LogEvent logEvent) {
    if (logEvent.getTimestamp() == null) {
      logEvent.setTimestamp(Instant.now());
    }
    return logRepository.save(logEvent);
  }

  public List<LogEvent> searchLogs(LogSearchRequest logSearchRequest) {
    return logRepository
            .findByApplicationAndLevelAndTimestampBetween(
                    logSearchRequest.application(),
                    logSearchRequest.level(),
                    logSearchRequest.start(),
                    logSearchRequest.end()
            );
  }
}
