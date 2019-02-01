
package com.fashioncatalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Prod_name")
    @Expose
    private String prodName;
    @SerializedName("Prod_type")
    @Expose
    private String prodType;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Detail")
    @Expose
    private String detail;
    @SerializedName("Distributor")
    @Expose
    private String distributor;
    @SerializedName("Qty")
    @Expose
    private String qty;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Img_url")
    @Expose
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
