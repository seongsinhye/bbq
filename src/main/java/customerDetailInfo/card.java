package main.java.customerDetailInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/bbq/card")
public class card extends HttpServlet {

    public static Map<String, customerDetailInfo.CardInfo> UserCardList = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("card");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String nthName = (String)session.getAttribute("nthName");
        
        try {
        	if(!session.getAttribute("card1").equals("card1")) {
            	session.setAttribute("card1", "none");
            }
        	
            
            if(!session.getAttribute("card2").equals("card2")) {
            	session.setAttribute("card2", "none");
            }
            
            if(!session.getAttribute("card3").equals("card3")) {
            	session.setAttribute("card3", "none");
            }
        }catch(NullPointerException e) {
        	
        }
        
        
        String card1 = (String)session.getAttribute("card1");
        String card2 = (String)session.getAttribute("card2");
        String card3 = (String)session.getAttribute("card3");
        
        customerDetailInfo.CardInfo newCardInfo = new customerDetailInfo.CardInfo(card1, card2, card3);
        UserCardList.put(nthName, newCardInfo);
        
        




    }

}
