package edu.sysubbs.argoandroid.util;

public class Site {
	public static String SITE = "http://bbs.sysu.edu.cn/api";
	public static String LOGIN = SITE + "/login/";
	public static String LOGOUT = SITE + "/logout/";
	
	public static String QUERY_SECTION = SITE + "/section/";
	
	public static String QUERY_FAV_BOARD = SITE + "/user/fav/";
	public static String ADD_FAV_BORAD = SITE + "/user/addfav/";
	public static String DEL_FAV_BOARD = SITE + "/user/delfav/";
	public static String QUERY_USER_INFO = SITE + "/user/query/";
	public static String UPDATE_USER_INFO = SITE + "/user/update/";
	public static String GET_SELF_INFO = SITE + "/user/info/";
	
	public static String GET_AVATAR = "http://bbs.sysu.edu.cn/avatar/";
	
	public static String GET_ALL_BORAD_NAME = SITE + "/board/all/";
	public static String GET_ALL_BOARD_INFO = SITE + "/board/alls/";
	public static String GET_BOARD_INFO = SITE + "/board/get/";
	public static String GET_BOARD_INFO_BY_SECCODE = "/board/getbysec/";
	public static String CLEAR_BOARD_UNREAD = "/board/clear/";
	public static String GET_READED_POST_INDEX_LIST = "/board/readmark/";
}
