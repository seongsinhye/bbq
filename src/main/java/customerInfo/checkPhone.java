package customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "checkPhone", value = "/check/phone")
public class checkPhone extends HttpServlet {
    public  static List<Info> nameNphoneList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        boolean isExist = false;

        for (Info nthInfo : nameNphoneList) {
            String nthPhone = nthInfo.getPhone();

            if (phone.equals(nthPhone)) {
                isExist = true;
            } else {
                Info newInfo = new Info(name, phone);
                nameNphoneList.add(newInfo);
            }
        }

        Random random = new Random();

        int getRandom = random.nextInt(99999);

        if (isExist) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("phone", phone);

            PrintWriter output = response.getWriter();
            output.print(getRandom);
            output.close();
        }
    }
}
