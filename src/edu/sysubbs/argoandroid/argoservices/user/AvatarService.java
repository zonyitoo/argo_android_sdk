package edu.sysubbs.argoandroid.argoservices.user;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import edu.sysubbs.argoandroid.util.ErrorCode;
import edu.sysubbs.argoandroid.util.ErrorException;
import edu.sysubbs.argoandroid.util.HttpManager;
import edu.sysubbs.argoandroid.util.Site;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AvatarService {
	public Bitmap getUserAvatar(String userid) throws ErrorException {
		HttpManager manager = new HttpManager();
		try {
			HttpURLConnection connection = manager.baseConnect(Site.GET_AVATAR + userid, null, "GET");
			connection.connect();
			if (connection.getResponseCode() != 404) {
				InputStream is = connection.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(is);
				return bitmap;
			}
			else {
				throw new ErrorException("User not found", ErrorCode._303);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateAvatar(String cookie, Bitmap avatar) {
		// not implement
		return false;
	}
}
