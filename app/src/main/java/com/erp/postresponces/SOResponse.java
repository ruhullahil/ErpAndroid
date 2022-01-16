package com.erp.postresponces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SOResponse {
    @SerializedName("partner_id")
    @Expose
    private List<String> partner_id;
    @SerializedName("department_id")
    @Expose
    private List<String> department_id;
    @SerializedName("order_line")
    @Expose
    private List<Integer> order_line;
    @SerializedName("picking_ids")
    @Expose
    private List<Integer> picking_ids;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
}
