package edu.sysubbs.argoandroid.argoobject;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.util.ArgoConstant;

import android.util.Log;

public class ArgoBoard extends BaseObject {

	public String boardname = null; // boardname or filename 版面名字
	public String title = null; // title 板块描述
	public ArrayList<String> BM = null; // BM 版主id列表
	public String lastpost = null; // lastpost 本版最后一篇文章的发文时间
	public String sectionCode = null; // seccode 所属讨论区分区<section object>的seccode
	public String unread = null; // unread 这个版块是否有未读的文章。如果为1则有未读文章，否则为""
	public String total = null; // total 这个版块含有的文章总数
	public String lastpostTitle = null; // may be null, or lastpostfile 最后一篇文章的标题
	public String lastAuthor = null; // may be null, or lastauthor 最后一篇文章的作者
	public String totalToday = null; // total_today 今天新文章总数
	public String type = null; // type 板块类型
	//public String parent = null; // parent, not use at all
	public String sectionNum = null; // secnum 所属讨论区分区<section object>的secnum
	
	@Override
	public void parse(JSONObject object) {
		// TODO Auto-generated method stub
		try {
			this.boardname = object.get("boardname").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.boardname = object.getString("filename").toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				this.boardname = null;
			}
		}
		try {
			this.title = object.get("title").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.BM = new ArrayList<String>();
		try {
			JSONArray array = object.getJSONArray("BM");
			for (int i = 0; i < array.length(); i++) {
				this.BM.add(array.get(i).toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.lastpost = object.get("lastpost").toString();
			this.sectionCode = object.get("seccode").toString();
			this.unread = object.get("unread").toString();
			this.total = object.get("total").toString();
			this.totalToday = object.get("total_today").toString();
			this.type = object.get("type").toString();
			this.sectionNum = object.get("secnum").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.lastpostTitle = object.get("lastpostfile").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.lastpostTitle = null;
		}
		try {
			this.lastAuthor = object.get("lastauthor").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.lastAuthor = null;
		}
	}

}
