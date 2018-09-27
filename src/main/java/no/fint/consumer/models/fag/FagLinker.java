package no.fint.consumer.models.fag;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.FagResource;
import no.fint.model.resource.utdanning.timeplan.FagResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;


@Component
public class FagLinker extends FintLinker<FagResource> {

    public FagLinker() {
        super(FagResource.class);
    }

    public void mapLinks(FagResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FagResources toResources(Collection<FagResource> collection) {
        FagResources resources = new FagResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(FagResource fag) {
        if (!isNull(fag.getSystemId()) && !isEmpty(fag.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(fag.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

