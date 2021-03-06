package com.mycompany.spring.boot.gettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect Spring Boot beans ");

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }


        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                ((ConfigurableApplicationContext)applicationContext).close();
            }
        });
    }
}
