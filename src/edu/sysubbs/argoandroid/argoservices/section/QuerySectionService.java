package edu.sysubbs.argoandroid.argoservices.section;

import java.util.ArrayList;

import android.util.Log;

import edu.sysubbs.argoandroid.argoobject.ArgoSection;
import edu.sysubbs.argoandroid.util.ArgoConstant;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

public class QuerySectionService {
	public ArrayList<ArgoSection> getAllSections() throws ErrorException {
		HttpManager manager = new HttpManager();
		ArrayList<ArgoSection> sectionList = manager.getResponseAsList(Site.QUERY_SECTION, null, null, ArgoSection.class);
		return sectionList;
	}
}
