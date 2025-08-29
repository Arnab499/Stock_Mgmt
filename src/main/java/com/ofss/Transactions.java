package com.ofss;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {

    @Id
    @Column(name = "TXN_ID")
    private Integer txnId;   

    @Column(name = "CUST_ID")
    private Integer custId;  

    @Column(name = "STOCK_ID")
    private Integer stockId; 

    @Column(name = "TXN_PRICE")
    private Long txnPrice; 

    @Column(name = "TXN_TYPE")
    private String txnType;  

    @Column(name = "QTY")
    private Long qty;        

    @Column(name = "TXN_DATE")
    private LocalDate txnDate; 

   
    public Transactions() {
        super();
    }

    public Transactions(Integer txnId, Integer custId, Integer stockId,
                        Long txnPrice, String txnType, Long qty, LocalDate txnDate) {
        this.txnId = txnId;
        this.custId = custId;
        this.stockId = stockId;
        this.txnPrice = txnPrice;
        this.txnType = txnType;
        this.qty = qty;
        this.txnDate = txnDate;
    }

   
    public Integer getTxnId() {
        return txnId;
    }

    public void setTxnId(Integer txnId) {
        this.txnId = txnId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Long getTxnPrice() {
        return txnPrice;
    }

    public void setTxnPrice(Long txnPrice) {
        this.txnPrice = txnPrice;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public LocalDate getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(LocalDate txnDate) {
        this.txnDate = txnDate;
    }
}

