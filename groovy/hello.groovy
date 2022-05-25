// spring run hello.groovy -- --server.port=8888

@RestController
class WebApplication {

    @RequestMapping("/hello")
    String home() {
        "Hello Groovy!"
    }

}
