package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class WasteCategory {

    private @Id @GeneratedValue Long id;
    private String categoryName;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public WasteCategory() {}
    public WasteCategory(String categoryName, String description) {
        // this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.categoryName, this.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
      return true;
    if (!(o instanceof WasteCategory))
      return false;
    WasteCategory wasteCategory = (WasteCategory) o;
    return Objects.equals(this.id, wasteCategory.id) && Objects.equals(this.categoryName, wasteCategory.categoryName)
       && Objects.equals(this.description, wasteCategory.description);
    }

    @Override
    public String toString() {
        return "WasteCategory {id=" + this.id + ", categoryName=" + this.categoryName + ", description=" + this.description + "}";
    }


    
}
