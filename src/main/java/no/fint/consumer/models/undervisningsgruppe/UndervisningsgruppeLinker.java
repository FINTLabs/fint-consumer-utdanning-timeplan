package no.fint.consumer.models.undervisningsgruppe;

import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppeResource;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

@Component
public class UndervisningsgruppeLinker extends FintLinker<UndervisningsgruppeResource> {

    public UndervisningsgruppeLinker() {
        super(UndervisningsgruppeResource.class);
    }

    public void mapLinks(UndervisningsgruppeResource resource) {
        super.mapLinks(resource);
    }
    
    @Override
    public String getSelfHref(UndervisningsgruppeResource undervisningsgruppe) {
        if (undervisningsgruppe.getSystemId() != null && undervisningsgruppe.getSystemId().getIdentifikatorverdi() != null) {
            return createHrefWithId(undervisningsgruppe.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }
    
}

