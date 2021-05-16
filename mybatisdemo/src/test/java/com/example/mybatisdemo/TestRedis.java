package com.example.mybatisdemo;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 17:21 2021/5/16
 * @Modified By:
 */

import com.example.mybatisdemo.utils.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.util.*;

/**
 *ClassName TestRedis
 *@Description TODO
 *@Author: longfei
 *@Date: 2021/5/16 17:21
 *@Version 1.0
 **/

public class TestRedis {
    private Jedis jedis;
    @Before
    public void setup(){
        //连接redis服务器
//        jedis=new Jedis("192.168.81.138",6379);
//        //权限认证
//        jedis.auth("123456");
         jedis= RedisUtil.getJedis();
    }
    /**
     * redis存储字符串
     */
    @Test
    public void testString(){
//-----添加数据----------
        jedis.set("name","张三");//向key-->name中放入了value-->张三
        System.out.println(jedis.get("name"));//执行结果：张三
        jedis.append("name","is my lover");//追加
        System.out.println(jedis.get("name"));
        jedis.del("name");//删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","李四","age","23","qq","476777XXX");
        jedis.incr("age");//进行加1操作
        System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("qq"));

    }
/**
 * redis操作Map
 */
@Test
    public void testMap(){
//--添加数据-----
    Map<String,String> map=new HashMap<String,String>();
    map.put("name","沈珍珠");
    map.put("age","25");
    map.put("address","浙江横店拍摄基地");
    jedis.hmset("大唐荣耀",map );
    //取出“大唐荣耀”中的name，执行结果:[minxr]-->注意结果是一个泛型的List
    //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
    List<String> rsmap=jedis.hmget("大唐荣耀","name","age","address");
    System.out.println(rsmap);
//删除map中的某个键值
    jedis.hdel("大唐荣耀","age");
    System.out.println(jedis.hmget("大唐荣耀","age"));//因为删除了，所以返回的是null
    System.out.println(jedis.hlen("大唐荣耀"));//返回key为user的键中存放的值的个数2
    System.out.println(jedis.exists("大唐荣耀"));//是否存在key为user的记录 返回true
    System.out.println(jedis.hkeys("大唐荣耀"));//返回map对象中的所有key
    System.out.println(jedis.hvals("大唐荣耀"));//返回map对象中的所有value
    Iterator<String> iter=jedis.hkeys("大唐荣耀").iterator();
    while (iter.hasNext()){
        String key=iter.next();
        System.out.println(key+":"+jedis.hmget("大唐荣耀",key));
    }

}

    /**
     * redis操作List
     */
    @Test
    public void testList(){
        //开始前，先移除所有内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));

    }
/**
 * redis操作Set
 */
@Test
public void testSet(){

    try {
        jedis.sadd("漂洋过海来看你","郑楚");
        jedis.sadd("漂洋过海来看你","苏芒");
        jedis.sadd("漂洋过海来看你","唐明");
        jedis.sadd("漂洋过海来看你","唐果果");
        jedis.sadd("漂洋过海来看你","严晓秋");
        //移除“严晓秋”
        jedis.srem("漂洋过海来看你","严晓秋");
        System.out.println(jedis.sismember("漂洋过海来看你","严晓秋"));//判断 “严晓秋” 是否是“漂洋过海来看你”集合的元素
        System.out.println(jedis.srandmember("漂洋过海来看你"));
        System.out.println(jedis.scard("漂洋过海来看你"));//返回集合的元素个数
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Test
public void test() throws InterruptedException {
    //jedis 排序
    //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
    jedis.del("a"); //先清除数据，再加入数据进行测试
    jedis.rpush("a","1");
    jedis.lpush("a","6");
    jedis.lpush("a","3");
    jedis.lpush("a","9");
    System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
    System.out.println(jedis.sort("a")); // [1, 3, 6, 9]  //输入排序后结果
    System.out.println(jedis.lrange("a",0,-1));
}
    @Test
    public void testRedisPool(){
        RedisUtil.getJedis().set("newname","中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
    @Test
    public void testSortedSet(){
        jedis.zadd("百家姓",10000,"赵");
        jedis.zadd("百家姓",9999,"钱");
        jedis.zadd("百家姓",9998,"孙");
        jedis.zadd("百家姓",9997,"李");
        Set<String> set=jedis.zrange("百家姓",0,-1);
        System.out.println("从小到大:"+set);
        Set<String> $set=jedis.zrevrange("百家姓",0,-1);
        System.out.println("从大到小:"+$set);
        Set<String> scoreset=jedis.zrangeByScore("百家姓",9997,9999);
        System.out.println("通过score截取从小到大："+scoreset);
        Set<String> $scoreset=jedis.zrevrange("百家姓",9999,9997);
        System.out.println("通过score截取从大到小："+$scoreset);

    }









}
