package edu.sysubbs.argoandroid.argoservices.mail;

import java.util.ArrayList;
import java.util.HashMap;

import edu.sysubbs.argoandroid.argoobject.ArgoMailBox;
import edu.sysubbs.argoandroid.argoobject.ArgoMailHead;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class ArgoMailService {
	public ArgoMailBox getMailBox(String cookie) throws ErrorException {
		HttpManager manager = new HttpManager();
		return manager.getResponseAsObject(Site.GET_MAILBOX, cookie, new HashMap<String, Object>(), ArgoMailBox.class);
	}
	
	public ArrayList<ArgoMailHead> getArgoMailHeads(String cookie, int start) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		return manager.getResponseAsList(Site.GET_MAIL_LIST, cookie, param, ArgoMailHead.class);
	}
	
	public void postSendMail(String cookie, String title, String content, String receiver, String articleid) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("title", title);
		data.put("content", content);
		data.put("receiver", receiver);
		if (articleid != null)
			data.put("article", articleid);
		manager.postDataByMapAndGetBaseObject(Site.POST_MAIL_SEND, cookie, data);
	}
	
	public void postDelMail(String cookie, ArrayList<Integer> indexes) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("indexes", indexes);
		manager.postDataByMapAndGetBaseObject(Site.POST_MAIL_DEL, cookie, data);
	}
}
