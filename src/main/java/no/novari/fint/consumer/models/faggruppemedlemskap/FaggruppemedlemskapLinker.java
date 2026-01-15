package no.novari.fint.consumer.models.faggruppemedlemskap;

import no.novari.fint.model.resource.utdanning.timeplan.FaggruppemedlemskapResource;
import no.novari.fint.model.resource.utdanning.timeplan.FaggruppemedlemskapResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class FaggruppemedlemskapLinker extends FintLinker<FaggruppemedlemskapResource> {

    public FaggruppemedlemskapLinker() {
        super(FaggruppemedlemskapResource.class);
    }

    public void mapLinks(FaggruppemedlemskapResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FaggruppemedlemskapResources toResources(Collection<FaggruppemedlemskapResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FaggruppemedlemskapResources toResources(Stream<FaggruppemedlemskapResource> stream, int offset, int size, int totalItems) {
        FaggruppemedlemskapResources resources = new FaggruppemedlemskapResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FaggruppemedlemskapResource faggruppemedlemskap) {
        return getAllSelfHrefs(faggruppemedlemskap).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FaggruppemedlemskapResource faggruppemedlemskap) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(faggruppemedlemskap.getSystemId()) && !isEmpty(faggruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(faggruppemedlemskap.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(FaggruppemedlemskapResource faggruppemedlemskap) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(faggruppemedlemskap.getSystemId()) && !isEmpty(faggruppemedlemskap.getSystemId().getIdentifikatorverdi())) {
            builder.add(faggruppemedlemskap.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

