

package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="offer")
public class offer implements Serializable{
    @Id
     int id;
    String type;
    String detail;
   
   
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORGANIZATION_ID")
        organization_acount org_Account;
     public organization_acount getorganization_acount() {
        return org_Account;
    }

    public void setorganization_acount(organization_acount org_Account) {
        this.org_Account = org_Account;
    }
    public String getType() {
        return type;
    }

    public offer() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    int price;
    
    
}
