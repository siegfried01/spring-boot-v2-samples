package com.example.demo;

@lombok.extern.slf4j.Slf4j
@org.springframework.boot.autoconfigure.SpringBootApplication
public class HelloWorldApplication /*implements org.springframework.boot.CommandLineRunner*/ {
    //@Override public void run(String... args) throws Exception { log.info("Siegfried: This is the command line runner"); }
    // %JAVA_BUILDINGMICROSERVICES%\livelessons-choreography\livelessons-choreography-contact-service\src\main\java\demo\ContactServiceApplication.java
	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner init() {
            return args -> { log.info("Siegfried: This is the command line runner args="+String.join(",", args)); };
	}

    public static void main(String[] args) {
        log.info("Hello Siegfried! Starting main application args="+String.join(",", args));
        org.springframework.boot.SpringApplication.run(HelloWorldApplication.class, args);
    }
}

