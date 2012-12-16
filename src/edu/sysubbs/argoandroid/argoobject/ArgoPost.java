package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoPost extends BaseObject {
	
	public int userid;
	public String username;
	public String title;
	public String board;
	public String post_time;
	public String rawcontent;
	public String rawsignature;
	public String bbsname;
	public String ah;
	public String filename;
	public boolean perm_del;

	@Override
	public void parse(JSONObject object) {
		try {
			userid = object.getInt("userid");
			username = object.getString("username");
			title = object.getString("title");
			board = object.getString("board");
			post_time = object.getString("post_time");
			rawcontent = object.getString("rawcontent");
			rawsignature = object.getString("rawsignature");
			bbsname = object.getString("bbsname");
			ah = object.getString("ah");
			filename = object.getString("filename");
			perm_del = object.getBoolean("perm_del");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
