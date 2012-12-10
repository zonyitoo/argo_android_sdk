package com.ragnarok.argoandroid.argoservices;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import com.ragnarok.argoandroid.util.ErrorCode;
import com.ragnarok.argoandroid.util.ErrorException;
import com.ragnarok.argoandroid.util.HttpManager;
import com.ragnarok.argoandroid.util.Site;

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
				throw new ErrorException("user not exist", ErrorCode._303);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
