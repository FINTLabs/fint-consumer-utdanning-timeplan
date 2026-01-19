package no.novari.fint.consumer.models.fag;

import no.novari.fint.model.resource.utdanning.timeplan.FagResource;
import no.novari.fint.model.resource.utdanning.timeplan.FagResources;
import no.novari.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FagResources toResources(Stream<FagResource> stream, int offset, int size, int totalItems) {
        FagResources resources = new FagResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FagResource fag) {
        return getAllSelfHrefs(fag).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FagResource fag) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(fag.getSystemId()) && !isEmpty(fag.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(fag.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(FagResource fag) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(fag.getSystemId()) && !isEmpty(fag.getSystemId().getIdentifikatorverdi())) {
            builder.add(fag.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

