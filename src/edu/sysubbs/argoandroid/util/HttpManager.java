package edu.sysubbs.argoandroid.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import edu.sysubbs.argoandroid.argoobject.BaseObject;


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
	
	public <T extends BaseObject> T getResponseAsObject(
			String siteURL, String cookie, Map<String, Object> data, Class<T> returnClass) throws ErrorException {
		String url = siteURL;
		/*
		if (data != null) {
			url += "?";
			String queryData = "";
			for (String key : data.keySet()) {
				queryData += key + "=" + data.get(key);
				queryData += "&";
			}
			queryData = queryData.substring(0, queryData.length() - 1);
			url += queryData;
		}*/
		try {
			HttpURLConnection connection = baseConnect(url, cookie, "GET");
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			
			connection.connect();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String value = reader.readLine();
			JSONObject object = new JSONObject(value);
			//Log.d("Ragnarok", object.toString());
			if (object.get("success").toString().equals("1") || object.get("success").toString().equals("true")) {
				try {
					T t = returnClass.newInstance();
					t.parse(object.getJSONObject("data"));
					return t;
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
	
	public <T extends BaseObject> ArrayList<T> getResponseAsList(
			String siteURL, String cookie, Map<String, Object> data, Class<T> returnClass) throws ErrorException {
		String url = siteURL;
		/*
		if (data != null) {
			url += "?";
			String queryData = "";
			for (String key : data.keySet()) {
				queryData += key + "=" + data.get(key);
				queryData += "&";
			}
			queryData = queryData.substring(0, queryData.length() - 1);
			url += queryData;
		}*/
		try {
			HttpURLConnection connection = baseConnect(url, cookie, "GET");
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String value = reader.readLine();
			JSONObject object = new JSONObject(value);
			//return array;
			if (object.get("success").toString().equals("1")) {
				JSONArray array = object.getJSONArray("data");
				ArrayList<T> list = new ArrayList<T>();
				for (int i = 0; i < array.length(); i++) {
					T t = returnClass.newInstance();
					t.parse(array.getJSONObject(i));
					list.add(t);
				}
				return list;
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // for exception, or server error
	}
	
	public <T> T getResponseAsBaseObject(String siteURL, String cookie, Map<String, Object> data) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "GET");
			
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			//Log.d(ArgoConstant.LOG_TAG, jsonObject.toString());
			if (jsonObject.get("success").toString().equals("1")) {
				//return jsonObject.getJSONObject("data");
				return (T) jsonObject.get("data");
			}
			else {
				String error = jsonObject.get("error").toString();
				String code = jsonObject.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public <T> ArrayList<T> getResponseAsBaseObjectList(String siteURL, String cookie, Map<String, Object> data) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "GET");
			
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			//Log.d(ArgoConstant.LOG_TAG, jsonObject.toString());
			if (jsonObject.get("success").toString().equals("1")) {
				//return jsonObject.getJSONObject("data");
				JSONArray array = jsonObject.getJSONArray("data");
				ArrayList<T> objList = new ArrayList<T>();
				for (int i = 0; i < array.length(); ++ i) {
					objList.add((T) array.get(i));
				}
				return objList;
			}
			else {
				String error = jsonObject.get("error").toString();
				String code = jsonObject.get("code").toString();
				throw new ErrorException(error, code);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public <T extends BaseObject> T postDataByMapAndGetObject(
			String siteURL, String cookie, Map<String, Object> data, Class<T> returnClass) throws ErrorException {
		try {
			/*
			String value = "";
			for (String key : data.keySet()) {
				value += key + "=" + data.get(key) + "&";
			}
			value = value.substring(0, value.length() - 1); // remove the last &*/
			HttpURLConnection connection = baseConnect(siteURL, cookie, "POST");
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			//Log.d(ArgoConstant.LOG_TAG, jsonObject.toString());
			if (jsonObject.get("success").toString().equals("1")) {
				//return jsonObject.getJSONObject("data");
				T t = returnClass.newInstance();
				t.parse(jsonObject.getJSONObject("data"));
				return t;
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; // for exception, or server error
	}
	
	public <T extends BaseObject> ArrayList<T> postDataByMapAndGetList(
			String siteURL, String cookie, Map<String, Object> data, Class<T> returnClass) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "POST");
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			if (jsonObject.get("success").toString().equals("1")) {
				//return jsonObject.getJSONArray("data");
				JSONArray array = jsonObject.getJSONArray("data");
				ArrayList<T> list = new ArrayList<T>();
				for (int i = 0; i < array.length(); i++) {
					T t = returnClass.newInstance();
					t.parse(array.getJSONObject(i));
					list.add(t);
				}
				return list;
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; // for exception, or server error
	}
	
	public <T> T postDataByMapAndGetBaseObject(
			String siteURL, String cookie, Map<String, Object> data) throws ErrorException {
		try {
			HttpURLConnection connection = baseConnect(siteURL, cookie, "POST");
			if (data != null) {
				JSONObject dataObject = new JSONObject(data);
				String passData = dataObject.toString();
				PrintWriter writer = new PrintWriter(connection.getOutputStream());
				writer.print(passData);
				writer.flush();
			}
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			if (jsonObject.get("success").toString().equals("1")) {
				//return jsonObject.getJSONArray("data");
				return (T) jsonObject.get("data");
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
