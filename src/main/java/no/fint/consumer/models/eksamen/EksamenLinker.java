package no.fint.consumer.models.eksamen;

import no.fint.model.resource.utdanning.timeplan.EksamenResource;
import no.fint.model.resource.utdanning.timeplan.EksamenResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class EksamenLinker extends FintLinker<EksamenResource> {

    public EksamenLinker() {
        super(EksamenResource.class);
    }

    public void mapLinks(EksamenResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public EksamenResources toResources(Collection<EksamenResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public EksamenResources toResources(Stream<EksamenResource> stream, int offset, int size, int totalItems) {
        EksamenResources resources = new EksamenResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(EksamenResource eksamen) {
        return getAllSelfHrefs(eksamen).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(EksamenResource eksamen) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(eksamen.getSystemId()) && !isEmpty(eksamen.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(eksamen.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(EksamenResource eksamen) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(eksamen.getSystemId()) && !isEmpty(eksamen.getSystemId().getIdentifikatorverdi())) {
            builder.add(eksamen.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

