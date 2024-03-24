
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ApiLoteriaServelet", urlPatterns = {"/loteria.json"})
public class ApiLoteriaServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        int lot = 6;
        int num[];
        num = new int[lot];
        
        for(int h = 0; h < 1; h++){
           
            for(int i = 0; i < num.length; i++){
                num[i] = (int)(100*Math.random());
            }
          
            for(int j = 0; j < lot -1; j++){
                
                for(int k = j+1; k < lot; k++){
                  
                    if((num[j] == num[k]) && (num[j] == 0)){
                        k = lot;
                        j = lot;
                        h = 0;
                    }
                }
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            JSONObject obj = new JSONObject();
            obj.append("Data e Hora atual:", new Date().toString());
            for(int i = 0; i < num.length; i++){
                obj.append("Loteria", num[i]);
            }
            out.print(obj.toString());
        }
    }

   

}
