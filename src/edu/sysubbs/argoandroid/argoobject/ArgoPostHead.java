package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoPostHead extends BaseObject {

	public int index;
	public boolean flag; // Deprecated
	public String id;
	public String update;
	public String owner;
	public String title;
	public String filename;
	public boolean unread;
	public int mark;
	
	@Override
	public void parse(JSONObject object) {
		try {
			index = object.getInt("index");
			id = object.getString("id");
			update = object.getString("update");
			owner = object.getString("owner");
			title = object.getString("title");
			filename = object.getString("filename");
			unread = object.getBoolean("unread");
			mark = object.getInt("mark");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
