package no.fint.consumer.models.time;

import no.fint.model.resource.utdanning.timeplan.TimeResource;
import no.fint.model.resource.utdanning.timeplan.TimeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class TimeLinker extends FintLinker<TimeResource> {

    public TimeLinker() {
        super(TimeResource.class);
    }

    public void mapLinks(TimeResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public TimeResources toResources(Collection<TimeResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public TimeResources toResources(Stream<TimeResource> stream, int offset, int size, int totalItems) {
        TimeResources resources = new TimeResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(TimeResource time) {
        return getAllSelfHrefs(time).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(TimeResource time) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(time.getSystemId()) && !isEmpty(time.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(time.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(TimeResource time) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(time.getSystemId()) && !isEmpty(time.getSystemId().getIdentifikatorverdi())) {
            builder.add(time.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

