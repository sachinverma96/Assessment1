package asmt1.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asmt1.demo.dto.UserStatus;
import asmt1.demo.entity.Address;
import asmt1.demo.entity.Contact;
@RunWith(SpringRunner.class)
@SpringBootTest
class Assignment1ApplicationTests {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om=new ObjectMapper();
	
//	@Before
//	private void setup() {
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//	}
//	@Test
//	@Order(1)
//    public void testSaveNewContact() throws JsonProcessingException {
//		Address add=new Address("102", "Galaxy ", 12310, "LasVegas", "Goa", "India");
//		UserStatus status=UserStatus.ACTIVE;
//		Contact contact=new Contact("Shawn", "Micheal", 354535410, "shawn@gmail.com", status, add);
//		String jsonRequest=om.writeValueAsString(contact);
//		MvcResult result=mockMvc.perform(post("/contact/add").content(jsonRequest)
//				.content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
	//}

}
