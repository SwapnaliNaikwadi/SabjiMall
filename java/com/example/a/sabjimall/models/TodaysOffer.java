package com.example.a.sabjimall.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodaysOffer {

@SerializedName("StatusCode")
@Expose
private Object statusCode;
@SerializedName("StatusMessage")
@Expose
private Object statusMessage;
@SerializedName("CategoryId")
@Expose
private Integer categoryId;
@SerializedName("OrderNumber")
@Expose
private Object orderNumber;
@SerializedName("ProductCode")
@Expose
private String productCode;
@SerializedName("ProductCount")
@Expose
private Integer productCount;
@SerializedName("ProductImage")
@Expose
private String productImage;
@SerializedName("ProductMRP")
@Expose
private Integer productMRP;
@SerializedName("ProductName")
@Expose
private String productName;
@SerializedName("ProductPrice")
@Expose
private Integer productPrice;
@SerializedName("ProductQuantity")
@Expose
private String productQuantity;

public Object getStatusCode() {
return statusCode;
}

public void setStatusCode(Object statusCode) {
this.statusCode = statusCode;
}

public Object getStatusMessage() {
return statusMessage;
}

public void setStatusMessage(Object statusMessage) {
this.statusMessage = statusMessage;
}

public Integer getCategoryId() {
return categoryId;
}

public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

public Object getOrderNumber() {
return orderNumber;
}

public void setOrderNumber(Object orderNumber) {
this.orderNumber = orderNumber;
}

public String getProductCode() {
return productCode;
}

public void setProductCode(String productCode) {
this.productCode = productCode;
}

public Integer getProductCount() {
return productCount;
}

public void setProductCount(Integer productCount) {
this.productCount = productCount;
}

public String getProductImage() {
return productImage;
}

public void setProductImage(String productImage) {
this.productImage = productImage;
}

public Integer getProductMRP() {
return productMRP;
}

public void setProductMRP(Integer productMRP) {
this.productMRP = productMRP;
}

public String getProductName() {
return productName;
}

public void setProductName(String productName) {
this.productName = productName;
}

public Integer getProductPrice() {
return productPrice;
}

public void setProductPrice(Integer productPrice) {
this.productPrice = productPrice;
}

public String getProductQuantity() {
return productQuantity;
}

public void setProductQuantity(String productQuantity) {
this.productQuantity = productQuantity;
}

}
