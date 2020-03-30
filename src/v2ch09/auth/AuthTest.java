package v2ch09.auth;

import java.security.*;

import javax.security.auth.*;
import javax.security.auth.login.*;

/**
 * This program authenticates a user via a custom login and then executes the SysPropAction with the
 * user's privileges.
 * @author Cay Horstmann
 * @version 1.01 2007-10-06
 */
public class AuthTest {

    public static void main(final String[] args) {
        System.setProperty("java.security.policy", "src/v2ch09/auth/AuthTest.policy");// or -Djava.security.policy=auth/AuthTest.policy
        System.setProperty("java.security.auth.login.config", "src/v2ch09/auth/jaas.config");// or -Djava.security.auth.login.config=auth/jaas.config
        System.setSecurityManager(new SecurityManager());
        try {
            LoginContext context = new LoginContext("Login1");
            context.login();
            System.out.println("Authentication successful.");
            Subject subject = context.getSubject();
            System.out.println("subject=" + subject);
            PrivilegedAction<String> action = new SysPropAction("user.home");
            String result = Subject.doAsPrivileged(subject, action, null);
            System.out.println(result);
            context.logout();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
