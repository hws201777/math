package cn.hws.math.demo;

import org.junit.Test;

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
        System.out.print("123");

    }

}
