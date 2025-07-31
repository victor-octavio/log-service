package project.logservice.shared.mapper;

import project.logservice.domain.model.LogEvent;
import project.logservice.interfaces.rest.dto.LogEventRequest;
import project.logservice.interfaces.rest.dto.LogEventResponse;

public class LogEventMapper {

  public static LogEvent toDomain(LogEventRequest request) {
    return LogEvent.builder()
        .level(request.getLevel())
        .message(request.getMessage())
        .timestamp(request.getTimestamp())
        .metadata(request.getMetadata())
        .application(request.getApplication())
        .build();
  }

  public static LogEventResponse toResponse(LogEvent logEvent) {
    return LogEventResponse.builder()
        .id(logEvent.getId())
        .application(logEvent.getApplication())
        .level(logEvent.getLevel())
        .message(logEvent.getMessage())
        .timestamp(logEvent.getTimestamp())
        .metadata(logEvent.getMetadata())
        .build();
  }


}
