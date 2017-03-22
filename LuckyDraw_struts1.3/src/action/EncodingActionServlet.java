package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

public class EncodingActionServlet extends ActionServlet{
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void process(HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException ,IOException{
         
        request.setCharacterEncoding("UTF-8");
        super.process(request, response);  
    }
}
