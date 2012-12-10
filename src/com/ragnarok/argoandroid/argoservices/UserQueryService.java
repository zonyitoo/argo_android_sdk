package com.ragnarok.argoandroid.argoservices;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.ragnarok.argoandroid.argoobject.ArgoQueryUser;
import com.ragnarok.argoandroid.util.ArgoConstant;
import com.ragnarok.argoandroid.util.ErrorException;
import com.ragnarok.argoandroid.util.HttpManager;
import com.ragnarok.argoandroid.util.Site;

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
