//package config;
//
//import org.aeonbits.owner.Config;
//
//    @Config.Sources("classpath:config/credentials.properties")
//    public interface CredentialsConfig extends Config {
//        String login();
//        String password();
//
//        @DefaultValue("https://${login}:${password}@selenoid.autotests.cloud/wd/hub")
//        String remoteUrl();
//    }
