package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import no.fint.model.utdanning.elev.Medlemskap;
import no.fint.model.utdanning.elev.Undervisningsforhold;
import no.fint.model.utdanning.timeplan.Fag;
import no.fint.model.utdanning.timeplan.Rom;
import no.fint.model.utdanning.timeplan.Time;
import no.fint.model.utdanning.timeplan.Undervisningsgruppe;
import no.fint.model.utdanning.utdanningsprogram.Programomrade;
import no.fint.model.utdanning.utdanningsprogram.Skole;
import no.fint.model.utdanning.vurdering.Eksamensgruppe;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String, String>builder()
                .put(Fag.class.getName(), contextPath + RestEndpoints.FAG)
                .put(Rom.class.getName(), contextPath + RestEndpoints.ROM)
                .put(Time.class.getName(), contextPath + RestEndpoints.TIME)
                .put(Undervisningsgruppe.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPE)
                .put(Programomrade.class.getName(), "/utdanning/utdanningsprogram/programomrade")
                .put(Skole.class.getName(), "/utdanning/utdanningsprogram/skole")
                .put(Eksamensgruppe.class.getName(), "/utdanning/vurdering/eksamensgruppe")
                .put(Undervisningsforhold.class.getName(), "/utdanning/elev/undervisningsforhold")
                .put(Medlemskap.class.getName(), "/utdanning/elev/medlemskap")
                .build();
    }

}
