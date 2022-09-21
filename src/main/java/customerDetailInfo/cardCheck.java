package customerDetailInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/card/check"})
public class cardCheck extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cardcheck");
		request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String nthName = (String)session.getAttribute("nthName");
        
        String card1 = (String)session.getAttribute("card1");
        String card2 = (String)session.getAttribute("card2");
        String card3 = (String)session.getAttribute("card3");
        
        
        try {
        	String isCard1="false"; String isCard2="false"; String isCard3="false";
        	if(card1.equals("card1")) {
            	isCard1="true";
            	
            }
            if(card2.equals("card2")) {
            	isCard2="true";
            	
            }
            if(card3.equals("card3")) {
            	isCard3="true";
            	
            }
            
            PrintWriter output = response.getWriter();
            output.print(isCard1 + "," + isCard2 + "," + isCard3);
            output.close();
        }catch(NullPointerException e) {
        	
        }
        
        
        
	}

}
