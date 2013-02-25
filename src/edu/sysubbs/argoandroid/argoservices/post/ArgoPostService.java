package edu.sysubbs.argoandroid.argoservices.post;

import java.util.ArrayList;
import java.util.HashMap;

import edu.sysubbs.argoandroid.argoobject.ArgoPostHead;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class ArgoPostService {
	public ArrayList<ArgoPostHead> getPostList(String cookie, String type, int start, String boardname) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("type", type);
		data.put("start", start);
		data.put("boardname", boardname);
		return manager.getResponseAsList(Site.GET_POST_LIST, cookie, data, ArgoPostHead.class);
	}
	
	public String getPostNearname(String boardname, String direction, String filename) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		data.put("direction", direction);
		data.put("filename", filename);
		
		return manager.getResponseAsBaseObject(Site.GET_POST_NEARNAME, null, data);
	}
	
	public ArrayList<String> getPostTopicList(String boardname, String filename) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		data.put("filename", filename);
		
		return manager.getResponseAsBaseObjectList(Site.GET_POST_TOPICLIST, null, data);
	}
	
	public void postPostAdd(
			String cookie, String type, String boardname, 
			String articleid, String title, String content, String file) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		data.put("type", type);
		data.put("articleid", articleid);
		data.put("title", title);
		data.put("content", content);
		data.put("file", file);
		
		manager.postDataByMapAndGetBaseObject(Site.POST_POST_ADD, cookie, data);
	}
	
	public void postPostDel(String cookie, String boardname, String filename) throws ErrorException {
		HttpManager manager = new HttpManager();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardname", boardname);
		data.put("filename", filename);
		
		manager.postDataByMapAndGetBaseObject(Site.POST_POST_DEL, cookie, data);
	}
}
