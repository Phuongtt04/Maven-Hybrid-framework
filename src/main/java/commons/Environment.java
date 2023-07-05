package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${server}.properties"})
public interface Environment extends Config {
    @Key("UserUrl")
    String getUserUrl();

    @Key("AdminUrl")
    String getAdminUrl();
}
