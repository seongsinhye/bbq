package main.java.updateInfo;


import main.java.customerDetailInfo.card;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/card/update")
public class cardUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update");
    	
    	response.setContentType("text/plain;charset=UTF-8");
        PrintWriter output = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String nthName = null;
        nthName = (String)session.getAttribute("nthName");
        
        
        //사용자가 입력한 값을 받아와서
        String cardCode = request.getParameter("cardCode");
        String getCard1 = card.UserCardList.get(nthName).getCard1();
        String getCard2 = card.UserCardList.get(nthName).getCard2();
        String getCard3 = card.UserCardList.get(nthName).getCard3();
        

        //시스템 내에 저장된 카드리스트트
        String[] cardlist = {"card0", "card1", "card2", "card3"};

        boolean exist=false;
        int i;
        for(i=0; i<=3; i++){
            if(cardCode.equals(cardlist[i])){
            	exist=true;
                break;
            }
        }
        System.out.println(cardCode);
        
        try {
        	if(exist){
            	if(i==1) {
            		if(getCard1.equals("none")){
            			session.setAttribute("card1", "card1");
                		output.print(cardlist[i]);
                        output.close();
            		}else {
            			output.print("full1");
                        output.close();
            		}
            	}else if(i==2) {
            		if(getCard2.equals("none")){
            			session.setAttribute("card2", "card2");
            			output.print(cardlist[i]);
                        output.close();
            		}else {
            			output.print("full2");
                        output.close();
            		}
            	}else if(i==3) {
            		if(getCard3.equals("none")){
            			session.setAttribute("card3", "card3");
            			output.print(cardlist[i]);
                        output.close();
            		}else {
            			output.print("full3");
                        output.close();
            		}
            	}else {
            		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            	}
            }else{
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }catch(NullPointerException e) {
        	
        }
        
       
    }
}
