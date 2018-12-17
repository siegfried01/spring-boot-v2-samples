package MinimalRestDemo

@org.springframework.web.bind.annotation.RestController
class HelloGroovyGradleRestController {
    
    @org.springframework.web.bind.annotation.GetMapping("/")
    public String hello() {
        return "Hello World!"
    }

}

