package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

public class DisposalGuidelines {
    private Integer id;
    private  String guideline;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public DisposalGuidelines(Integer id, String guideline) {
        this.id = id;
        this.guideline = guideline;
    }
    public String getGuideline() {
        return guideline;
    }
    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

}
