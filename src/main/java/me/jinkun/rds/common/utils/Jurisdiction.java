package me.jinkun.rds.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.awt.ComponentFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 权限处理
 * @author:fh qq 313596790[青苔]
 * 修改日期：2015/11/19
*/
public class Jurisdiction {

//	/**
//	 * 访问权限及初始化按钮权限(控制按钮的显示 增删改查)
//	 * @param menuUrl  菜单路径
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static boolean hasJurisdiction(String menuUrl){
//		//判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
//		/**
//		 * 根据点击的菜单的xxx.do去菜单中的URL去匹配，当匹配到了此菜单，判断是否有此菜单的权限，没有的话跳转到404页面
//		 * 根据按钮权限，授权按钮(当前点的菜单和角色中各按钮的权限匹对)
//		 */
//		String USERNAME = getUsername();	//获取当前登录者loginname
//		Session session = getSession();
//		List<Menu> menuList = (List<Menu>)session.getAttribute(USERNAME + Const.SESSION_allmenuList); //获取菜单列表
//		System.out.println("lc--------------"+menuList+"-----------------"+USERNAME);
//		if (menuList==null) {
//			return false;
//		}
//		return readMenu(menuList,menuUrl,session,USERNAME);
//	}
//
//	/**校验菜单权限并初始按钮权限用于页面按钮显示与否(递归处理)
//	 * @param menuList:传入的总菜单(设置菜单时，.do前面的不要重复)
//	 * @param menuUrl:访问地址
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static boolean readMenu(List<Menu> menuList, String menuUrl, Session session, String USERNAME){
//		for(int i=0;i<menuList.size();i++){
//			if(menuList.get(i).getMENU_URL().split(".do")[0].equals(menuUrl.split(".do")[0])){ //访问地址与菜单地址循环匹配，如何匹配到就进一步验证，如果没匹配到就不处理(可能是接口链接或其它链接)
//				if(!menuList.get(i).isHasMenu()){				//判断有无此菜单权限
//					return false;
//				}else{											//按钮判断
//					Map<String, String> map = (Map<String, String>)session.getAttribute(USERNAME + Const.SESSION_QX);//按钮权限(增删改查)
//					map.remove("add");
//					map.remove("del");
//					map.remove("edit");
//					map.remove("cha");
//					String MENU_ID =  menuList.get(i).getMENU_ID();
//					Boolean isAdmin = "admin".equals(USERNAME);
//					map.put("add", (RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin?"1":"0");
//					map.put("del", RightsHelper.testRights(map.get("dels"), MENU_ID) || isAdmin?"1":"0");
//					map.put("edit", RightsHelper.testRights(map.get("edits"), MENU_ID) || isAdmin?"1":"0");
//					map.put("cha", RightsHelper.testRights(map.get("chas"), MENU_ID) || isAdmin?"1":"0");
//					session.removeAttribute(USERNAME + Const.SESSION_QX);
//					session.setAttribute(USERNAME + Const.SESSION_QX, map);	//重新分配按钮权限
//					return true;
//				}
//			}else{
//				if(!readMenu(menuList.get(i).getSubMenu(),menuUrl,session,USERNAME)){//继续排查其子菜单
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * 按钮权限(方法中校验)
//	 * @param menuUrl  菜单路径
//	 * @param type  类型(add、del、edit、cha)
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static boolean buttonJurisdiction(String menuUrl, String type){
//		//判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
//		/**
//		 * 根据点击的菜单的xxx.do去菜单中的URL去匹配，当匹配到了此菜单，判断是否有此菜单的权限，没有的话跳转到404页面
//		 * 根据按钮权限，授权按钮(当前点的菜单和角色中各按钮的权限匹对)
//		 */
//		String USERNAME = getUsername();	//获取当前登录者loginname
//		Session session = getSession();
//		List<Menu> menuList = (List<Menu>)session.getAttribute(USERNAME + Const.SESSION_allmenuList); //获取菜单列表
//		return readMenuButton(menuList,menuUrl,session,USERNAME,type);
//	}
//
//	/**校验按钮权限(递归处理)
//	 * @param menuList:传入的总菜单(设置菜单时，.do前面的不要重复)
//	 * @param menuUrl:访问地址
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static boolean readMenuButton(List<Menu> menuList, String menuUrl, Session session, String USERNAME, String type){
//		for(int i=0;i<menuList.size();i++){
//			if(menuList.get(i).getMENU_URL().split(".do")[0].equals(menuUrl.split(".do")[0])){ //访问地址与菜单地址循环匹配，如何匹配到就进一步验证，如果没匹配到就不处理(可能是接口链接或其它链接)
//				if(!menuList.get(i).isHasMenu()){				//判断有无此菜单权限
//					return false;
//				}else{											//按钮判断
//					Map<String, String> map = (Map<String, String>)session.getAttribute(USERNAME + Const.SESSION_QX);//按钮权限(增删改查)
//					String MENU_ID =  menuList.get(i).getMENU_ID();
//					Boolean isAdmin = "admin".equals(USERNAME);
//					if("add".equals(type)){
//						return ((RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin);
//					}else if("del".equals(type)){
//						return ((RightsHelper.testRights(map.get("dels"), MENU_ID)) || isAdmin);
//					}else if("edit".equals(type)){
//						return ((RightsHelper.testRights(map.get("edits"), MENU_ID)) || isAdmin);
//					}else if("cha".equals(type)){
//						return ((RightsHelper.testRights(map.get("chas"), MENU_ID)) || isAdmin);
//					}
//				}
//			}else{
//				if(!readMenuButton(menuList.get(i).getSubMenu(),menuUrl,session,USERNAME,type)){//继续排查其子菜单
//					return false;
//				};
//			}
//		}
//		return true;
//	}
//
//	/**获取当前登录的用户名
//	 * @return
//	 */
//	public static String getUsername(){
//		return getSession().getAttribute(Const.SESSION_USERNAME).toString();
//	}
//
//	/**获取用户的最高组织机构权限集合
//	 * @return
//	 */
//	public static String getDEPARTMENT_IDS(){
//		return getSession().getAttribute(Const.DEPARTMENT_IDS).toString();
//	}
//
//	/**获取用户的最高组织机构权限
//	 * @return
//	 */
//	public static String getDEPARTMENT_ID(){
//		return getSession().getAttribute(Const.DEPARTMENT_ID).toString();
//	}
//
//	/**获取当前按钮权限(增删改查)
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static Map<String, String> getHC(){
//		return (Map<String, String>)getSession().getAttribute(getUsername() + Const.SESSION_QX);
//	}
//
//	/**shiro管理的session
//	 * @return
//	 */
//	public static Session getSession(){
//		Session session = SecurityUtils.getSubject().getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);
//
//		if(user==null){
//			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//			ShiroSessionDao sessionDao = new ShiroSessionDao();
//			Cookie[] cookies = request.getCookies();
//			for (int i = 0; i < cookies.length; i++) {
//				Cookie cookie = cookies[i];
//				String name = cookie.getName();
//				if(Const.SESSION_USER.equals(name)){
//					String value = cookie.getValue();
//					Object object = MemcachedUtil.get(value);
//					if(object!=null){
//						Serializable sessionId = (Serializable) object;
//						session = sessionDao.readSession(sessionId);
//					}
//				}
//
//			}
//		}
//
////		Subject currentUser = SecurityUtils.getSubject();
//		return session;
//	}
//
//	/**获取当前登录的用户所有信息
//	 * @return
//	 */
//	public static User getUserInfo(){
//		User user = (User)getSession().getAttribute(Const.SESSION_USER);
//		return user;
//	}
//	/**
//	 * @Title: getOrgNo
//	 * @Description: TODO(获取orgName和OrgNo)
//	 * @param userNo
//	 * @return 设定文件
//	 * @return Map 返回类型
//	 */
//	public static Map getOrgNo(String userNo){
//		JdbcTemplate jdbcTemplate = (JdbcTemplate) ComponentFactory.getBean("jdbcTemplate");
//
//		Map<String, Object> queryForMap = jdbcTemplate.queryForMap("SELECT ORG_NO,ORG_NAME from a_user_info t where t.user_no='"+userNo+"'");
//
//		return queryForMap;
//	}
	/** 
	 * @Title: getPprVue 
	 * @Description: TODO(读取配置文件) 
	 * @param @param name  文件名
	 * @param @param key   key值
	 * @param @return 设定文件 
	 * @return Object 返回类型 
	 * @throws 
	 */ 
	public static Object getPprVue(String name,String key) {
		InputStream inputStream = DbFH.class.getClassLoader().getResourceAsStream(name+".properties");
		Properties p = new Properties();
		try {
			p.load(new InputStreamReader(inputStream, "utf-8"));
			inputStream.close();
		} catch (IOException e) {
			//读取配置文件出错
			e.printStackTrace();
		}
		return  p.get(key);
	}
}
