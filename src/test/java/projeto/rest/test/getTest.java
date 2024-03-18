package projeto.rest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projeto.rest.api.objects.UserApi;

public class getTest {
	
	private UserApi userAPI;
	
	@Before
	public void setUp() {
		userAPI = new UserApi("https://reqres.in/"); 
	}
	
	@Test
	public void testGetStatusCode() {
		Response response = userAPI.getUsers(2);
		assertEquals(200, response.getStatusCode());
					
	}
	@Test
	public void testGetBody() {
		response = RestAssured.get("https://reqres.in/api/users?page=2");
		assertEquals("7", response.jsonPath().getString("data[0].id"));
		assertEquals("michael.lawson@reqres.in", response.jsonPath().getString("data[0].email"));
	}
}
