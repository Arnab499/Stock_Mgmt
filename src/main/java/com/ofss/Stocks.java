package com.ofss;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class Stocks {

    @Id
    @Column(name = "STOCK_ID")
    private int stockId;   

    @Column(name = "STOCK_NAME")
    private String stockName;  

    @Column(name = "STOCK_PRICE")
    private double stockPrice;  

    @Column(name = "STOCK_VOLUME")
    private long stockVolume;   

    @Column(name = "LISTING_PRICE")
    private double listingPrice;  

    @Column(name = "LISTED_DATE")
    private LocalDate listedDate; 

    @Column(name = "LISTED_EXCHANGE")
    private String listedExchange; 

    
    public Stocks() {
        super();
    }

    public Stocks(int stockId, String stockName, double stockPrice,
                  long stockVolume, double listingPrice,
                  LocalDate listedDate, String listedExchange) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.stockVolume = stockVolume;
        this.listingPrice = listingPrice;
        this.listedDate = listedDate;
        this.listedExchange = listedExchange;
    }


    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public long getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(long stockVolume) {
        this.stockVolume = stockVolume;
    }

    public double getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(double listingPrice) {
        this.listingPrice = listingPrice;
    }

    public LocalDate getListedDate() {
        return listedDate;
    }

    public void setListedDate(LocalDate listedDate) {
        this.listedDate = listedDate;
    }

    public String getListedExchange() {
        return listedExchange;
    }

    public void setListedExchange(String listedExchange) {
        this.listedExchange = listedExchange;
    }
}
