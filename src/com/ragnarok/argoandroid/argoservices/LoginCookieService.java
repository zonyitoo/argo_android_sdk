package com.ragnarok.argoandroid.argoservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.ragnarok.argoandroid.util.ErrorException;
import com.ragnarok.argoandroid.util.HttpManager;
import com.ragnarok.argoandroid.util.Site;

import static com.ragnarok.argoandroid.util.ArgoConstant.LOG_TAG;

public class LoginCookieService {
	// this service use to get the cookie
	public String loginAndGetCookie(String username, String password) throws ErrorException {
		HttpManager manager = new HttpManager();
		String data = "userid=" + username + "&" + "passwd=" + password;
		try {
			HttpURLConnection connection = manager.baseConnect(Site.LOGIN, null, "POST");
			PrintWriter writer = new PrintWriter(connection.getOutputStream());
			writer.print(data);
			writer.flush();
			connection.connect();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String object = reader.readLine();
			JSONObject jsonObject = new JSONObject(object);
			if (jsonObject.get("success").toString().equals("1")) {
				List<String> cookieList = connection.getHeaderFields().get("Set-Cookie");
				String value = "";
				for (String v : cookieList) {
					value += v + ";";
				}
				return value;
			}
			else {
				String errorCode = jsonObject.get("code").toString();
				String error = jsonObject.get("error").toString();
				throw new ErrorException(error, errorCode);
 			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // some error in server
		
	}
}
