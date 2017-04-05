import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */
public class PortfolioServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    StockDAO objdao = new StockDAO();
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
	res.setContentType("text/html");
	objdao.init(getServletConfig()); //establishes a db connection
    ArrayList<StockBean> listobj = objdao.getPortfolio(); //stores the Portfolio objects in Array List
    System.out.println("in servlet"+listobj.size());
    req.setAttribute("listobj", listobj);//setting the attribute for arraylist to access in index.jsp
    RequestDispatcher view = req.getRequestDispatcher("index.jsp");
      view.forward(req, res);//forwarding the request to index page to display user portfolio
 }
}
