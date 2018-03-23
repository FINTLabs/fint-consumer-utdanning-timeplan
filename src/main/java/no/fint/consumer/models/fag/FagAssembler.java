package no.fint.consumer.models.fag;

import no.fint.model.utdanning.timeplan.Fag;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class FagAssembler extends FintResourceAssembler<Fag> {

    public FagAssembler() {
        super(FagController.class);
    }


    @Override
    public FintResourceSupport assemble(Fag fag , FintResource<Fag> fintResource) {
        return createResourceWithId(fag.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

