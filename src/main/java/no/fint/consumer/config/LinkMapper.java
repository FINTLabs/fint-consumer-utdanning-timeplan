package no.fint.consumer.config;

import com.google.common.collect.ImmutableMap;
import no.fint.consumer.utils.RestEndpoints;
import no.fint.model.utdanning.elev.Elevforhold;
import no.fint.model.utdanning.elev.Medlemskap;
import no.fint.model.utdanning.elev.Undervisningsforhold;
import no.fint.model.utdanning.kodeverk.Skolear;
import no.fint.model.utdanning.kodeverk.Termin;
import no.fint.model.utdanning.kodeverk.Vigoreferanse;
import no.fint.model.utdanning.timeplan.*;
import no.fint.model.utdanning.utdanningsprogram.Programomrade;
import no.fint.model.utdanning.utdanningsprogram.Skole;
import no.fint.model.utdanning.vurdering.Eksamensgruppe;

import java.util.Map;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String, String>builder()
                .put(Fag.class.getName(), contextPath + RestEndpoints.FAG)
                .put(Rom.class.getName(), contextPath + RestEndpoints.ROM)
                .put(Time.class.getName(), contextPath + RestEndpoints.TIME)
                .put(Undervisningsgruppe.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPE)
                .put(Undervisningsgruppemedlemskap.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPEMEDLEMSKAP)
                .put(Skolear.class.getName(), "/utdanning/kodeverk/skolear")
                .put(Termin.class.getName(), "/utdanning/kodeverk/termin")
                .put(Programomrade.class.getName(), "/utdanning/utdanningsprogram/programomrade")
                .put(Skole.class.getName(), "/utdanning/utdanningsprogram/skole")
                .put(Eksamensgruppe.class.getName(), "/utdanning/vurdering/eksamensgruppe")
                .put(Undervisningsforhold.class.getName(), "/utdanning/elev/undervisningsforhold")
                .put(Elevforhold.class.getName(), "/utdanning/elev/elevforhold")
                .put(Medlemskap.class.getName(), "/utdanning/elev/medlemskap")
                .put(Vigoreferanse.class.getName(), "/utdanning/vigo/kodeverk")
                .build();
    }

}
