package com.ofss;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class Stocks {

    @Id
    @Column(name = "STOCK_ID")
    private Integer stockId;   

    @Column(name = "STOCK_NAME")
    private String stockName;  

    @Column(name = "STOCK_PRICE")
    private Long stockPrice;  

    @Column(name = "STOCK_VOLUME")
    private Long stockVolume;   

    @Column(name = "LISTING_PRICE")
    private Long listingPrice;  

    @Column(name = "LISTED_DATE")
    private LocalDate listedDate; 

    @Column(name = "LISTED_EXCHANGE")
    private String listedExchange; 

    
    public Stocks() {
        super();
    }

    public Stocks(Integer stockId, String stockName, Long stockPrice,
                  Long stockVolume, Long listingPrice,
                  LocalDate listedDate, String listedExchange) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.stockVolume = stockVolume;
        this.listingPrice = listingPrice;
        this.listedDate = listedDate;
        this.listedExchange = listedExchange;
    }


    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Long getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Long stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Long getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(Long stockVolume) {
        this.stockVolume = stockVolume;
    }

    public Long getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Long listingPrice) {
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
