package project.logservice.interfaces.rest;

import ch.qos.logback.core.status.InfoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.logservice.application.LogService;
import project.logservice.domain.model.Level;
import project.logservice.domain.model.LogEvent;
import project.logservice.interfaces.rest.dto.LogEventRequest;
import project.logservice.interfaces.rest.dto.LogEventResponse;
import project.logservice.interfaces.rest.dto.LogSearchRequest;
import project.logservice.shared.mapper.LogEventMapper;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class LogController {
  private final LogService logService;

  public LogController(LogService logService) {
    this.logService = logService;
  }

  @PostMapping
  public ResponseEntity<LogEventResponse> createLog(@RequestBody LogEventRequest logEventRequest) {
    LogEvent logEvent = LogEventMapper.toDomain(logEventRequest);
    return ResponseEntity.status(201).body(LogEventMapper.toResponse(logService.createLog(logEvent)));
  }

  @GetMapping
  public ResponseEntity<List<LogEventResponse>> getLog(@RequestBody LogSearchRequest searchRequest) {
    List<LogEvent> logs = logService.searchLogs(searchRequest);
    List<LogEventResponse> responses = logs.stream()
        .map(LogEventMapper::toResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(responses);
  }
}
