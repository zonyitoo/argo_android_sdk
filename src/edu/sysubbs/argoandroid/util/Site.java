package edu.sysubbs.argoandroid.util;

public class Site {
	public static final String SITE = "http://bbs.sysu.edu.cn/api";
	public static final String LOGIN = SITE + "/login/";
	public static final String LOGOUT = SITE + "/logout/";
	
	public static final String QUERY_SECTION = SITE + "/section/";
	
	public static final String QUERY_FAV_BOARD = SITE + "/user/fav/";
	public static final String ADD_FAV_BORAD = SITE + "/user/addfav/";
	public static final String DEL_FAV_BOARD = SITE + "/user/delfav/";
	public static final String QUERY_USER_INFO = SITE + "/user/query/";
	public static final String UPDATE_USER_INFO = SITE + "/user/update/";
	public static final String GET_SELF_INFO = SITE + "/user/info/";
	
	public static final String GET_AVATAR = "http://bbs.sysu.edu.cn/avatar/";
	
	public static final String GET_ALL_BORAD_NAME = SITE + "/board/all/";
	public static final String GET_ALL_BOARD_INFO = SITE + "/board/alls/";
	public static final String GET_BOARD_INFO = SITE + "/board/get/";
	public static final String GET_BOARD_INFO_BY_SECCODE = "/board/getbysec/";
	public static final String CLEAR_BOARD_UNREAD = "/board/clear/";
	public static final String GET_READED_POST_INDEX_LIST = "/board/readmark/";
	
	public static final String GET_POST_LIST = SITE + "/post/list/";
	public static final String GET_POST_NEARNAME = SITE + "/post/nearname/";
	public static final String GET_POST_TOPICLIST = SITE + "/post/topiclist/";
	public static final String POST_POST_ADD = SITE + "/post/add/";
	public static final String POST_POST_DEL = SITE + "/post/del/";
	
	public static final String GET_MAILBOX = SITE + "/mail/mailbox/";
	public static final String GET_MAIL_LIST = SITE + "/mail/list/";
	public static final String POST_MAIL_SEND = SITE + "/mail/send/";
	public static final String POST_MAIL_DEL = SITE + "/mail/del/";
	
	public static final String GET_COMM_TOPTEN = SITE + "/comm/topten/";
}
