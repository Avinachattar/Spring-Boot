package com.zensar.spring.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailVerification {

	public static void main(String[] args) throws Exception {
	}

	public static boolean sendGet(String emailId) throws Exception {
		String API_KEY = "live_a245c26896e6d508bbfed1d5f4310add29ffbe5aaa6a7b501319ae4397e62ebe";
		String url = "https://api.kickbox.com/v2/verify?email=" + emailId + "&apikey=" + API_KEY;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		System.out.println(con.getContent());
		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());

		System.out.println(contains(response, "undeliv"));
		contains(response, "undeliv");

		if (contains(response, "undeliv")) {
			return false;
		}
		if (contains(response, "deliverable")) {
			return true;
		}
		if (contains(response, "risky")) {
			return true;
		}
		if (contains(response, "unknown")) {
			return false;
		}
		return false;

	}

	private static boolean contains(StringBuffer response, String string) {

		return response.indexOf(string) > -1;

	}

}
