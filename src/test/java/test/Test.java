package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hongmoshui.com.cnblogs.www.work.model.Person;

public class Test
{
    public static void main(String[] args)
    {
        final Map<Integer, List<Person>> map = new HashMap<Integer, List<Person>>();
        int i = 1;
        List<Person> pl = new ArrayList<Person>();
        Person p = new Person();
        p.setAge(100);
        p.setName("张三");
        p.setHeight(182);
        p.setWeight(65);
        pl.add(p);
        pl.add(p);
        map.put(i, pl);
        System.out.println(map.get(i + 1));
        int j = 2147483647;
        int k = 2147483647;
        Integer j1 = 2147483647;
        Integer k1 = 2147483647;
        System.out.println(j == k);
        System.out.println(j1 == k1);
    }
}
