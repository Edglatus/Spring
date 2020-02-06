package com.project.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {
	//Attributes
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotNull @Column(name="stock_quantity")
	private int stockQtty; 
	
	@Digits(integer=4,fraction=2)
	private float price;
	
	@PastOrPresent @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") @Column(name="release_date")
	private Calendar releaseDate;
	
	@Column(name="image_path")
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
