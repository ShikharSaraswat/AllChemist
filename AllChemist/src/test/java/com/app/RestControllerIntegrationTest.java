package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

//Integration Test : complete end to end testing
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RestControllerIntegrationTest {
	@LocalServerPort
	private int serverPort;
	private HttpHeaders  headers= new HttpHeaders();
	
	
	@Autowired
	private TestRestTemplate template= new TestRestTemplate("raj","raj");

	@WithMockUser(username = "raj", password = "raj", roles = "patient")
	@Test
	
	public void testPatientControllerFindPatientById() {
		String uri = "/patient/details/1";
		//String patient = template.withBasicAuth("raj", "raj").getForObject("http://localhost:" + serverPort + uri,String.class);
		ResponseEntity<String> result = template.getForEntity(uri, String.class);
		        assertEquals(HttpStatus.OK, result.getStatusCode());
		//System.out.println(patient);
		
		
	}

}
