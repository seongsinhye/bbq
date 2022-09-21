package login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/status")
public class loginStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //로그인 상태 정보 꺼내기
        HttpSession session = request.getSession(); //세션 객체 꺼내고
        String Name = (String)session.getAttribute("nthName"); //세션 이름이 name인 세션을 꺼내서 형변환(object 타입이므로)

        System.out.println(Name);
        if(Name!=null){
            response.setContentType("text/plain;charset=UTF-8"); //보낼데이터의 타입이 텍스트, 한글
            PrintWriter output = response.getWriter();
            output.print(Name);
            output.close();
        }else{}
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }


}
