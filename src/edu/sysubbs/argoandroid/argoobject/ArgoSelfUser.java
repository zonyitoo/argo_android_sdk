package edu.sysubbs.argoandroid.argoobject;

import org.json.JSONException;
import org.json.JSONObject;

import edu.sysubbs.argoandroid.util.ArgoConstant;

import android.util.Log;

public class ArgoSelfUser extends BaseObject {

	public String userid = null; // 自己的id
	public String username = null; // username
	public String realname = null; // 真实名字
	public String email = null; // 用户邮箱
	public String birthyear = null; // 出生年份(some problems, the server always return 200)
	public String birthmonth = null; // 出生月份
	public String birthday = null; // 出生日 
	public String address = null; // 地址
	public String stay = null; // 在线时间
	public String signature = null; // 签名
	public String numposts = null; // 发帖数
	public String nummails = null; // 邮件数
	public String numlogins = null; // 登录次数
	public String lastlogin = null; // 最后登录时间
	public String lastlogout = null; // 最后登出时间
	public String lasthost = null; // 最后登录的地址
	public String gender = null; // 性别，M or F
	public String firstlogin = null; // 第一次登录的时间
	
	@Override
	public void parse(JSONObject object) {
		// TODO Auto-generated method stub
		try {
			this.userid = object.get("userid").toString();
			this.username = object.get("username").toString();
			this.realname = object.get("realname").toString();
			this.email = object.get("realname").toString();
			this.birthyear = object.get("birthyear").toString();
			this.birthmonth = object.get("birthmonth").toString();
			this.birthday = object.get("birthday").toString();
			this.address = object.get("address").toString();
			this.stay = object.get("stay").toString();
			this.signature = object.get("signature").toString();
			this.numposts = object.get("numposts").toString();
			this.nummails = object.get("nummails").toString();
			this.numlogins = object.get("numlogins").toString();
			this.lastlogin = object.get("lastlogin").toString();
			this.lastlogout = object.get("lastlogout").toString();
			this.gender = object.get("gender").toString();
			int charNum = Integer.valueOf(this.gender);
			char genderChar = Character.valueOf((char) charNum);
			this.gender = "" + genderChar;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
