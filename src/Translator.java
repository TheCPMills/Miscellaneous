
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;

public class Translator
{   /** Language Codes:
      * English - en
      * Spanish - es
      * Latin - la
      * Greek - el
      * All other can be found based on their ISO 639-1 code (https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes)
      */
    public static void main(String s) throws Exception 
    {    Translator http = new Translator();
         String word = http.callUrlAndParseResult("en", "es", s);
         System.out.println(word);
    }
 
    private String callUrlAndParseResult(String langFrom, String langTo, String word) throws Exception 
    {   String url = "https://translate.googleapis.com/translate_a/single?"+
        "client=gtx&"+
        "sl=" + langFrom + 
        "&tl=" + langTo + 
        "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
        {   response.append(inputLine);
        }
        in.close();
        return parseResult(response.toString());
    }
 
    private String parseResult(String inputJson) throws Exception
    {   JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);
        return jsonArray3.get(0).toString();
    }

    public static void main(String[] args) {
        try {
            main("Why do you have to be so mean to me?");
        } catch(Exception ex) {

        }
    }
}