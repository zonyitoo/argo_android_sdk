package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgoAttach extends BaseObject {
	
	public String filename;
	public String origname;
	public String desc;
	public String filetype;
	public String articleid;
	public String link;
	public boolean is_picture;
	
	@Override
	public void parse(JSONObject object) {
		try {
			filename = object.getString("filename");
			origname = object.getString("origname");
			desc = object.getString("desc");
			filetype = object.getString("filetype");
			articleid = object.getString("articleid");
			link = object.getString("link");
			is_picture = object.getBoolean("is_picture");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
