package no.fint.consumer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConsumerProps {
    
    @Value("${fint.consumer.override-org-id:false}")
    private boolean overrideOrgId;

    @Value("${fint.consumer.default-client:FINT}")
    private String defaultClient;

    @Value("${fint.consumer.default-org-id:fint.no}")
    private String defaultOrgId;
    
    @Value("${fint.events.orgIds:fint.no}")
    private String[] orgs;

    
    public static final String CACHE_INITIALDELAY_FAG = "${fint.consumer.cache.initialDelay.fag:60000}";
    public static final String CACHE_FIXEDRATE_FAG = "${fint.consumer.cache.fixedRate.fag:900000}";
    
    public static final String CACHE_INITIALDELAY_ROM = "${fint.consumer.cache.initialDelay.rom:70000}";
    public static final String CACHE_FIXEDRATE_ROM = "${fint.consumer.cache.fixedRate.rom:900000}";
    
    public static final String CACHE_INITIALDELAY_TIME = "${fint.consumer.cache.initialDelay.time:80000}";
    public static final String CACHE_FIXEDRATE_TIME = "${fint.consumer.cache.fixedRate.time:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.initialDelay.undervisningsgruppe:90000}";
    public static final String CACHE_FIXEDRATE_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.fixedRate.undervisningsgruppe:900000}";
    

}
