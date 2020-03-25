package no.fint.consumer.models.undervisningsgruppe;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppeResource;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return getAllSelfHrefs(undervisningsgruppe).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(UndervisningsgruppeResource undervisningsgruppe) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(undervisningsgruppe.getSystemId()) && !isEmpty(undervisningsgruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(undervisningsgruppe.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(UndervisningsgruppeResource undervisningsgruppe) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(undervisningsgruppe.getSystemId()) && !isEmpty(undervisningsgruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(undervisningsgruppe.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

