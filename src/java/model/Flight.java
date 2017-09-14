

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

@Entity
@Table (name="Flight")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    int flight_number ;
    String arrival_time;
    String departure_time;
    int duration;
    String from_to;
    String places;
    int price;
    int num_seats;
    String bag_fees;
    
   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
     organization_acount org_Account;
     public organization_acount getorganization_acount() {
        return org_Account;
    }

  
    public void setorganization_acount(organization_acount org_Account) {
        this.org_Account = org_Account;
    }
    
    public Flight() {
    }
    
    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getArrival_time() {
             
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFrom_to() {
        return from_to;
    }

    public void setFrom_to(String from_to) {
        this.from_to = from_to;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public int getPrice() {
        return price;
    }
   
        
    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum_seats() {
        return num_seats;
    }

    public void setNum_seats(int num_seats) {
        this.num_seats = num_seats;
    }

    public String getBag_fees() {
        return bag_fees;
    }

    public void setBag_fees(String bag_fees) {
        this.bag_fees = bag_fees;
    }
    
}
