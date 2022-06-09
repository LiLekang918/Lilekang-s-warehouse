package com.llk.laborsystem.demo;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
* @ClassName: SmsTest
* @Description:JAVA发送手机短信,httpclient短信发送接口示例(java)
* @date: 2017年8月15日
* @修改备注:
*/
public class SendMsg_httpclient {
 
	public static void main(String[] args) {
		String info = null;
		try{
			HttpClient httpclient = new HttpClient();//方法调用
			PostMethod post = new PostMethod("http://211.90.245.137:8888/sms/Api/Send.do");//接口地址
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gbk");//格式转换
			post.addParameter("SpCode", "000001");//接口数据
			post.addParameter("LoginName", "test");//接口用户名
			post.addParameter("Password", "aaaaaa");//接口密码
			post.addParameter("MessageContent", "测试20110802");//短信内容
			post.addParameter("UserNumber", "18616330318");//要发送短信的手机号，可多个手机号，用逗号隔开。
			post.addParameter("SerialNumber", "20110801142517000000");//序列号
			post.addParameter("ScheduleTime", "");//发送时间，如果定时发送，可插入时间
			post.addParameter("f", "1");
			httpclient.executeMethod(post);
			info = new String(post.getResponseBody(),"gbk");
			System.out.println(info);
			//最后得到结果后，是一个字符长串，截取有用的信息，可判断短信是否发送成功
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}