package no.fint.consumer.models.rom;

import no.fint.model.utdanning.timeplan.Rom;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class RomAssembler extends FintResourceAssembler<Rom> {

    public RomAssembler() {
        super(RomController.class);
    }


    @Override
    public FintResourceSupport assemble(Rom rom , FintResource<Rom> fintResource) {
        return createResourceWithId(rom.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

