package v2ch09.jaas;

import java.awt.*;

import javax.swing.*;

/**
 * This program authenticates a user via a custom login and then looks up a system property with the
 * user's privileges.
 * @author Cay Horstmann
 * @version 1.02 2016-05-10
 */
public class JAASTest {

    public static void main(final String[] args) {
        System.setProperty("java.security.policy", "src/v2ch09/jaas/JAASTest.policy");// or -Djava.security.policy=auth/JAASTest.policy
        System.setProperty("java.security.auth.login.config", "src/v2ch09/jaas/jaas.config");// or -Djava.security.auth.login.config=jaas/jaas.config
        System.setSecurityManager(new SecurityManager());
        EventQueue.invokeLater(() ->
                               {
                                   JFrame frame = new JAASFrame();
                                   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                   frame.setTitle("JAASTest");
                                   frame.setVisible(true);
                               });
    }
}
