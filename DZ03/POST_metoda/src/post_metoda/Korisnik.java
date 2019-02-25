/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_metoda;

/**
 *
 * @author peravr
 */
public class Korisnik {
    private int postId;
  public int getPostId() { return this.postId; }

  public void setPostId(int postId) { this.postId = postId; }

  private int id;

  public int getId() { return this.id; }

  public void setId(int id) { this.id = id; }

  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private String email;

  public String getEmail() { return this.email; }

  public void setEmail(String email) { this.email = email; }

  private String body;

  public String getBody() { return this.body; }

  public void setBody(String body) { this.body = body; }
}
