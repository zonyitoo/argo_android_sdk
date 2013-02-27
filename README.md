argo_android_sdk
================

这个是argo的android版SDK，按照[这里][1]的描述编写

# 使用说明

下载好之后，导入进eclipse里面，然后作为你的android application project的一个依赖即可

# 基本object说明

和[API说明][1]一样，SDK也有几个基本的object，在[/src/edu/sysubbs/argoandroid/argoobject][2]包下，和API说明里面的
object意义大致相同，这些object有以下这些(有比较不同的意义的object会附有说明)：

- [ArgoAttach][3]
- [ArgoBoard][4](某个板块)
- [ArgoMail][5]
- [ArgoMailBox][6]
- [ArgoMailHead][7]
- [ArgoPost][8]
- [ArgoPostHead][9]
- [ArgoQueryUser][10]
- [ArgoSection][11]
- [ArgoSectionBoards][12](指某个讨论区下的所有板块的object)
- [ArgoSelfUser][13](注意和ArgoQueryUser有所不同，这个是查看自己信息的object，可以用于更新资料，ArgoQueryUser只能用于查询他人的资料)
- [ArgoToptenPost][14]

# SDK使用说明

所有的请求都通过[/src/edu/sysubbs/argoandroid/argoservices][15]包下各个模块的services实现，比如说，你要登录，可以通过
[UserCookieService][16]来实现：

```Java
  UserCookieService cookieService = new UserCookieService();
  try {
		String cookie = cookieService.loginAndGetCookie(Constant.testUsername, Constant.testPasswd);		
	} catch (ErrorException e) {
    // TODO Auto-generated catch block
		Log.d(Constant.LOG_TAG, e.msg);
		e.printStackTrace();
	}
```

``loginAndGetCookie``方法会返回cookie给你，由于argo在登录之后使用cookie来验证身份，因此在某些service的方法里面，会要求
传入cookie，因此cookie应该预先保存好。

其他模块的service也是大致按照这个方法使用，返回值根据请求的不同而有所不同，有些会返回一个``argoobject``的``ArrayList``,
有些则单单返回一个``argoobject``，另外一些则返回true or false

例如这是获取所有板块信息（按照讨论区组织）的代码：

```Java
  ArgoBoardService boardService = new ArgoBoardService();
  try {
		ArrayList<ArgoSectionBoards> sectionBoardsList = boardService.getAllBoardInfo();
			
		Log.d(Constant.LOG_TAG, "sectionBoardsList.size = " + sectionBoardsList.size());
		Log.d(Constant.LOG_TAG, "sectionBoardsList[0].sectionCode = " + sectionBoardsList.get(0).section.sectionCode);
		Log.d(Constant.LOG_TAG, "sectionBoardsList[0].boardList.size = " + sectionBoardsList.get(0).boardList.size());
	} catch (ErrorException e) {
		// TODO Auto-generated catch block
		Log.d(Constant.LOG_TAG, e.msg);
		e.printStackTrace();
	}
```

这是查询某个板块信息的代码：

```Java
  ArgoBoardService boardService = new ArgoBoardService();
  	
	try {
		ArgoBoard board = boardService.getBoardInfo("water");
		Log.d(Constant.LOG_TAG, "board.boardname = " + board.boardname);
		Log.d(Constant.LOG_TAG, "board.BM[0] = " + board.BM.get(0));
	} catch (ErrorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
```

这是清除某个板块未读标记的代码：

```Java
  UserCookieService cookieService = new UserCookieService();
  try {
		String cookie = cookieService.loginAndGetCookie(Constant.testUsername, Constant.testPasswd);
		ArgoBoardService boardService = new ArgoBoardService();
		Log.d(Constant.LOG_TAG, "cookie = " + cookie);
		boolean success = boardService.cleanBoardUnread(cookie, "linux");
		assertEquals(true, success);

	} catch (ErrorException e) {
		// TODO Auto-generated catch block
		Log.d(Constant.LOG_TAG, e.msg);
		e.printStackTrace();
	}
```

其他的services的使用方式也大致相同。

# 关于``ErrorException``

几乎所有的services方法都会抛出此异常，一个``ErrorException``对象包含一个``msg``和``errorCode``变量，``msg``是值错误的
信息，而``errorCode``是指错误码，具体可看[错误码对照表][17]，而在[``ErrorCode``][18]这个类里面，提供了一个快速的比对
（尚未完成）

如果有任何问题，欢迎在[issue][19]中提出

[1]:http://dev.argolab.org/api/index.html
[2]:https://github.com/zonyitoo/argo_android_sdk/tree/master/src/edu/sysubbs/argoandroid/argoobject
[3]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoAttach.java
[4]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoBoard.java
[5]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoMail.java
[6]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoMailBox.java
[7]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoMailHead.java
[8]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoPost.java
[9]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoPostHead.java
[10]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoQueryUser.java
[11]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoSection.java
[12]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoSectionBoards.java
[13]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoSelfUser.java
[14]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoobject/ArgoToptenPost.java
[15]:https://github.com/zonyitoo/argo_android_sdk/tree/master/src/edu/sysubbs/argoandroid/argoservices
[16]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/argoservices/user/UserCookieService.java
[17]:http://dev.argolab.org/api/api_code.html
[18]:https://github.com/zonyitoo/argo_android_sdk/blob/master/src/edu/sysubbs/argoandroid/util/ErrorCode.java
[19]:https://github.com/zonyitoo/argo_android_sdk/issues
