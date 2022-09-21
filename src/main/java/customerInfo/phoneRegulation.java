package customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "phoneRegulation", value = "/phone/regulation")
public class phoneRegulation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");

        int phoneCnt = 0;
        boolean isSuitable = false;

        for(int i = 0; i <= 10; i++) {
            char nth = phone.charAt(i);

            if ('0' <= nth && nth <= '9') {
                phoneCnt++;
            }
        }

        if(phoneCnt == 11 && phone.length() == 11) {
            isSuitable = true;
        }

        if (isSuitable) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
