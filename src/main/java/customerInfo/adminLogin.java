package main.java.customerInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/bbq/sign/in")
public class adminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminId = "admin01";
        String adminPw = "admin1234!";

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        System.out.println("id =" + id);
        System.out.println("pw = " + pw);


        if(adminId.equals(id) && adminPw.equals(pw)){
            HttpSession session = request.getSession();

            customerInfo.Info info = new customerInfo.Info();
            info.setId(id);
            info.setPw(pw);
            info.setName("관리자");
            session.setAttribute("loginInfo", info);

            response.setStatus(200);

        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }




    }
}
