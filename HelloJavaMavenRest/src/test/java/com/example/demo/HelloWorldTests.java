package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@org.junit.runner.RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT)
@lombok.extern.slf4j.Slf4j
public class HelloWorldTests {
    // "%JAVA_EG%\spring-boot\spring-boot-github-examples\spring-boot\spring-boot-samples\spring-boot-sample-jersey1\src\test\java\sample\jersey1\SampleJersey1ApplicationTests.java"
    @org.springframework.beans.factory.annotation.Value("${local.server.port}") private int port;
    @org.springframework.beans.factory.annotation.Autowired private org.springframework.boot.test.web.client.TestRestTemplate restTemplate;

    @org.junit.Before
    public void setup() {
        var httpClient = org.apache.http.impl.client.HttpClientBuilder.create().build();
        this.restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
    
    @org.junit.Test
    public void HelloWorld() {
        log.info("running HelloWorld Test port="+port);
        assertEquals("Hello World!", new org.springframework.boot.test.web.client.TestRestTemplate()
                     .getForObject("http://localhost:" + this.port + "/", String.class));
    }
}
