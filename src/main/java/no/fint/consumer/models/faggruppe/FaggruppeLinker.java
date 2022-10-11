package no.fint.consumer.models.faggruppe;

import no.fint.model.resource.utdanning.timeplan.FaggruppeResource;
import no.fint.model.resource.utdanning.timeplan.FaggruppeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class FaggruppeLinker extends FintLinker<FaggruppeResource> {

    public FaggruppeLinker() {
        super(FaggruppeResource.class);
    }

    public void mapLinks(FaggruppeResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FaggruppeResources toResources(Collection<FaggruppeResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FaggruppeResources toResources(Stream<FaggruppeResource> stream, int offset, int size, int totalItems) {
        FaggruppeResources resources = new FaggruppeResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FaggruppeResource faggruppe) {
        return getAllSelfHrefs(faggruppe).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FaggruppeResource faggruppe) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(faggruppe.getSystemId()) && !isEmpty(faggruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(faggruppe.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(FaggruppeResource faggruppe) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(faggruppe.getSystemId()) && !isEmpty(faggruppe.getSystemId().getIdentifikatorverdi())) {
            builder.add(faggruppe.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

