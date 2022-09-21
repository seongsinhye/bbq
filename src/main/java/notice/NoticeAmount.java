package main.java.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice/amount")
public class NoticeAmount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록된 공지사항의 개수를 클라이언트에게 전달 
		int noticeAmount = notice.NoticeWrite.noticeInfoList.size();
		
		PrintWriter output = response.getWriter();
		
		output.print(noticeAmount);
		output.close();
	}

	

}
