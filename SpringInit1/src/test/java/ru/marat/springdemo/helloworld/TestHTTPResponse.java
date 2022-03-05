package ru.marat.springdemo.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHTTPResponse {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHelloRequest() {
        assertEquals("Hello from Dummy Bean",
                testRestTemplate.getForObject("http://localhost:" + port + "/",
                        String.class));
    }

    @Test
    public void testGoodbyeRequest() {
        assertEquals("Goodbye",
                testRestTemplate.getForObject("http://localhost:" + port + "/goodbye",
                        String.class));
    }

}
