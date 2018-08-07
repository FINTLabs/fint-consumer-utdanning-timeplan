package no.fint.consumer.models.time;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import no.fint.audit.FintAuditService;

import no.fint.consumer.config.Constants;
import no.fint.consumer.config.ConsumerProps;
import no.fint.consumer.event.ConsumerEventUtil;
import no.fint.consumer.exceptions.*;
import no.fint.consumer.status.StatusCache;
import no.fint.consumer.utils.RestEndpoints;

import no.fint.event.model.*;

import no.fint.relations.FintRelationsMediaType;
import no.fint.relations.FintResources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.UnknownHostException;
import java.net.URI;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import no.fint.model.resource.utdanning.timeplan.TimeResource;
import no.fint.model.utdanning.timeplan.TimeplanActions;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = RestEndpoints.TIME, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TimeController {

    @Autowired
    private TimeCacheService cacheService;

    @Autowired
    private FintAuditService fintAuditService;

    @Autowired
    private TimeLinker linker;

    @Autowired
    private ConsumerProps props;

    @Autowired
    private StatusCache statusCache;

    @Autowired
    private ConsumerEventUtil consumerEventUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/last-updated")
    public Map<String, String> getLastUpdated(@RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId) {
        if (props.isOverrideOrgId() || orgId == null) {
            orgId = props.getDefaultOrgId();
        }
        String lastUpdated = Long.toString(cacheService.getLastUpdated(orgId));
        return ImmutableMap.of("lastUpdated", lastUpdated);
    }

    @GetMapping("/cache/size")
     public ImmutableMap<String, Integer> getCacheSize(@RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId) {
        if (props.isOverrideOrgId() || orgId == null) {
            orgId = props.getDefaultOrgId();
        }
        return ImmutableMap.of("size", cacheService.getAll(orgId).size());
    }

    @PostMapping("/cache/rebuild")
    public void rebuildCache(@RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId) {
        if (props.isOverrideOrgId() || orgId == null) {
            orgId = props.getDefaultOrgId();
        }
        cacheService.rebuildCache(orgId);
    }

    @GetMapping
    public FintResources getTime(
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client,
            @RequestParam(required = false) Long sinceTimeStamp) {
        if (props.isOverrideOrgId() || orgId == null) {
            orgId = props.getDefaultOrgId();
        }
        if (client == null) {
            client = props.getDefaultClient();
        }
        log.debug("OrgId: {}, Client: {}", orgId, client);

        Event event = new Event(orgId, Constants.COMPONENT, TimeplanActions.GET_ALL_TIME, client);
        fintAuditService.audit(event);

        fintAuditService.audit(event, Status.CACHE);

        List<TimeResource> time;
        if (sinceTimeStamp == null) {
            time = cacheService.getAll(orgId);
        } else {
            time = cacheService.getAll(orgId, sinceTimeStamp);
        }

        fintAuditService.audit(event, Status.CACHE_RESPONSE, Status.SENT_TO_CLIENT);

        return linker.toResources(time);
    }


    @GetMapping("/systemid/{id:.+}")
    public TimeResource getTimeBySystemId(
            @PathVariable String id,
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client) {
        if (props.isOverrideOrgId() || orgId == null) {
            orgId = props.getDefaultOrgId();
        }
        if (client == null) {
            client = props.getDefaultClient();
        }
        log.debug("SystemId: {}, OrgId: {}, Client: {}", id, orgId, client);

        Event event = new Event(orgId, Constants.COMPONENT, TimeplanActions.GET_TIME, client);
        event.setQuery("systemid/" + id);
        fintAuditService.audit(event);

        fintAuditService.audit(event, Status.CACHE);

        Optional<TimeResource> time = cacheService.getTimeBySystemId(orgId, id);

        fintAuditService.audit(event, Status.CACHE_RESPONSE, Status.SENT_TO_CLIENT);

        return time.map(linker::toResource).orElseThrow(() -> new EntityNotFoundException(id));
    }




    //
    // Exception handlers
    //
    @ExceptionHandler(UpdateEntityMismatchException.class)
    public ResponseEntity handleUpdateEntityMismatch(Exception e) {
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFound(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }

    @ExceptionHandler(CreateEntityMismatchException.class)
    public ResponseEntity handleCreateEntityMismatch(Exception e) {
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(EntityFoundException.class)
    public ResponseEntity handleEntityFound(Exception e) {
        return ResponseEntity.status(HttpStatus.FOUND).body(e);
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity handleNameNotFound(Exception e) {
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity handleUnkownHost(Exception e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e);
    }

}

