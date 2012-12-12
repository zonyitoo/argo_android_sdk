package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.util.ArgoConstant;

import android.util.Log;

public class ArgoSection extends BaseObject {

	public String sectionCode = null;
	public String sectionName = null;
	
	@Override
	public void parse(JSONObject object) {
		// TODO Auto-generated method stub
		try {
			this.sectionCode = object.get("seccode").toString();
			this.sectionName = object.get("secname").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
