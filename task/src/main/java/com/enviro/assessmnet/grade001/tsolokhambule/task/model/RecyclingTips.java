package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

public class RecyclingTips {
    
    private Integer id;
    private  String recyclingTip;
    
    public RecyclingTips(Integer id, String recyclingTip) {
        this.id = id;
        this.recyclingTip = recyclingTip;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRecyclingTip() {
        return recyclingTip;
    }
    public void setRecyclingTip(String recyclingTip) {
        this.recyclingTip = recyclingTip;
    } 
    
}
