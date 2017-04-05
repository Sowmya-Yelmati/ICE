import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */
public class AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParseAPI obj = new ParseAPI();
	String symbol;
    StockDAO objdao = new StockDAO();
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {   
		  response.setContentType("text/html");
		  symbol = request.getParameter("symbol");
		  doGet(request, response);
	 }
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		System.out.println("in add servlet"+req.getParameter("symbol"));
		objdao.init(getServletConfig());
		objdao.addSymbol(req.getParameter("symbol"));//invoking a method from DAO to add a record in db
		pw.println("Successfully added to your portfolio!!");
	 }
}
