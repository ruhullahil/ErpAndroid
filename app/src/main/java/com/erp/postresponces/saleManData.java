package com.erp.postresponces;

public class saleManData{
    private String name;
    private String location_name;
    private int location_id;
    private int sale_count;

    public saleManData(String name, String location_name, int location_id, int sale_count) {
        this.name = name;
        this.location_name = location_name;
        this.location_id = location_id;
        this.sale_count = sale_count;
    }

    public saleManData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getSale_count() {
        return sale_count;
    }

    public void setSale_count(int sale_count) {
        this.sale_count = sale_count;
    }
}