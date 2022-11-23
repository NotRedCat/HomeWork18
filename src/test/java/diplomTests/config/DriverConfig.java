package diplomTests.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${properties}.properties"

})

public interface DriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("http://demowebshop.tricentis.com/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("FIREFOX")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1500x1200")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("baseURI")
    @DefaultValue("http://demowebshop.tricentis.com/")
    String getBaseURI();

}
