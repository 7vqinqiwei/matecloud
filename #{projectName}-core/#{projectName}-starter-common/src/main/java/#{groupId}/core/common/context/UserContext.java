package #{groupId}.core.common.context;


import #{groupId}.core.common.entity.LoginUser;

/**
 * 用户上下文
 *
 * @author #{version}
 */
public class UserContext {

	private static ThreadLocal<LoginUser> userHolder = new ThreadLocal<LoginUser>();

	public static void setUser(LoginUser loginUser) {
		userHolder.set(loginUser);
	}

	public static LoginUser getUser() {
		return userHolder.get();
	}
}
