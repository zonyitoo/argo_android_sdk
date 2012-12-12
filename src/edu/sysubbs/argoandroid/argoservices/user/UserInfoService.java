package edu.sysubbs.argoandroid.argoservices.user;

import java.util.ArrayList;
import java.util.HashMap;

import edu.sysubbs.argoandroid.argoobject.ArgoBoard;
import edu.sysubbs.argoandroid.argoobject.ArgoQueryUser;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class UserInfoService {
	public ArgoQueryUser queryOtherUser(String userid) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("userid", userid);
		ArgoQueryUser user = manager.getResposneAsObject(Site.QUERY_USER, null, data, ArgoQueryUser.class);
		return user;
	}
	
	public ArrayList<ArgoBoard> getFavBoards(String cookie) throws ErrorException {
		HttpManager manager = new HttpManager();
		ArrayList<ArgoBoard> boardList = manager.getResponseAsList(Site.QUERY_FAV_BOARD, cookie, null, ArgoBoard.class);
		return boardList;
	}
}
