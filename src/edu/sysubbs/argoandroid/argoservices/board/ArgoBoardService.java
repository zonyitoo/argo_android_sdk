package edu.sysubbs.argoandroid.argoservices.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class ArgoBoardService {
	public ArrayList<String> getAllBoardnameList(String cookie) throws ErrorException {
		HttpManager httpManager = new HttpManager();
		try {
			HttpURLConnection connection = httpManager.baseConnect(Site.GET_ALL_BORAD_NAME, cookie, "GET");
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			String result = reader.readLine();
			JSONObject object = new JSONObject(result);
			if (object.get("success").equals("1")) {
				JSONArray jsonArray = object.getJSONArray("data");
				ArrayList<String> boardnameList = new ArrayList<String>();
				for (int i = 0; i < jsonArray.length(); i++) {
					boardnameList.add(jsonArray.get(i).toString());
				}
				return boardnameList;
			}
			else {
				String error = object.get("error").toString();
				String code = object.get("code").toString();
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
}
