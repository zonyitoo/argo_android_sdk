package edu.sysubbs.argoandroid.argoobject;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class ArgoSectionBoards extends BaseObject {

	public ArgoSection section = null;
	public ArrayList<ArgoBoard> boardList = null;

	@Override
	public void parse(JSONObject object) {
		// TODO Auto-generated method stub
		try {	
			JSONArray boardArray = object.getJSONArray("boards");
			boardList = new ArrayList<ArgoBoard>();
			for (int i = 0; i < boardArray.length(); i++) {
				JSONObject boardObject = boardArray.getJSONObject(i);
				ArgoBoard board = new ArgoBoard();
				board.title = boardObject.get("title").toString();
				String[] BMArr = boardObject.get("BM").toString().split(" ");
				board.BM = new ArrayList<String>();
				for (int j = 0; j < BMArr.length; j++) {
					board.BM.add(BMArr[j]);
				}
				
				board.lastpost = boardObject.get("lastpost").toString();
				board.total = boardObject.get("total").toString();
				board.totalToday = boardObject.get("total_today").toString();
				board.boardname = boardObject.get("boardname").toString();
				
				boardList.add(board);
			}
			this.section = new ArgoSection();
			this.section.sectionCode = object.get("seccode").toString(); // something wrong...
			this.section.sectionName = object.get("secname").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.d("Ragnarok", e.getMessage());
			e.printStackTrace();
		}
	}

}
