import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */

public class StockDAO {
	Connection conn;
	PreparedStatement st;
	Statement stmt;
	ResultSet rs;
	ParseAPI obj = new ParseAPI();
	
	public void init (ServletConfig config) throws ServletException {
		try {
			/*
			 * Initializing the db connection
			 */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","scott","tiger");
	                                   
			System.out.println("DB Connected...");
		} catch(Exception e)
		{
			System.out.println("Error in Connection..");
		}
   }
	public void addSymbol(String symbol)
	{
		/*
		 * Method used to insert a record in db whenever user clicks on "add to portfolio"
		 */
		System.out.println("inserting"+symbol);
		try {
			String query = "INSERT INTO stocksymbols ("
				    + " symbol ) VALUES ("
				    + "?)";
				    // set all the preparedstatement parameters
				    PreparedStatement st = conn.prepareStatement(query);
				    st.setString(1, symbol);
				    // execute the preparedstatement insert
				    st.executeUpdate();
				    //conn.commit();
				    //st.close();
			        //conn.close();
		} catch(Exception e)
		{
			System.out.println("Error.." + e);
		}
	}
	public ArrayList<StockBean> getPortfolio()
	{
		/*
		 * Method that actually gets the user portfolio
		 */
		ArrayList<StockBean> list1 = new ArrayList<StockBean>();
		//String result = null;
		System.out.println("getting profile");
		
		try {
			st = conn.prepareStatement("select * from stocksymbols");
			rs = st.executeQuery();
			while(rs.next())
			{ 
				list1.add(obj.findSymbolData(rs.getString("symbol")));
			}
		} catch(Exception e)
		{
			System.out.println("Error.." + e);
		}
		return list1;
	}
	public void deleteRecord(String symbol)
	{
		/*
		 * Method used to delete record from db when user click on 'remove' button
		 */
		System.out.println("Preparing to delete"+symbol);
		try {
			String query = "DELETE from stocksymbols where symbol=?";
				    // set all the preparedstatement parameters
				    st = conn.prepareStatement(query);
				    st.setString(1, symbol);
				    // execute the preparedstatement insert
				    st.executeUpdate();
				    //conn.commit();
				    //st.close();
			        //conn.close();
		} catch(Exception e)
		{
			System.out.println("Error in deleteing.." + e);
		}
		
	}
}