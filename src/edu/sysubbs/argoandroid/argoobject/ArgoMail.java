package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoMail extends BaseObject {

	public int index;
	public boolean flag;
	public long filetime;
	public String owner;
	public String title;
	public boolean reply;
	public String content;
	
	@Override
	public void parse(JSONObject object) {
		try {
			index = object.getInt("index");
			flag = object.getBoolean("flag");
			filetime = object.getLong("filetime");
			owner = object.getString("owner");
			title = object.getString("title");
			reply = object.getBoolean("reply");
			content = object.getString("content");
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
