package no.fint.consumer.models.time;

import no.fint.model.resource.utdanning.timeplan.TimeResource;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

@Component
public class TimeLinker extends FintLinker<TimeResource> {

    public TimeLinker() {
        super(TimeResource.class);
    }

    public void mapLinks(TimeResource resource) {
        super.mapLinks(resource);
    }
    
    @Override
    public String getSelfHref(TimeResource time) {
        if (time.getSystemId() != null && time.getSystemId().getIdentifikatorverdi() != null) {
            return createHrefWithId(time.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

