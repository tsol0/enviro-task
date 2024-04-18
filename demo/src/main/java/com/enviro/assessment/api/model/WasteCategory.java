package com.enviro.assessment.api.model;

import java.util.ArrayList;
import java.util.List;

public class WasteCategory {

    private String name;
    private String description;
    private List<WasteSubcategory> subcategories;

    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
        this.subcategories = new ArrayList<>();
    }
    public List<WasteSubcategory> getSubcategories() {
        return subcategories;
    }
    public void addSubcategories(WasteSubcategory subcategory) {
        subcategories.add(subcategory);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
