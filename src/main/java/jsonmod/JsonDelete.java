package jsonmod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonDelete {

	protected static String endpoint = "http://localhost:1337/employee/3";
	
	protected static String charset = "UTF-8";




	public static void main(String[] args) {
		try {

			
			// creates the url parameters as a strong encoding them with the
			// defined charset
	
			// creates a new URL out of the endpoint, returnType and queryString
			URL employeeSite = new URL(endpoint + "?");
			HttpURLConnection connection = (HttpURLConnection) employeeSite.openConnection();
			connection.setRequestMethod("DELETE");

			// If we do not get a 201(success) throw an exception

			if (connection.getResponseCode() != 200) {
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
