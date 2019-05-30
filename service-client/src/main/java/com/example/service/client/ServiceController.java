package com.example.service.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.http.ResponseEntity;


@RestController
@Configuration
public class ServiceController {

@Autowired
public RestOperations template;
	
    @RequestMapping(value="/test",method=RequestMethod.POST, produces={"application/JSON"}, consumes={"text/plain"})
    public String getShipmentDetails(@RequestParam(value="name", defaultValue="0") String name) {
        ResponseEntity<String> result = template.postForEntity("http://localhost:9081/hello",name,String.class);
        return result.getBody();
    }
    

}
