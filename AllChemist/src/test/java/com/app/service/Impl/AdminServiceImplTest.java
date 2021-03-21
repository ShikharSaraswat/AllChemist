package com.app.service.Impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.controller.AdminController;
import com.app.dto.HospitalDto;
import com.app.service.AdminServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value=AdminController.class)
class AdminServiceImplTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminServiceImpl adminService;

	String sampleBean= "{\"id\":\"\" , \"name\": \"gjh\",\"password\": \"abc##123 \",email\":\"hn@gmail.com\"}";
	@Test
	void testRegisterHospital() throws Exception {
		HospitalDto mockHospital = new HospitalDto(1, "hn@gmail.com", "abc##123", "hnHospital");
		
		when(adminService.registerHospital(Mockito.any(HospitalDto.class))).thenReturn(mockHospital);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/admin/register_hospital")
				.accept(MediaType.APPLICATION_JSON)
				.content(sampleBean).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals("http://localhost:8080/AllChemist/admin/register_hospital",
				response.getHeader(HttpHeaders.LOCATION));
	}

	/*
	 * @Test void testRegisterPharmacy() { fail("Not yet implemented"); }
	 */

}
