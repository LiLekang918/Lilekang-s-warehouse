package com.llk.laborsystem.controller.users;

import com.llk.laborsystem.bean.users.Users;
import com.llk.laborsystem.bean.vo.Vo;
import com.llk.laborsystem.service.users.UsersService;
import com.llk.laborsystem.utils.email.MailUtil;
//import com.llk.laborsystem.utils.redis.RedisUtil;
import com.llk.laborsystem.utils.redis.RedisUtil;
import com.llk.laborsystem.utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 用户接口控制器
 * @Author: 李乐康
 * @Date: 2022-04-10 10:33
 */

@Controller
@RequestMapping("/userinfo")
@CrossOrigin
public class UsersController {

    private Integer verification;

    public static long midTime;

//    public ThreadOne t1 = new ThreadOne("通过判断标志位");

    private static Boolean flag=true;
    @Autowired
    private UsersService usersService;

    private MailUtil mailUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/demo2")
    @ResponseBody
    public Object demo2(){

        List list=new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");
//        redisUtil.addList("nameList",list);
//        redisUtil.remove("name","age");
//        redisUtil.set("name","lilekang");
        Object name = redisUtils.get("name");
        return name;
    }
    @RequestMapping("/demo")
    @ResponseBody
    public String demo(Users users){
        System.out.println(users);
        return users.toString();
    }

    //查询是否有该邮箱
    @RequestMapping("/getEmail")
    @ResponseBody
    public Users getEmail(Users users){
        System.out.println(users);
        return usersService.getEmail(users);
    }

    //判断登陆的账号是否正确
    @RequestMapping("/userLogin")
    @ResponseBody
    public Users userLogin(Users users,HttpServletResponse response, HttpSession session){
        System.out.println(users);
        String sessionId = session.getId();
        System.out.println("session的ID是:"+sessionId);
        Users user = usersService.userLogin(users);
        if (user!=null){
            Cookie cookie=new Cookie("user",user.getUId().toString());
            cookie.setMaxAge(60*60*24);//60*60*24
            response.addCookie(cookie);
            System.out.println("登陆成功!");
            return user;
        }else {
            System.out.println("账号或密码错误");
            return null;
        }
    }

