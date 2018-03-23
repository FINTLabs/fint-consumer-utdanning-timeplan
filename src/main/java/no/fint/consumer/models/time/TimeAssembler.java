package no.fint.consumer.models.time;

import no.fint.model.utdanning.timeplan.Time;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class TimeAssembler extends FintResourceAssembler<Time> {

    public TimeAssembler() {
        super(TimeController.class);
    }


    @Override
    public FintResourceSupport assemble(Time time , FintResource<Time> fintResource) {
        return createResourceWithId(time.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

