package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import no.fint.model.utdanning.timeplan.Eksamen;
import no.fint.model.utdanning.timeplan.Fag;
import no.fint.model.utdanning.timeplan.Faggruppe;
import no.fint.model.utdanning.timeplan.Faggruppemedlemskap;
import no.fint.model.utdanning.timeplan.Rom;
import no.fint.model.utdanning.timeplan.Time;
import no.fint.model.utdanning.timeplan.Undervisningsgruppe;
import no.fint.model.utdanning.timeplan.Undervisningsgruppemedlemskap;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String,String>builder()
            .put(Eksamen.class.getName(), contextPath + RestEndpoints.EKSAMEN)
            .put(Fag.class.getName(), contextPath + RestEndpoints.FAG)
            .put(Faggruppe.class.getName(), contextPath + RestEndpoints.FAGGRUPPE)
            .put(Faggruppemedlemskap.class.getName(), contextPath + RestEndpoints.FAGGRUPPEMEDLEMSKAP)
            .put(Rom.class.getName(), contextPath + RestEndpoints.ROM)
            .put(Time.class.getName(), contextPath + RestEndpoints.TIME)
            .put(Undervisningsgruppe.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPE)
            .put(Undervisningsgruppemedlemskap.class.getName(), contextPath + RestEndpoints.UNDERVISNINGSGRUPPEMEDLEMSKAP)
            .put("no.fint.model.utdanning.vurdering.Eksamensgruppe", "/utdanning/vurdering/eksamensgruppe")
            .put("no.fint.model.utdanning.utdanningsprogram.Programomrade", "/utdanning/utdanningsprogram/programomrade")
            .put("no.fint.model.utdanning.elev.Elevtilrettelegging", "/utdanning/elev/elevtilrettelegging")
            .put("no.fint.model.utdanning.utdanningsprogram.Skole", "/utdanning/utdanningsprogram/skole")
            .put("no.fint.model.utdanning.elev.Medlemskap", "/utdanning/elev/medlemskap")
            .put("no.fint.model.utdanning.kodeverk.Skolear", "/utdanning/kodeverk/skolear")
            .put("no.fint.model.utdanning.kodeverk.Fagmerknad", "/utdanning/kodeverk/fagmerknad")
            .put("no.fint.model.utdanning.kodeverk.Fagstatus", "/utdanning/kodeverk/fagstatus")
            .put("no.fint.model.utdanning.elev.Elevforhold", "/utdanning/elev/elevforhold")
            .put("no.fint.model.utdanning.elev.Varsel", "/utdanning/elev/varsel")
            .put("no.fint.model.utdanning.elev.Undervisningsforhold", "/utdanning/elev/undervisningsforhold")
            .put("no.fint.model.utdanning.kodeverk.Termin", "/utdanning/kodeverk/termin")
            /* .put(TODO,TODO) */
            .build();
    }

}
