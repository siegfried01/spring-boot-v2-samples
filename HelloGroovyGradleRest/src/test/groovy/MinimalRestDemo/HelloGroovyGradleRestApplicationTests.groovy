package MinimalRestDemo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@org.springframework.boot.test.context.SpringBootTest(webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT)
@groovy.util.logging.Slf4j
class HelloGroovyGradleRestApplicationTests {

    @org.springframework.beans.factory.annotation.Value("\${local.server.port}") private int port;
    @org.springframework.beans.factory.annotation.Autowired private org.springframework.boot.test.web.client.TestRestTemplate restTemplate;

    @org.junit.Before
    public void setup() {
        def httpClient = org.apache.http.impl.client.HttpClientBuilder.create().build();
        this.restTemplate.getRestTemplate().setRequestFactory(new org.springframework.http.client.HttpComponentsClientHttpRequestFactory(httpClient));
    }
    
    @org.junit.Test
    public void HelloWorld() {
        log.info("running HelloWorld Test port=${port}");
        org.junit.Assert.assertEquals("Hello World!", new org.springframework.boot.test.web.client.TestRestTemplate()
                     .getForObject("http://localhost:" + this.port + "/", String.class));
    }
}

