package main.java.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice/list")
public class NoticeList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 공지사항 목록에 저장된 공지사항이 없는 경우
		if(notice.NoticeWrite.noticeInfoList.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			// 공지사항 목록에 저장된 공지사항이 있을 경우 json으로 구성해 목록을 전달함 
			response.setContentType("application/json;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			String json = "[";
			
			// 자바가 가지고있는 공지사항 목록을 처음부터 끝까지 접근해서
			// 클라이언트에게 전달할 n번째 공지사항의 정보로 구성하고
			// 공지사항 정보 목록에 배열의 형태로 저장한다.
			for(notice.NoticeInfo nth : notice.NoticeWrite.noticeInfoList) {
				String data = "{\"title\": \"" + nth.getTitle() + "\" , \"contents\": \"" + nth.getContents()  + "\"}";
				json = json + data +",";
			}
			
			json = json.substring(0, json.length()-1);
			json = json + "]";
			
			output.print(json);
			
			output.close();
		}
		
	}


}
