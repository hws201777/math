package cn.hws.math.demo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hws on 2017/5/10.
 */
public class maintest {

    @Test
    public void a(){
        people p = new people();
        p.setId(2);
        p.setName("hws");
        User u = new User();
        u.setAge(4);
        u.setClassname("mmmm");
        Map map = new HashMap<>();





        map.put("p",p);
        map.put("u",u);
        System.out.print("44543");

        System.out.print("2222");System.out.print("2221");System.out.print("123");System.out.print("123");





    }
    @Test
    public void aaa(){
        Map map = new HashMap<>();
        setTime(map,14);
        System.out.print(map);
    }

    private void setTime(Map map,int val) {
        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
            cal.add(Calendar.DATE, -(day_of_week+val));
            String startTime = format.format(cal.getTime());
            map.put("startTime",format2.parse(startTime+" 00:00:00"));
            map.put("startTimeLimit",format2.parse(startTime+" 00:00:00"));
            cal.add(Calendar.DATE, 6);
            String endTime = format.format(cal.getTime());
            map.put("endTime",format2.parse(endTime+" 23:59:59"));
            map.put("endTimeLimit",format2.parse(endTime+" 23:59:59"));
            if(val==0){
                map.remove("endTime");
                map.remove("startTime");
            }else{
                map.remove("startTimeLimit");
                map.remove("endTimeLimit");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
