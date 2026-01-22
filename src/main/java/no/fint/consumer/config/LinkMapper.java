package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import no.novari.fint.model.utdanning.timeplan.Eksamen;
import no.novari.fint.model.utdanning.timeplan.Fag;
import no.novari.fint.model.utdanning.timeplan.Faggruppe;
import no.novari.fint.model.utdanning.timeplan.Faggruppemedlemskap;
import no.novari.fint.model.utdanning.timeplan.Rom;
import no.novari.fint.model.utdanning.timeplan.Time;
import no.novari.fint.model.utdanning.timeplan.Undervisningsgruppe;
import no.novari.fint.model.utdanning.timeplan.Undervisningsgruppemedlemskap;

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
            .put("no.novari.fint.model.utdanning.vurdering.Eksamensgruppe", "/model/utdanning/vurdering/eksamensgruppe")
            .put("no.novari.fint.model.utdanning.utdanningsprogram.Programomrade", "/model/utdanning/utdanningsprogram/programomrade")
            .put("no.novari.fint.model.utdanning.elev.Elevtilrettelegging", "/model/utdanning/elev/elevtilrettelegging")
            .put("no.novari.fint.model.utdanning.utdanningsprogram.Skole", "/model/utdanning/utdanningsprogram/skole")
            .put("no.novari.fint.model.utdanning.kodeverk.Skolear", "/model/utdanning/kodeverk/skolear")
            .put("no.novari.fint.model.utdanning.kodeverk.Fagmerknad", "/model/utdanning/kodeverk/fagmerknad")
            .put("no.novari.fint.model.utdanning.kodeverk.Fagstatus", "/model/utdanning/kodeverk/fagstatus")
            .put("no.novari.fint.model.utdanning.elev.Elevforhold", "/model/utdanning/elev/elevforhold")
            .put("no.novari.fint.model.utdanning.elev.Varsel", "/model/utdanning/elev/varsel")
            .put("no.novari.fint.model.utdanning.elev.Undervisningsforhold", "/model/utdanning/elev/undervisningsforhold")
            .put("no.novari.fint.model.utdanning.kodeverk.Termin", "/model/utdanning/kodeverk/termin")
            /* .put(TODO,TODO) */
            .build();
    }

}
