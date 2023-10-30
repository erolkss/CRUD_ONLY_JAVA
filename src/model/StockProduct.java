package model;

import util.Counter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StockProduct implements DataBase {

    Date today = new Date();
    SimpleDateFormat sdf;
    public Integer id;
    public String productName;
    public String productType;
    public String productModel;
    public String productBrand;
    public String productCompany;
    public Date registrationDate;
    public Date changeDate;

    public StockProduct(String productName, String productType, String productModel, String productBrand, String productCompany){
        this.id = Counter.nextId();
        this.productName = productName;
        this.productType = productType;
        this.productModel = productModel;
        this.productBrand = productBrand;
        this.productCompany = productCompany;
        this.registrationDate = today;
        this.changeDate = today;

    }


    public Date getToday() {return today;}
    public void setToday(Date today) {this.today = today;}

    public SimpleDateFormat getSdf() {return sdf;}

    public void setSdf(SimpleDateFormat sdf) {this.sdf = sdf;}

    @Override
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}
    public String getProductType() {return productType;}
    public void setProductType(String productType) {this.productType = productType;}
    public String getProductModel() {return productModel;}
    public void setProductModel(String productModel) {this.productModel = productModel;}
    public String getProductBrand() {return productBrand;}
    public void setProductBrand(String productBrand) {this.productBrand = productBrand;}
    public String getProductCompany() {return productCompany;}
    public void setProductCompany(String productCompany) {this.productCompany = productCompany;}

    public Date getRegistrationDate(){
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate){
        this.registrationDate = registrationDate;
    }

    public void setChangeDate(Date changeDate){
        this.changeDate = changeDate;
    }


    @Override
    public String toString() {
        return this.id
                + " - "	+ this.productName
                + " - Type: " + this.productType
                + " - Model: " + this.productModel
                + " - Brand: " + this.productBrand
                + " - Company: " + this.productCompany
                + " - Date Registration:" + this.registrationDate
                +" - Date Changed:" +  this.changeDate;
    }


}