package com.ltp.workbook;

public class Record {
  private String item;
  private double revenue;
  private double cost;

  public Record(String item, double revenue, double cost) {
    this.item = item;
    this.revenue = revenue;
    this.cost = cost;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public double getRevenue() {
    return this.revenue;
  }

  public void setRevenue(double revenue) {
    this.revenue = revenue;
  }

  public double getCost() {
    return this.cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }
}
