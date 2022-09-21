package customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "nameNphoneSession", value = "/name/phone/session")
public class nameNphoneSession extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String phone = (String) session.getAttribute("phone");

        String json = "{\"name\": \"" + name + "\", \"phone\": \"" + phone + "\"}";

        PrintWriter output = response.getWriter();
        output.print(json);
        output.close();
    }
}