package com.example.employee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.example.employee.dto.CoursesDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.NewEmployeeDto;
import com.example.employee.dto.Response;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
    private MockMvc mockMvc;
 
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void testAddEmployee() throws Exception
	{
		NewEmployeeDto newEmployeeDto=new NewEmployeeDto(90,"Jagrathi","Rai");
		EmployeeDto employeeDto=getEmployeeDto();
		String URI="/employee/new";
		String jsonInString=mapToJson(employeeDto);
		String expectedJson=mapToJson(newEmployeeDto);
		when(employeeService.addEmployee(Mockito.any(EmployeeDto.class))).thenReturn(newEmployeeDto);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URI)
				                         .accept(MediaType.APPLICATION_JSON).content(jsonInString)
				                         .contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputJson=response.getContentAsString();	
		assertThat(outputJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testGetEmployee() throws Exception
	{
		String URI="/employee";
		List<EmployeeDto> empList=new ArrayList<EmployeeDto>();
		empList.add(getEmployeeDto());
		empList.add(getEmployeeDto());
		when(employeeService.getEmployees()).thenReturn(empList);	
		RequestBuilder request=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request).andReturn();
		Integer statusCode=result.getResponse().getStatus();
		assertEquals(200, statusCode);
	}
	
	@Test
	public void testGetEmployeeById() throws Exception
	{
		String URI="/employee/1";
		EmployeeDto emp=getEmployeeDto();
		when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(emp);
		//String expectedJson=mapToJson(emp);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		//String outputJson=result.getResponse().getContentAsString();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testUpdateEmployee() throws Exception
	{
		String URI="/employee/update";
		Response response= new Response(1);
		response.setMessage("Employee Data Updated Successfully!!!");
		EmployeeDto empDto=getEmployeeDto();
		empDto.setId(1);		
		empDto.setFirstName("jagu");
		String inputJson=mapToJson(empDto);
		when(employeeService.updateEmployee(Mockito.any(EmployeeDto.class))).thenReturn(response);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.put(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(inputJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String actualJson=result.getResponse().getContentAsString();
		String expectedJson=mapToJson(response);
		assertEquals(200, result.getResponse().getStatus());
		assertThat(actualJson).isEqualTo(expectedJson);
	}
	
	//to convert the object to json String
	private String mapToJson (Object object) throws JsonProcessingException
	{
		ObjectMapper objMapper=new ObjectMapper();
		return objMapper.writeValueAsString(object);
	}
	
		private EmployeeDto getEmployeeDto()
	{
		List<CoursesDto> courseDto=new ArrayList<CoursesDto>();
		courseDto.add(new CoursesDto("Java", "java", LocalDate.now(), LocalDate.now().plusDays(1L)));
		EmployeeDto empDto=new EmployeeDto("Jagrathi","Rai","1234567890","Panaji,Goa",null);
		empDto.setId(1);
		return empDto;
	}

}
