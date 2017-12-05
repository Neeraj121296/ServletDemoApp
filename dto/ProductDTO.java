package com.srivastava.onlineapp.dto;

public class ProductDTO {
private int id;
private String name;
private String desc;
private String image;
private int price;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
