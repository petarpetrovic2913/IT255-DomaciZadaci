/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GET_metoda;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Pocetak {
 public static void main(String[] args) {
 new Pocetak();
 }
 public Pocetak() {
 try {
 URL url = new URL("http://jsonplaceholder.typicode.com/comments");
 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 conn.setRequestMethod("GET");
 conn.setRequestProperty("Accept", "application/json");
 if (conn.getResponseCode() != 200) {
 throw new RuntimeException("Pokusaj je uspeo : HTTP error : "
 + conn.getResponseCode());
 }
 BufferedReader br = new BufferedReader(new InputStreamReader(
 (conn.getInputStream())));
 String json = "";
 String output;
 while ((output = br.readLine()) != null) {
 json += output;
 }
 conn.disconnect();
 Gson gson = new Gson();

 ArrayList<RootObject> lista = gson.fromJson(json, new TypeToken<ArrayList<RootObject>>() {
 }.getType());
 for (RootObject urlone : lista) {
 System.out.println("postId  : " + urlone.getPostId());
 System.out.println("id  : " + urlone.getId());
 System.out.println("name  : " + urlone.getName());
 System.out.println("email  :" + urlone.getEmail());
 System.out.println("body  :" + urlone.getBody());
 System.out.println("\n");
 }
 } catch (MalformedURLException e) {
 } catch (IOException e) {
 }
 }
 
}
       
    
    

