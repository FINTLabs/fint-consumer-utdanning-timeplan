package no.fint.consumer.models.undervisningsgruppe;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppeResource;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;


@Component
public class UndervisningsgruppeLinker extends FintLinker<UndervisningsgruppeResource> {

    public UndervisningsgruppeLinker() {
        super(UndervisningsgruppeResource.class);
    }

    public void mapLinks(UndervisningsgruppeResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public UndervisningsgruppeResources toResources(Collection<UndervisningsgruppeResource> collection) {
        UndervisningsgruppeResources resources = new UndervisningsgruppeResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(UndervisningsgruppeResource undervisningsgruppe) {
        if (!isNull(undervisningsgruppe.getSystemId()) && !isEmpty(undervisningsgruppe.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(undervisningsgruppe.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

