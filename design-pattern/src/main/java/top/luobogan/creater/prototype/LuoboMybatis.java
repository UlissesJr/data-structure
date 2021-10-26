package top.luobogan.creater.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/10/26
 */
public class LuoboMybatis {

    private final Map<String,User> userCache = new HashMap<String, User>();

    public User getUser(String username) throws CloneNotSupportedException {
        User user = null;
        if(!userCache.containsKey(username)){
            user = getUserFromDB(username);
        }else {
            user = userCache.get(username);
        }
        return (User)user.clone();
    }

    /**
     * 从数据库查数据
     * @return
     */
    private User getUserFromDB(String username){
        System.out.println("从数据库查数据:"+username+",并且查询到对象。");
        User user = new User();
        user.setUsername("luobogan");
        user.setAge(18);
        userCache.put(username,user);
        return user;
    }

}
