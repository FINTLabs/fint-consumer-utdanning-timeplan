package no.fint.consumer.models.undervisningsgruppe;

import no.fint.model.utdanning.timeplan.Undervisningsgruppe;
import no.fint.model.relation.FintResource;
import no.fint.relations.FintResourceAssembler;
import no.fint.relations.FintResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class UndervisningsgruppeAssembler extends FintResourceAssembler<Undervisningsgruppe> {

    public UndervisningsgruppeAssembler() {
        super(UndervisningsgruppeController.class);
    }


    @Override
    public FintResourceSupport assemble(Undervisningsgruppe undervisningsgruppe , FintResource<Undervisningsgruppe> fintResource) {
        return createResourceWithId(undervisningsgruppe.getSystemId().getIdentifikatorverdi(), fintResource, "systemid");
    }
    
    
    
}

