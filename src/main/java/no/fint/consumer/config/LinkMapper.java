package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

import no.fint.model.utdanning.timeplan.*;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String,String>builder()
            .put(Fag.class.getName(), contextPath + RestEndpoints.FAG)
            .put(Rom.class.getName(), contextPath + RestEndpoints.ROM)
            .put(Time.class.getName(), contextPath + RestEndpoints.TIME)
            .put(Undervisningsgruppe.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPE)
            .put(Undervisningsgruppemedlemskap.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPEMEDLEMSKAP)
            .put("no.fint.model.utdanning.utdanningsprogram.Programomrade", "/utdanning/utdanningsprogram/programomrade")
            .put("no.fint.model.utdanning.utdanningsprogram.Skole", "/utdanning/utdanningsprogram/skole")
            .put("no.fint.model.utdanning.vurdering.Eksamensgruppe", "/utdanning/vurdering/eksamensgruppe")
            .put("no.fint.model.utdanning.elev.Medlemskap", "/utdanning/elev/medlemskap")
            .put("no.fint.model.utdanning.elev.Undervisningsforhold", "/utdanning/elev/undervisningsforhold")
            .put("no.fint.model.utdanning.elev.Elevforhold", "/utdanning/elev/elevforhold")
            .put("no.fint.model.utdanning.kodeverk.Termin", "/utdanning/kodeverk/termin")
            .put("no.fint.model.utdanning.kodeverk.Skolear", "/utdanning/kodeverk/skolear")
            /* .put(TODO,TODO) */
            .build();
    }

}
