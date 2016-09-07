package jsonmod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class JsonPost {
	/*
	 * The URL of the APU we want to connect to
	 */

	protected static String endpoint = "http://localhost:1337/employee/";
	
	protected static String charset = "UTF-8";




	public static void main(String[] args) {
		try {

			// The First Name
			String firstName = "Aniya";

			// The last name
			String lastName = "Cuffee";

			// return type of the response xml|json
			 
			
			// Email
			String email = "roland.cuffee@awesome.com";
			
			//home phone
			
			String homePhone = "804-226-1510";
			
			//Cell Phone
			String cellPhone = "804-304-1716";
			
			//password
			String password = "super1AwesomeRainbow";
			
			//active state
			String active = "1";

			// creates the url parameters as a strong encoding them with the
			// defined charset
			String queryString = String.format("firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s", URLEncoder.encode(firstName, charset), 
					URLEncoder.encode(lastName, charset), URLEncoder.encode(email, charset), 
					URLEncoder.encode(homePhone, charset), URLEncoder.encode(cellPhone, charset), 
					URLEncoder.encode(password, charset), URLEncoder.encode(active, charset));

			// creates a new URL out of the endpoint, returnType and queryString
			URL employeeSite = new URL(endpoint + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) employeeSite.openConnection();
			connection.setRequestMethod("POST");

			// If we do not get a 201(success) throw an exception

			if (connection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code :" + connection.getResponseCode());
			}

			// read response into buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// loop of buffer line by line until it returns null meaning there
			// are no more lines
			while (br.readLine() != null) {
				// print out each line to the screen
				System.out.println(br.readLine());
			}

			// close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
