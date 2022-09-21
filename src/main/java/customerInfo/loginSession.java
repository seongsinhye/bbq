package customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginSession", value = "/login/session")
public class loginSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String loginInfo = (String) session.getAttribute("loginInfo");

        if (loginInfo == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            PrintWriter ouput = response.getWriter();
            ouput.print(loginInfo);
            ouput.close();
        }
    }
}