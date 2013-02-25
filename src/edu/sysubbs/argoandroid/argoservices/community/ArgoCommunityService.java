package edu.sysubbs.argoandroid.argoservices.community;

import java.util.ArrayList;
import java.util.HashMap;

import edu.sysubbs.argoandroid.argoobject.ArgoToptenPost;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class ArgoCommunityService {
	public ArrayList<ArgoToptenPost> getToptenPosts() throws ErrorException {
		HttpManager manager = new HttpManager();
		return manager.getResponseAsList(Site.GET_COMM_TOPTEN, null, new HashMap<String, Object>(), ArgoToptenPost.class);
	}
}
