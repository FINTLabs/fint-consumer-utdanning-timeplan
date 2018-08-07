package no.fint.consumer.models.rom;

import no.fint.model.resource.utdanning.timeplan.RomResource;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

@Component
public class RomLinker extends FintLinker<RomResource> {

    public RomLinker() {
        super(RomResource.class);
    }

    public void mapLinks(RomResource resource) {
        super.mapLinks(resource);
    }
    
    @Override
    public String getSelfHref(RomResource rom) {
        if (rom.getSystemId() != null && rom.getSystemId().getIdentifikatorverdi() != null) {
            return createHrefWithId(rom.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

