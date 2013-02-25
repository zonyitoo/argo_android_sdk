package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoToptenPost extends BaseObject {
	
	public String author;
	public String board;
	public String filename;
	public int num;
	public long time;
	public String title;
	
	@Override
	public void parse(JSONObject object) {
		try {
			author = object.getString("author");
			board = object.getString("board");
			filename = object.getString("filename");
			num = object.getInt("num");
			time = object.getLong("time");
			title = object.getString("title");
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}
