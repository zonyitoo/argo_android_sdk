package edu.sysubbs.argoandroid.argoservices;

import java.util.HashMap;

import org.json.JSONObject;

import edu.sysubbs.argoandroid.argoobject.ArgoQueryUser;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class UserQueryService {
	public ArgoQueryUser queryOtherUser(String userid) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("userid", userid);
		ArgoQueryUser user = manager.getResposneAsObject(Site.QUERY_USER, null, data, ArgoQueryUser.class);
		return user;
	}
}
