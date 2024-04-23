package com.enviro.assessmnet.grade001.tsolokhambule.task.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.enviro.assessmnet.grade001.tsolokhambule.task.controller.WasteCategoryController;

@Component
public class WasteCategoryModelAssembler implements RepresentationModelAssembler<WasteCategory, EntityModel<WasteCategory>>{

    @Override
    public EntityModel<WasteCategory> toModel(WasteCategory wasteCategory) {
        return EntityModel.of(wasteCategory, //
        linkTo(methodOn(WasteCategoryController.class).getOneCategory(wasteCategory.getId())).withSelfRel(),
        linkTo(methodOn(WasteCategoryController.class).all()).withRel("wasteCategories")
        );
        
    }
    
}
