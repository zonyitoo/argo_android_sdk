package edu.sysubbs.argoandroid.argoservices.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.argoobject.ArgoBoard;
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
	
	public ArrayList<ArgoBoard> getAllBoardInfo() throws ErrorException {
		HttpManager httpManager = new HttpManager();
		ArrayList<ArgoBoard> boardInfoList = httpManager.getResponseAsList(Site.GET_ALL_BOARD_INFO, null, null, ArgoBoard.class);
		return boardInfoList;	
	}
	
	public ArgoBoard getBoardInfo(String boardname) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		ArgoBoard board = manager.getResponseAsObject(Site.GET_BOARD_INFO, null, data, ArgoBoard.class);
		
		return board;
	}
	
	public ArgoBoard getBoardInfoBySecCode(String secCode) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("sec_code", secCode);
		ArgoBoard board = manager.getResponseAsObject(Site.GET_BOARD_INFO_BY_SECCODE, null, data, ArgoBoard.class);
		
		return board;
	}
	
	public boolean cleanBoardUnread(String cookie, String boardname) {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		
		boolean success = false;
		try {
			manager.postDataByMapAndGetBaseObject(Site.CLEAR_BOARD_UNREAD, cookie, data);
			success = true;
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	public ArrayList<String> getReadedPostIndexList(String cookie, String boardname) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		
		try {
			HttpURLConnection connection = manager.baseConnect(Site.GET_READED_POST_INDEX_LIST, cookie, "GET");
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			
			String result = reader.readLine();
			JSONObject object = new JSONObject(result);
			if (object.get("success").equals("1")) {
				JSONArray jsonArray = object.getJSONArray("data");
				ArrayList<String> readedPostIndexList = new ArrayList<String>();
				for (int i = 0; i < jsonArray.length(); i++) {
					readedPostIndexList.add(jsonArray.get(i).toString());
				}
				return readedPostIndexList;
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
