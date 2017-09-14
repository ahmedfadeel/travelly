

package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="login")
public class login  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     
     int id;
    String name;
    String email;
    String messages;
     

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public login() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
