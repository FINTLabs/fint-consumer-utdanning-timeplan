package no.fint.consumer.config;

public enum Constants {
;

    public static final String COMPONENT = "utdanning-timeplan";
    public static final String COMPONENT_CONSUMER = COMPONENT + " consumer";
    public static final String CACHE_SERVICE = "CACHE_SERVICE";

    
    public static final String CACHE_INITIALDELAY_EKSAMEN = "${fint.consumer.cache.initialDelay.eksamen:900000}";
    public static final String CACHE_FIXEDRATE_EKSAMEN = "${fint.consumer.cache.fixedRate.eksamen:900000}";
    
    public static final String CACHE_INITIALDELAY_FAG = "${fint.consumer.cache.initialDelay.fag:1000000}";
    public static final String CACHE_FIXEDRATE_FAG = "${fint.consumer.cache.fixedRate.fag:900000}";
    
    public static final String CACHE_INITIALDELAY_FAGGRUPPE = "${fint.consumer.cache.initialDelay.faggruppe:1100000}";
    public static final String CACHE_FIXEDRATE_FAGGRUPPE = "${fint.consumer.cache.fixedRate.faggruppe:900000}";
    
    public static final String CACHE_INITIALDELAY_FAGGRUPPEMEDLEMSKAP = "${fint.consumer.cache.initialDelay.faggruppemedlemskap:1200000}";
    public static final String CACHE_FIXEDRATE_FAGGRUPPEMEDLEMSKAP = "${fint.consumer.cache.fixedRate.faggruppemedlemskap:900000}";
    
    public static final String CACHE_INITIALDELAY_ROM = "${fint.consumer.cache.initialDelay.rom:1300000}";
    public static final String CACHE_FIXEDRATE_ROM = "${fint.consumer.cache.fixedRate.rom:900000}";
    
    public static final String CACHE_INITIALDELAY_TIME = "${fint.consumer.cache.initialDelay.time:1400000}";
    public static final String CACHE_FIXEDRATE_TIME = "${fint.consumer.cache.fixedRate.time:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.initialDelay.undervisningsgruppe:1500000}";
    public static final String CACHE_FIXEDRATE_UNDERVISNINGSGRUPPE = "${fint.consumer.cache.fixedRate.undervisningsgruppe:900000}";
    
    public static final String CACHE_INITIALDELAY_UNDERVISNINGSGRUPPEMEDLEMSKAP = "${fint.consumer.cache.initialDelay.undervisningsgruppemedlemskap:1600000}";
    public static final String CACHE_FIXEDRATE_UNDERVISNINGSGRUPPEMEDLEMSKAP = "${fint.consumer.cache.fixedRate.undervisningsgruppemedlemskap:900000}";
    

}
