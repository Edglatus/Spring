package com.project.demo.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Product {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Valid @NotBlank
	private String name;
	
	@Valid @NotBlank
	private String description;
	
	@Valid  @NotNull
	private int stockQtty; 
	
	@Valid @Digits(integer=4,fraction=2)
	private float price;
	
	@Valid @PastOrPresent @Temporal(TemporalType.DATE)
	private Calendar releaseDate;
	
	@Valid @NotEmpty
	private String imagePath;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String n) { this.name = n; }

	public String getDescription() { return description; }
	public void setDescription(String d) { this.description = d; }

	public int getStockQtty() { return stockQtty; }
	public void setStockQtty(int sQ) { this.stockQtty = sQ; }

	public float getPrice() { return price; }
	public void setPrice(float p) { this.price = p; }

	public Calendar getReleaseDate() { return releaseDate; }
	public void setReleaseDate(Calendar rD) { this.releaseDate = rD; }

	public String getImagePath() { return imagePath; }
	public void setImagePath(String iP) { this.imagePath = iP; }
}
