import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestCurl {
	public static void main(String[] args) {
		System.out.println("GET LIST USERS");
		String adress = "https://reqres.in/api";
		String command = "curl -X GET -i " + adress + "/users";
		
		getDatabyCurl(command);
		
		System.out.println("GET SINGLE USER");
		command = "curl -X GET " + adress + "/users/2";
		getDatabyCurl(command);
		
		System.out.println("POST CREATE USER");
		command = "curl -X POST " + adress + "/users --data '{\n" +
				"\t\t\"name\": \"Andrzej\",\n" +
				"\t\t\t\t\"job\": \"Niczyporuk\"\n" +
				"\t}'";
		getDatabyCurl(command);
		
		
		System.out.println("PUT UPDATE USER");
		command = "curl -X PUT " + adress + "/users/774 --data '{\n" +
				"\t\t\"name\": \"Andrzej\",\n" +
				"\t\t\t\t\"job\": \"Niczyporuk33\"\n" +
				"\t}'";
		getDatabyCurl(command);
		
		
		System.out.println("DELETE DELETE USER");
		command = "curl -X DELETE -I " + adress + "/users/774";
		getDatabyCurl(command);
		
		System.out.println("POST LOGIN -SUCCESSFUL");
		command = "curl -X POST -H \"Content-Type: application/json\" "+ adress + "/login --data '{\"email\":\"eve.holt@reqres.in\",\"password\": \"cityslicka\"}'";
		getDatabyCurl(command);
	}
	
	public static void getDatabyCurl(String cmd) {
		try {
			
			System.out.println(cmd);
			
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
