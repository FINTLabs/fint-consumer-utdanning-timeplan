package no.fint.consumer.models.rom;

import no.novari.fint.model.resource.utdanning.timeplan.RomResource;
import no.novari.fint.model.resource.utdanning.timeplan.RomResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class RomLinker extends FintLinker<RomResource> {

    public RomLinker() {
        super(RomResource.class);
    }

    public void mapLinks(RomResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public RomResources toResources(Collection<RomResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public RomResources toResources(Stream<RomResource> stream, int offset, int size, int totalItems) {
        RomResources resources = new RomResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(RomResource rom) {
        return getAllSelfHrefs(rom).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(RomResource rom) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(rom.getSystemId()) && !isEmpty(rom.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(rom.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(RomResource rom) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(rom.getSystemId()) && !isEmpty(rom.getSystemId().getIdentifikatorverdi())) {
            builder.add(rom.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

