
package no.fint.consumer.config;

public enum Constants {
;

    public static final String COMPONENT = "utdanning-timeplan";
    public static final String COMPONENT_CONSUMER = COMPONENT + " consumer";
    public static final String CACHE_SERVICE = "CACHE_SERVICE";

    
    public static final String CACHE_INITIALDELAY_FAG = "${fint.consumer.cache.initialDelay.fag:900000}";
    public static final String CACHE_FIXEDRATE_FAG = "${fint.consumer.cache.fixedRate.fag:900000}";
    
    public static final String CACHE_INITIALDELAY_ROM = "${fint.consumer.cache.initialDelay.rom:910000}";
    public static final String CACHE_FIXEDRATE_ROM = "${fint.consumer.cache.fixedRate.rom:900000}";
    
    public static final String CACHE_INITIALDELAY_TIME = "${fint.consumer.cache.initialDelay.time:920000}";
    public static final String CACHE_FIXEDRATE_TIME = "${fint.consumer.cache.fixedRate.time:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.initialDelay.undervisningsgruppe:930000}";
    public static final String CACHE_FIXEDRATE_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.fixedRate.undervisningsgruppe:900000}";
    

}
