package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.DataTableObject;
import bean.LoginDao;
import bean.Sms;


/**
 * implementation class First
 */
@WebServlet("/First")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

        
       

        	
        	
        	response.setContentType("application/json");
        	PrintWriter out = response.getWriter();
        	LoginDao gettingValue = new LoginDao();        	
        	List<Sms> listOfSms= gettingValue.getSmsList();
        	System.out.println(listOfSms);
        	
        	
        	DataTableObject dataTableObject = new DataTableObject();
    		dataTableObject.setAaData(listOfSms);
    		
    		Gson gson = new GsonBuilder().setPrettyPrinting().create();
    		String json = gson.toJson(dataTableObject);
    		System.out.println(json);
    		out.print(json);
        	
        	
        } 	
        	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
        session.removeAttribute("Name");
        session.removeAttribute("Id");
        session.removeAttribute("Surname");
        session.removeAttribute("Phone");
        session.removeAttribute("Location");
        session.invalidate();
        response.sendRedirect("index.jsp");
	}

}
