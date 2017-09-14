

package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table (name="cars")

@XmlRootElement
public class Cars implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)        
    int id;
    
    
    String owner_name;
    String type;
    String campany_name; 
    String take_car;
    String retretive_car;
    Double price_perday;
    String commit;
    int car_number;  
   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
      organization_acount org_Account;
   
    
   

   
   
    public void setorganization_acount(organization_acount org_Account) {
        this.org_Account = org_Account;
    }
     public organization_acount getorganization_acount() {
        return org_Account;
    }
  
    
     public Cars() {
    }
    public int getId() {
        return id;
    }

    public Double getPrice_perday() {
        return price_perday;
    }

    public void setPrice_perday(Double price_perday) {
        this.price_perday = price_perday;
    }

    public int getCar_number() {
        return car_number;
    }

    public void setCar_number(int car_number) {
        this.car_number = car_number;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCampany_name() {
        return campany_name;
    }

    public void setCampany_name(String campany_name) {
        this.campany_name = campany_name;
    }

    public String getTake_car() {
        return take_car;
    }

    public void setTake_car(String take_car) {
        this.take_car = take_car;
    }

    public String getRetretive_car() {
        return retretive_car;
    }

    public void setRetretive_car(String retretive_car) {
        this.retretive_car = retretive_car;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

   
    
}
