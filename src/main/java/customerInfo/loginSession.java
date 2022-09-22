package main.java.customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bbq/login/session")
public class loginSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        customerInfo.Info loginInfo = (customerInfo.Info) session.getAttribute("loginInfo");


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (loginInfo != null) {

            out.print(loginInfo);

        } else {
            response.setStatus(409);
        }

        out.close();
    }


}
