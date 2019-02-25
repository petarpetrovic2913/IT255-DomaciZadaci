
package post_metoda;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author peravr
 */
public class POST_metoda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new POST_metoda();
    }
    public POST_metoda(){
        Korisnik u = new Korisnik();
        u.setPostId(101);
        u.setId(501);
        u.setName("Petar");
        u.setEmail("peravr17");
        u.setBody("izvini sto kasnim :D");
        
        


try {
    URL url = new URL("http://jsonplaceholder.typicode.com/comments/posts/1");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Accept", "application/json");
    if (conn.getResponseCode() != 200) {
    throw new RuntimeException("Greška : HTTP error: "
    +conn.getResponseCode());
}
    PrintWriter pw = new PrintWriter(conn.getOutputStream());
    pw.print(new Gson().toJson(u));
    pw.close();
    pw.flush();
    BufferedReader br = new BufferedReader(new InputStreamReader(
    (conn.getInputStream())));
    String output;
    while ((output = br.readLine()) != null) {
    System.out.println(output);
}
    conn.disconnect();
}   catch (MalformedURLException e) {
    e.printStackTrace();
}   catch (IOException e) {
    e.printStackTrace();
}
    
    }
    
}
