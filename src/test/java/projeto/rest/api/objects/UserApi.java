package projeto.rest.api.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {
	
	private final String baseURL;
	
	public UserApi(String baseURL) {
		this.baseURL = baseURL;		
	}
	/// Metodos /// 
	
	public Response getUsers(int page) {
		return RestAssured.get("/api/users?page="+page );
		
	}
}
