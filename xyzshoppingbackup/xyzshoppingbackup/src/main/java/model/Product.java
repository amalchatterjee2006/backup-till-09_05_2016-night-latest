package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

		@Entity
		@Table(name="Product")
			public class Product 
				{
 
					@Id
					@Column(name="id")
					@GeneratedValue(strategy=GenerationType.IDENTITY)
						private int id;
     
						private String productname;
    
						private int productprice;
    
						private String available;
     
						
							
							public int getId() {
							return id;
						}



						public void setId(int id) {
							this.id = id;
						}



						public String getProductname() {
							return productname;
						}



						public void setProductname(String productname) {
							this.productname = productname;
						}



						public int getProductprice() {
							return productprice;
						}



						public void setProductprice(int productprice) {
							this.productprice = productprice;
						}



						public String getAvailable() {
							return available;
						}



						public void setAvailable(String available) {
							this.available = available;
						}



							public Product()
							{
								
							}

	
 
 /*   public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
     
    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country;
    }*/
    
    
}

