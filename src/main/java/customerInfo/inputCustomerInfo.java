package customerInfo;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "inputCustomerInfo", value = "/input/customer/info")
public class inputCustomerInfo extends HttpServlet {
    public  static List<customerInfo.Info> customerInfoList = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String pw_check = request.getParameter("pw_check");
        String email = request.getParameter("email");
        String name = (String) session.getAttribute("name") ;
        String phone = (String) session.getAttribute("phone") ;

        response.setContentType("text/plain;charset=UTF-8");

        PrintWriter output = response.getWriter();

        int EngCntID = 0;
        int numCntID = 0;
        int othCntID = 0;

        for(int i = 0; i <= id.length() - 1; i++) {
            char nth = id.charAt(i);

            if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                EngCntID++;
            } else if ('0' <= nth && nth <= '9') {
                numCntID++;
            } else {
                othCntID++;
            }
        }

        // 올바른 아이디 형식이 아닐 시, 경고 문구 출력 후 아이디 새로 입력
        if((EngCntID == 0 || numCntID == 0) || (id.length() < 6 || 16 < id.length()) || othCntID != 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            String text = "{setError,ID_error}";

            output.print(text);
            output.close();
        } else {
            int EngCntPW = 0;
            int numCntPW = 0;
            int specialCharCntPW = 0;
            int othCntPW = 0;

            for(int i = 0; i <= pw.length() - 1; i++) {
                char nth = pw.charAt(i);

                if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                    EngCntPW++;
                } else if ('0' <= nth && nth <= '9') {
                    numCntPW++;
                } else if (nth == '~' || nth == '!' || nth == '@' || nth == '#'|| nth == '$'|| nth == '%'|| nth == '&'|| nth == '*') {
                    specialCharCntPW++;
                } else {
                    othCntPW++;
                }
            }

            // 올바른 비밀번호 형식이 아닐 시, 경고 문구 출력 후 비밀번호 새로 입력
            if((EngCntPW == 0 || numCntPW == 0) || (pw.length() < 8 || 20 < pw.length()) || specialCharCntPW == 0 || othCntPW != 0) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                String text = "{setError,PW_error}";

                output.print(text);
                output.close();
            } else {
                if (pw.equals(pw_check)) {
                    int EngCntEmail = 0;
                    int specialCharCntEmail1 = 0;
                    int specialCharCntEmail2 = 0;

                    for(int i = 0; i <= email.length() - 1; i++) {
                        char nth = email.charAt(i);

                        if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                            EngCntEmail++;
                        } else if (nth == '@') {
                            specialCharCntEmail1++;
                        } else if (nth == '.') {
                            specialCharCntEmail2++;
                        }
                    }

                    // 올바른 이메일 형식이 아닐 시, 경고 문구 출력 후 이메일 새로 입력
                    if(EngCntEmail == 0 || specialCharCntEmail1 != 1 || specialCharCntEmail2 != 1) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                        String text = "{setError,email_error}";

                        output.print(text);
                        output.close();
                    } else {
                        for (customerInfo.Info nthInfo : inputCustomerInfo.customerInfoList) {
                            String getEmail = nthInfo.getEmail();
                            String getID = nthInfo.getId();

                            if (email.equals(getEmail)) {
                                response.setStatus(HttpServletResponse.SC_CONFLICT);

                                String text = "{setError,email_conflict}";

                                output.print(text);
                                output.close();
                            } else {

                                if (id.equals(getID)) {
                                    response.setStatus(HttpServletResponse.SC_CONFLICT);

                                    String text = "{setError,ID_conflict}";

                                    output.print(text);
                                    output.close();
                                } else {
                                    customerInfo.Info newInfo = new customerInfo.Info(id, pw, email, name, phone);
                                    customerInfoList.add(newInfo);

                                    response.setContentType("application/json;charset=UTF-8");

                                    response.setStatus(HttpServletResponse.SC_OK);
                                    String json = "{\"ID\": \"" + id + "\"}";

                                    output.print(json);
                                    output.close();
                                }
                            }
                        }
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                    String text = "{setError,PW_check_error}";

                    output.print(text);
                    output.close();
                }
            }
        }
    }
}
