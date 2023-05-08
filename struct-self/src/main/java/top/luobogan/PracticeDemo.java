package top.luobogan;

import org.apache.commons.lang3.StringUtils;
import top.luobogan.tree.binarySearchTree.printer.Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2022/11/26
 */
public class PracticeDemo {

    public static void main(String[] args) {
        String haha = haha();
        System.out.println(haha);

        String s = KkgetRoomTimeInfo();
        System.out.println(s);
    }

    static String haha(){
        long dc = 0L;
        long seconds = dc / 1000;// 毫秒
        long date = seconds / (24 * 60 * 60);     //天数
        long hour = (seconds - date * 24 * 60 * 60) / (60 * 60);//小时数
        long minut = (seconds - date * 24 * 60 * 60 - hour * 60 * 60) / (60);//分钟数
//        long second = (seconds - date * 24 * 60 * 60 - hour * 60 * 60 - minut * 60);//秒数

//        String result = (date == 0 ? "" : (date + ResourceUtil.getString("common.time.day")+",")) + (hour == 0 ? "" : (hour + ResourceUtil.getString("common.time.hour")+",")) + (minut == 0 ? "" : (minut + ResourceUtil.getString("common.time.hour")));

        List list = new ArrayList();

        if (date  != 0) {
            list.add((date  + "common.time.day" ));
        }
        if (hour  != 0) {
            list.add((hour  + "common.time.hour"));
        }
        if (minut != 0) {
            list.add((minut + "common.time.minute"));
        }
        String result = join(list, ",");

        return isBlank(result) ? "common.default" : result;
    }

    public static String join(Collection collection, String separator) {
        return StringUtils.join(collection, separator);
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static String KkgetRoomTimeInfo()  {

        long dc = 0L;
        long time = 14400000;
        long difference = Math.abs(time-dc);
        long  minute = difference / (1000*60);

        return isBlank(String.valueOf(minute))? String.valueOf(0) : String.valueOf(minute);
    }

}
