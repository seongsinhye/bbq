package main.java.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice/write")
public class NoticeWrite extends HttpServlet {
	public static List<notice.NoticeInfo> noticeInfoList = new ArrayList<>();

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 공지사항 제목, 내용을 꺼낸다 
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		notice.NoticeInfo newNoticeInfo = new notice.NoticeInfo(title, contents);
		
		// 공지사항 정보 목록에 공지사항 정보를 저장한다.
		noticeInfoList.add(newNoticeInfo);
		
		// 공지사항 목록페이지로 이동을 지시한다.
		response.sendRedirect("/bbq/notice_list.html");
		
	}

}