    //判断cookie里面是否为空
    @RequestMapping("/isNull")
    @ResponseBody
    public Users isNull(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Users isLogins=null;
        if (cookies==null){
            System.out.println("没有cookie数据");
            return isLogins=null;
        }else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")){
                    if (cookie.getValue()!=null&&cookie.getValue()!=""){
                        String name = cookie.getName();
                        String value = cookie.getValue();
                        System.out.println(name+":"+value);
                        int userId = Integer.parseInt(value);
                        Users userById = usersService.getUserById(userId);
                        return isLogins=userById;
                    }else {
                        System.out.println("cookie失效");
                    }
                }else {
                    System.out.println("cookie失效");
                }
            }
        }
        return isLogins;
    }
    /**

     * 删除cookie

     * @param request

     * @param response

     * @param id

     */
    @RequestMapping("/delUserCookie")
    @ResponseBody
    public void delUserCookie(HttpServletRequest request,HttpServletResponse response,String id){

        System.out.println("id"+id);

        Cookie[] cookies = request.getCookies();

        if(cookies==null) {

            System.out.println("没有cookie");

        }else{
            Cookie cookie=new Cookie("user",null);
            cookie.setMaxAge(0);// 立即销毁cookie
            System.out.println("被删除的cookie名字为:"+cookie.getName());
            response.addCookie(cookie);

        }

    }


    //发送验证码
    @RequestMapping("/verificationCode")
    @ResponseBody
    public void verificationCode(Users users){
        System.out.println(users.getUEmail());
        int random=(int)(((Math.random()*9+1)*100000));
        verification=random;
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = dateFormat.format(date);
        mailUtil.sendText(users.getUEmail(),"修改密码验证码","【智慧工地】"+random+"(智慧工地验证码,请勿泄露),发送时间"+format);
        System.out.println("发送成功");
        midTime=60;
        time();
        int random2=(int)(((Math.random()*9+1)*100000));
        verification=random2;
        System.out.println(""+verification);
    }

    //设置秒数
    public void time(){

        while (midTime>0){
            if (flag){
                midTime--;
                long ss=midTime%60;
                System.out.println("还剩"+ss+"秒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("验证通过,验证码失效!");
                flag=true;
                break;
            }
        }
    }
    //验证验证码
    @RequestMapping("/yanzhengma")
    @ResponseBody
    public Boolean yanzheng(@RequestBody Vo vo){
        System.out.println("验证码"+vo.getCode()+":"+verification);
        if (verification==null){
            return false;
        }
        if (vo.getCode().equals(Integer.toString(verification))){
            flag = false;
            return true;
        }else {
            return false;
        }
    }

    //判断是否有该用户
    @RequestMapping("/getUserByName")
    @ResponseBody
    public Users getUserByName(String uName){
        Users userByName = usersService.getUserByName(uName);
        return userByName;
    }

    //修改密码
    @RequestMapping("/resetPasswords")
    @ResponseBody
    public Boolean resetPasswords(Users users) throws NoSuchAlgorithmException {

        Boolean editUser = usersService.editUser(users);

        System.out.println(editUser);

        return editUser;
    }

    /**

     * 添加cookie

     * @param response

     * @param name

     * @param value

     */

    @RequestMapping("/addCookie")

    public void addCookie(HttpServletResponse response,String name,String value){

        Cookie cookie = new Cookie(name.trim(), value.trim());//trim() 方法用于删除字符串的头尾空白符。

        cookie.setMaxAge(60*60*24);// 设置为24小时 60秒*60分*24小时

        cookie.setPath("/");//因此cookie.setPath("/");之后，可以在webapp文件夹下的所有应用共享cookie，而cookie.setPath("/webapp/")是指设置的cookie只能在webapp应用下的获得

        System.out.println("已添加cookie");

        response.addCookie(cookie);//最后用response的addCookie()添加设置的cookie

    }

    /**

     * 读取所有cookie

     * 注意二、从客户端读取Cookie时，包括maxAge在内的其他属性都是不可读的，也不会被提交。浏览器提交Cookie时只会提交name与value属性。maxAge属性只被浏览器用来判断Cookie是否过期

     * @param request

     * @param response

     */

    @RequestMapping("/getCookies")

    public void showCookies(HttpServletRequest request,HttpServletResponse response ){

        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组,获得全部cookie

        if(cookies==null) {

            System.out.println("没有cookie");

        }else{

            for(Cookie cookie : cookies){

                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());

                //通过getName()方法获取cookie的名字,通过getValue()获取cookie的值

            }

        }

    }

    /**
     * 修改cookie
     * @param request
     * @param response
     * @param name
     * @param value
     * 注意一、修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。
     */
    @RequestMapping("/editCookie")
    public void editCookie(HttpServletRequest request,HttpServletResponse response,String name,String value){
        Cookie[] cookies = request.getCookies();
        if(cookies==null) {
            System.out.println("没有cookie");
        }else{

            for(Cookie cookie : cookies){

                if(cookie.getName().equals(name)){

                    System.out.println("原值为:"+cookie.getValue());

                    cookie.setValue(value);//这个赋的是方法的形参

                    cookie.setPath("/");

                    cookie.setMaxAge(60*60*24);// 设置为30min

                    System.out.println("被修改的cookie名字为:"+cookie.getName()+",新值为:"+cookie.getValue());

                    response.addCookie(cookie);

                    break;
                }
            }
        }
    }

    /**

     * 删除cookie

     * @param request

     * @param response

     * @param name

     */
    @RequestMapping("/delCookie")

    public void delCookie(HttpServletRequest request,HttpServletResponse response,String name){

        Cookie[] cookies = request.getCookies();

        if(cookies==null) {

            System.out.println("没有cookie");

        }else{

            for(Cookie cookie : cookies){

                if(cookie.getName().equals(name)){

                    cookie.setValue(null);

                    cookie.setMaxAge(0);// 立即销毁cookie

                    cookie.setPath("/");

                    System.out.println("被删除的cookie名字为:"+cookie.getName());

                    response.addCookie(cookie);

                    break;

                }

            }

        }

    }

    /**

     * 根据名字获取cookie

     * @param request

     * @param name cookie名字

     * @return

     */

    @RequestMapping("/getCookieByName")
    public Cookie getCookieByName(HttpServletRequest request,String name){

        Map<String,Cookie> cookieMap = ReadCookieMap(request);

        if(cookieMap.containsKey(name)){

            Cookie cookie = (Cookie)cookieMap.get(name);

            return cookie;

        }else{

            return null;

        }

    }


    /**

     * 将cookie封装到Map里面

     * @param request

     * @return

     */
    @RequestMapping("/ReadCookieMap")
    private Map<String,Cookie> ReadCookieMap(HttpServletRequest request){

        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();

        Cookie[] cookies = request.getCookies();

        if(null!=cookies){

            for(Cookie cookie : cookies){

                cookieMap.put(cookie.getName(), cookie);

            }

        }

        return cookieMap;

    }

}
