
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ApiCarlosServlet", urlPatterns = {"/heitor.json"})
public class ApiCarlosServlet extends HttpServlet {
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
        String[] nome = {"RA: 1290482222035", "Nome: Heitor Pedro de Godoi", "Banco de Dados", "Engenharia de Software III", "Programação Orientada a Objetos",  "Sistemas Operacionais II", "Gestão de Projetos", "Metodologia da Pesquisa Científico-Tecnológica", "Estágio Supervisionado em Análise e Desenvolvimento de Sistemas"};
        try (PrintWriter out = response.getWriter()) {
            JSONObject obj = new JSONObject();
            for(int i = 0; i < nome.length; i++){
                obj.append("Disciplina", nome[i]);
            }
            
            out.print(obj);
        }
    }

   

}
