import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */
public class SymbolServlet extends HttpServlet {
	ParseAPI obj = new ParseAPI();
	String symbol;
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   response.setContentType("text/html");
	   PrintWriter pw = response.getWriter();
	    symbol = request.getParameter("symbol");
	    //actions performed based on user clicks 'search' or 'Add to portfolio' button
	    if(request.getParameter("search")!=null)
	    {
	    	StockBean objbean = obj.findSymbolData(symbol);
	    	pw.println("<table>");
	        // add some data in it....
	       
	            pw.println("<tr><td>" + objbean.getCompanyName() + objbean.getSymbol() + objbean.getLastTradePrice() + objbean.getSharesOwned()+"</td></tr>");
	        
	        pw.println("</table>");
	    	
	    }
	    if(request.getParameter("AddSymbol")!=null)
	    {
	    	ServletContext servletContext = getServletContext();
	    	RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/add");
	    	requestDispatcher.forward(request, response);// forwarding the req to AddServlet to add record in db
	    }
   }
}