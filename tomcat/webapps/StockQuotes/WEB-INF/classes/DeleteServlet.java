import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */
public class DeleteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParseAPI obj = new ParseAPI();
    StockDAO objdao = new StockDAO();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {   
		  response.setContentType("text/html");
		 // symbol = request.getParameter("symbol");
		  doGet(request, response);
	 }
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		res.setContentType("text/html");
		objdao.init(getServletConfig());
		PrintWriter pw = res.getWriter();
		String symbol = req.getParameter("symbolid"); //get the symbol that user wanted to remove
		objdao.deleteRecord(symbol); //Pass it to the method that deletes the record from db
		pw.println("Removed Successfully!");
	 }
}
