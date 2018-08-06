package me.jinkun.rds.common.utils;
import com.danga.MemCached.MemCachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;


/** 
 * 类名称：MemcachedUtil 
 * 类描述： MemCached的工具类 
 * 创建人：dzl 
 * 创建时间：2018年2月2日 上午10:52:14
 * 修改人：dzl 
 * 修改时间：2018年2月2日 上午10:52:14
 * 修改备注： 
 * @version 
 */ 
public class MemcachedUtil {  

	/**
     * cachedClient.
     */
    private static MemCachedClient cachedClient;
    static {
        if (cachedClient == null) {
            cachedClient = new MemCachedClient("memcachedPool");
        }
        System.out.println("Connection to server sucessful.");

    }

   /**
    * 构造函数:工具类，禁止实例化
    */
   private MemcachedUtil() {
   }

   /***
    * 功能描述:新增一个缓存数据，如果key存在不会新增
    * 规范：前缀+Const.XXX后缀
    * @param key 缓存的key
    * @param value 缓存的值
    * @return 操作结果
    */
   public static boolean add(String key, Object value) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.add(key, value);
   }

   /**
    * 功能描述:新增一个缓存数据，设置过期时间参数为秒
    * 规范：前缀+Const.XXX后缀
    * @param key 缓存的key
    * @param value 缓存的值
    * @param expire 缓存时间
    * @return 操作结果
    */
   public static boolean add(String key, Object value, Integer expire) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.add(key, value, expire);
   }

   /**
    * 功能描述:新增一个缓存数据，如果存在key，则更新该key的值
    * 规范：前缀+Const.XXX后缀
    * @param key 缓存的key
    * @param value 缓存的值
    * @return 操作结果
    */
   public static boolean put(String key, Object value) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.set(key, value);
   }

   /**
    * 功能描述:新增一个缓存数据，如果存在key，则更新该key的值
    * 规范：前缀+Const.XXX后缀
    * @param key 缓存的key
    * @param value 缓存的值
    * @param expire 缓存时间
    * @return 操作结果
    */
   public static boolean put(String key, Object value, Integer expire) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //关闭缓存
		   return false;
	   }
       return cachedClient.set(key, value, expire);
   }

   /**
    * 功能描述:替换一个缓存数据，如果存在key则替换，否则返回false
    * 规范：前缀+Const.XXX后缀
    * @param key
    * @param value
    * @return 操作结果
    */
   public static boolean replace(String key, Object value) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //关闭缓存
		   return false;
	   }
       return cachedClient.replace(key, value);
   }

   /**
    * 功能描述:替换一个缓存数据，如果存在key则替换，否则返回false
    * 规范：前缀+Const.XXX后缀
    * @param key
    * @param value
    * @param expire 缓存时间
    * @return 操作结果
    */
   public static boolean replace(String key, Object value, Integer expire) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.replace(key, value, expire);
   }

   /**
    * 功能描述:根据key得到一个缓存数据
    * 规范：前缀+Const.XXX后缀
    * @param key
    * @return 操作结果
    */
   public static Object get(String key) {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
//		   开启缓存
		   return null;
	   }
       return cachedClient.get(key);
   }

   /**
    * 功能描述:刷新全部缓存(就是将所有缓存设置为过期，以后放入的会覆盖掉这些过期的缓存数据)
    *  规范：前缀+Const.XXX后缀
    * @return 操作结果
    */
   public static boolean flushAll() {
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.flushAll();
   }

   /***
    * 功能描述:根据key删除一个缓存数据
    * 规范：前缀+Const.XXX后缀
    * @return 操作结果
    */
   public static boolean delete(String key){
	   String cache = (String) Jurisdiction.getPprVue("config", "cache");
	   if("0".equals(cache)){
		   //开启缓存
		   return false;
	   }
       return cachedClient.delete(key);
   }
     
}  