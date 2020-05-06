package no.fint.consumer.models.undervisningsgruppemedlemskap;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppemedlemskapResource;
import no.fint.model.resource.utdanning.timeplan.UndervisningsgruppemedlemskapResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class UndervisningsgruppemedlemskapLinker extends FintLinker<UndervisningsgruppemedlemskapResource> {

    public UndervisningsgruppemedlemskapLinker() {
        super(UndervisningsgruppemedlemskapResource.class);
    }

    public void mapLinks(UndervisningsgruppemedlemskapResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public UndervisningsgruppemedlemskapResources toResources(Collection<UndervisningsgruppemedlemskapResource> collection) {
        UndervisningsgruppemedlemskapResources resources = new UndervisningsgruppemedlemskapResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(UndervisningsgruppemedlemskapResource undervisningsgruppemedlemskap) {
        return getAllSelfHrefs(undervisningsgruppemedlemskap).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(UndervisningsgruppemedlemskapResource undervisningsgruppemedlemskap) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(undervisningsgruppemedlemskap.getSystemId()) && !isEmpty(undervisningsgruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(undervisningsgruppemedlemskap.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(UndervisningsgruppemedlemskapResource undervisningsgruppemedlemskap) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(undervisningsgruppemedlemskap.getSystemId()) && !isEmpty(undervisningsgruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(undervisningsgruppemedlemskap.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

