package no.fint.consumer.models.rom;

import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.timeplan.RomResource;
import no.fint.model.resource.utdanning.timeplan.RomResources;
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
        RomResources resources = new RomResources();
        collection.stream().map(this::toResource).forEach(resources::addResource);
        resources.addSelf(Link.with(self()));
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

