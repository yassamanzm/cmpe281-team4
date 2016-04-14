package org.cmpe281.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Naks
 * Class to configure application context
 * SpringBootApplication annotation search and add all the subclasses.
 */
@SpringBootApplication
public class Application {
    /**
     * Main method for the project.
     * @param args Nothing needs to be passed
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
