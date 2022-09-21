package customerInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signIn", value = "/sign/in")
public class signIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        
        
        session.setAttribute("card1", "none");
        session.setAttribute("card2", "none");
        session.setAttribute("card3", "none");

            try {
            	for (Info nthInfo : inputCustomerInfo.customerInfoList){
                    String nthID = nthInfo.getId();
                    String nthPW = nthInfo.getPw();
                    String nthName = nthInfo.getName();
                    
                    System.out.println(nthName);
                    if (id.equals(nthID) && pw.equals(nthPW)) {
                        response.setContentType("application/json;charset=UTF-8");

                        
                        session.setAttribute("loginInfo", id);
                        session.setAttribute("nthName", nthName);
                        
                        String json = "{\"nthName\": \"" + nthName + "\"}";
                        PrintWriter output = response.getWriter();
                        output.print(json);
                        output.close();
                    } else {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    }
                }
            }catch(NullPointerException e) {
            	System.out.println("예외발생~!!!");
            }
            
        
    }
}