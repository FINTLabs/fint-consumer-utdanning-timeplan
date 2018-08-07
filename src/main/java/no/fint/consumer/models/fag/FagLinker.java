package no.fint.consumer.models.fag;

import no.fint.model.resource.utdanning.timeplan.FagResource;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

@Component
public class FagLinker extends FintLinker<FagResource> {

    public FagLinker() {
        super(FagResource.class);
    }

    public void mapLinks(FagResource resource) {
        super.mapLinks(resource);
    }
    
    @Override
    public String getSelfHref(FagResource fag) {
        if (fag.getSystemId() != null && fag.getSystemId().getIdentifikatorverdi() != null) {
            return createHrefWithId(fag.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

