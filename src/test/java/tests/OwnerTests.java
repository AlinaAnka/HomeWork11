//package tests;
//
//import com.codeborne.selenide.Configuration;
//import config.CredentialsConfig;
//import org.aeonbits.owner.ConfigFactory;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//public class OwnerTests {
//
//    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
//
//    @Test
//    @Tag("owner")
//    void loginTest() {
//        String login = config.login();
//        String password = config.password();
//        String url = config.remoteUrl();
//
//        Configuration.remote = config.remoteUrl();
//
//        System.out.println("Login: " + login);
//        System.out.println("Password: " + password);
//        System.out.println("Remote: " + Configuration.remote);
//    }
//    }
