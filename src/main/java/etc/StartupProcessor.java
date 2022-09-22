package main.java.etc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import main.java.notice.NoticeWrite;
import notice.NoticeInfo;


@WebServlet(urlPatterns = {"/StartupProcessor"}, loadOnStartup = 1)
public class StartupProcessor extends HttpServlet {

	@Override
	public void init() throws ServletException {
		NoticeInfo n1 = new NoticeInfo("공지사항1","내용1");
		NoticeInfo n2 = new NoticeInfo("공지사항2","내용2");
		NoticeInfo n3 = new NoticeInfo("공지사항3","내용3");

		NoticeWrite.noticeInfoList.add(n1);
		NoticeWrite.noticeInfoList.add(n2);
		NoticeWrite.noticeInfoList.add(n3);


		customerInfo.Info admin1 = new customerInfo.Info("admin01", "admin1234!", "admin01@naver.com", "관리자", "");
		customerInfo.inputCustomerInfo.customerInfoList.add(admin1);

	}




}
