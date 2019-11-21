package no.fint.consumer.models.time;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.TimeResource;
import no.fint.model.resource.utdanning.timeplan.TimeResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;

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
        TimeResources resources = new TimeResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
        return resources;
    }

    @Override
    public String getSelfHref(TimeResource time) {
        if (!isNull(time.getSystemId()) && !isEmpty(time.getSystemId().getIdentifikatorverdi())) {
            return createHrefWithId(time.getSystemId().getIdentifikatorverdi(), "systemid");
        }
        
        return null;
    }

    int[] hashCodes(TimeResource time) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(time.getSystemId()) && !isEmpty(time.getSystemId().getIdentifikatorverdi())) {
            builder.add(time.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

