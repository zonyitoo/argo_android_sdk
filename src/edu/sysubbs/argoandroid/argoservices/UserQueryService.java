package edu.sysubbs.argoandroid.argoservices;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


import edu.sysubbs.argoandroid.argoobject.ArgoQueryUser;
import edu.sysubbs.argoandroid.util.ArgoConstant;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class UserQueryService {
	public ArgoQueryUser queryOtherUser(String userid) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("userid", userid);
		JSONObject object = manager.getResposneAsJsonObject(Site.QUERY_USER, null, data);
		ArgoQueryUser user = new ArgoQueryUser();
		user.parse(object);
		return user;
	}
}
