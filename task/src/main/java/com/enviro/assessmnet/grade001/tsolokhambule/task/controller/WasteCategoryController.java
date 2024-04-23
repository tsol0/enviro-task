package com.enviro.assessmnet.grade001.tsolokhambule.task.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategory;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryModelAssembler;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryNotFoundException;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class WasteCategoryController {

    private final WasteCategoryRepository repo;
    private final WasteCategoryModelAssembler assembler;

    public WasteCategoryController(WasteCategoryRepository repo, WasteCategoryModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }
    
    @GetMapping("/wasteCategories/{id}")
    public EntityModel<WasteCategory> getOneCategory(@PathVariable Integer id) {
        WasteCategory wc = repo.findById(id).orElseThrow(() -> new WasteCategoryNotFoundException(id));
        return assembler.toModel(wc);
    }

    @GetMapping("/wasteCategories")
    public
    CollectionModel<EntityModel<WasteCategory>> all() {

      List<EntityModel<WasteCategory>> employees = repo.findAll().stream()
          .map(assembler::toModel)
          .collect(Collectors.toList());
    
      return CollectionModel.of(employees, linkTo(methodOn(WasteCategoryController.class).all()).withSelfRel());
    }

    @DeleteMapping("wasteCategories/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id){
        repo.deleteById(id);;
        return ResponseEntity.noContent().build();
    }
    
    

}
