package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.util.ArgoConstant;

import android.util.Log;

public class ArgoQueryUser extends BaseObject implements PaserObject {


	public String userid = null;
	public String username = null;
	public String lifeValue = null;
	public String hasMail = null;
	public String lastLogout = null;
	public String lastLogin = null;
	public String stay = null;
	public String constellation = null;
	public String male = null; // if equal to 1, then he is a man
	public String signature = null;
	public String numPosts = null;
	

	@Override
	public void parse(JSONObject object) {
		// TODO Auto-generated method stub
		Log.d(ArgoConstant.LOG_TAG, "parsing");
		try {
			this.numPosts = object.get("numposts").toString();
			this.userid = object.get("userid").toString();
			this.username = object.get("username").toString();
			this.lastLogout = object.get("lastlogout").toString();
			this.lastLogin = object.get("lastlogin").toString();
			this.stay = object.get("stay").toString();
			this.constellation = object.get("constellation").toString();
			this.male = object.get("male").toString();
			this.signature = object.get("signature").toString();
			this.lifeValue = object.get("life_value").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public String getObjectName() {
		// TODO Auto-generated method stub
		return ArgoQueryUser.class.getName();
	}

}
