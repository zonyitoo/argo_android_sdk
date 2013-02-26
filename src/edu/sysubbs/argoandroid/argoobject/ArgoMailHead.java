package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoMailHead extends BaseObject {

	public int index;
	public int flag;
	public String filetime;
	public String owner;
	public String title;
	public boolean reply;
	
	@Override
	public void parse(JSONObject object) {
		try {
			index = object.getInt("index");
			flag = object.getInt("flag");
			filetime = object.getString("filetime");
			owner = object.getString("owner");
			title = object.getString("title");
			reply = object.getInt("reply") == 1;
		} catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
