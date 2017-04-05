import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Created By: Sowmya Yelmati Date:4/3/2017
 */
/*
 * This class is used for parsing the Yahoo YQL API which is in JSON format 
 * and get the actual details which we want to display.
 * I am wrapping the values as bean object in this method.
 */
public class ParseAPI {
	
	public StockBean findSymbolData(String MYSYM) {
		StockBean objbean = new StockBean();
        try {

            URL url = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+MYSYM+"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            File file = new File("json.txt");
            if (!file.exists()) {
				file.createNewFile();
			}
            FileReader reader = new FileReader(file);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(br.readLine());
            bw.close();
        
            try
            {
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
                JSONObject query =(JSONObject) jsonObject.get("query");
                JSONObject results = (JSONObject)query.get("results");
                JSONObject quote =(JSONObject) results.get("quote");
     
                objbean.setSymbol(MYSYM);
                objbean.setCompanyName((String)quote.get("Name"));
                objbean.setLastTradePrice((String)quote.get("LastTradePriceOnly"));
                objbean.setSharesOwned((String)quote.get("SharesOwned"));
                return objbean;
            }
            catch (FileNotFoundException ex) {

                ex.printStackTrace();

            } catch (IOException ex) {

                ex.printStackTrace();

            } catch (ParseException ex) {

                ex.printStackTrace();

            } catch (NullPointerException ex) {

                ex.printStackTrace();

            }
            conn.disconnect();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    return objbean ;
   }
}

