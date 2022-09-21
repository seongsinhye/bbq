//package main.java.etc;
//
//import java.io.IOException;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import main.java.customerInfo.Info;
//import main.java.customerInfo.inputCustomerInfo;
//import notice.NoticeInfo;
//import notice.NoticeWrite;
//
//
//@WebServlet(urlPatterns = {"/StartupProcessor"}, loadOnStartup = 1)
//public class StartupProcessor extends HttpServlet {
//
//	@Override
//	public void init() throws ServletException {
//		NoticeInfo n1 = new NoticeInfo("공지사항1","내용1");
//		NoticeInfo n2 = new NoticeInfo("공지사항2","내용2");
//		NoticeInfo n3 = new NoticeInfo("공지사항3","내용3");
//
//		NoticeWrite.noticeInfoList.add(n1);
//		NoticeWrite.noticeInfoList.add(n2);
//		NoticeWrite.noticeInfoList.add(n3);
//
////		for(int i=1; i<=20; i++) {
////			NoticeInfo n = new NoticeInfo("공지사항"+i, "내용"+i);
////			NoticeWrite.noticeInfoList.add(n);
////		}
//
//		Info admin1 = new Info("admin01", "admin1234!", "admin01@naver.com", "관리자", "");
//		inputCustomerInfo.customerInfoList.add(admin1);
//
//	}
//
//
//
//
//}
