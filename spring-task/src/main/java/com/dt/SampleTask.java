package com.dt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

/**
 * @author dt 2018/5/31 13:49
 */
@SpringBootApplication
@EnableTask
public class SampleTask {

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new HelloWorldCommandLineRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleTask.class,args);

    }

    public static class HelloWorldCommandLineRunner implements CommandLineRunner{

        @Override
        public void run(String... args) throws Exception {
            System.out.println("Hello, World!");
        }
    }

}
