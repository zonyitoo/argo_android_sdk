package com.ragnarok.argoandroid.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HttpManager {
	
	public HttpURLConnection baseConnect(String siteURL, String cookie, String method) 
			throws IOException {
		
			URL url = new URL(siteURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			if (cookie != null)
				connection.setRequestProperty("Cookie", cookie);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			return connection;
	}
	
	public JSONObject getResposneAsJsonObject(String siteURL, String cookie, Map<String, String> data) throws ErrorException {
		String url = siteURL;
		if (data != null) {
			url += "?";
			String queryData = "";
			for (String key : data.keySet()) {
				queryData += key + "=" + data.get(key);
				queryData += "&";
			}
			queryData = queryData.substring(0, queryData.length() - 1);
			url += queryData;
		}
		try {
			HttpURLConnection connection = baseConnect(url, cookie, "GET");
			connection.connect();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String value = reader.readLine();
			JSONObject object = new JSONObject(value);
			if (object.get("success").toString().equals("1")) {
				return object.getJSONObject("data");
			}
			else {
				String error = object.get("error").toString();
				String code = object.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // for exception, or server error
	}
	
	public JSONArray getResponseAsJsonArray(String siteURL, String cookie, Map<String, String> data) throws ErrorException {
		String url = siteURL;
		if (data != null) {
			url += "?";
			String queryData = "";
			for (String key : data.keySet()) {
				queryData += key + "=" + data.get(key);
				queryData += "&";
			}
			queryData = queryData.substring(0, queryData.length() - 1);
			url += queryData;
		}
		try {
			HttpURLConnection connection = baseConnect(url, cookie, "GET");
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String value = reader.readLine();
			JSONObject object = new JSONObject(value);
			//return array;
			if (object.get("success").toString().equals("1")) {
				return object.getJSONArray("data");
			}
			else {
				String error = object.get("error").toString();
				String code = object.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // for exception, or server error
	}
	
	public JSONObject postDataByMapAndGetJsonObject(String siteURL, String cookie, Map<String, String> data) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "POST");
			
			String value = "";
			for (String key : data.keySet()) {
				value += key + "=" + data.get(key) + "&";
			}
			value = value.substring(0, value.length() - 1); // remove the last &
			PrintWriter writer = new PrintWriter(connection.getOutputStream());
			writer.print(value);
			writer.flush();
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			if (jsonObject.get("success").toString().equals("1")) {
				return jsonObject.getJSONObject("data");
			}
			else {
				String error = jsonObject.get("error").toString();
				String code = jsonObject.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; // for exception, or server error
	}
	
	public JSONArray postDataByMapAndGetJsonArray(String siteURL, String cookie, Map<String, String> data) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "POST");
			
			String value = "";
			for (String key : data.keySet()) {
				value += key + "=" + data.get(key) + "&";
			}
			value = value.substring(0, value.length() - 1); // remove the last &
			PrintWriter writer = new PrintWriter(connection.getOutputStream());
			writer.print(value);
			writer.flush();
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			if (jsonObject.get("success").toString().equals("1")) {
				return jsonObject.getJSONArray("data");
			}
			else {
				String error = jsonObject.get("error").toString();
				String code = jsonObject.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; // for exception, or server error
	}
}
