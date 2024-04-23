package com.enviro.assessmnet.grade001.tsolokhambule.task.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategory;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryModelAssembler;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryNotFoundException;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class WasteCategoryController {

    private final WasteCategoryRepository repo;
    private final WasteCategoryModelAssembler assembler;

    public WasteCategoryController(WasteCategoryRepository repo,
     WasteCategoryModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }
    
    @GetMapping("/wasteCategories/{id}")
    public EntityModel<WasteCategory> getOneCategory(@PathVariable Long id) {
        WasteCategory wc = repo.findById(id).orElseThrow(() -> new WasteCategoryNotFoundException(id));
        return assembler.toModel(wc);
    }

    @GetMapping("/wasteCategories")
    public CollectionModel<EntityModel<WasteCategory>> all() {

      List<EntityModel<WasteCategory>> wc = repo.findAll().stream()
          .map(assembler::toModel)
          .collect(Collectors.toList());
    
      return CollectionModel.of(wc, linkTo(methodOn(WasteCategoryController.class)
      .all()).withSelfRel());
    }
    
    @PostMapping("/wasteCategories")
     ResponseEntity<?> newWasteCategory (@RequestBody WasteCategory newCategory){
        EntityModel<WasteCategory> em = assembler.toModel(repo.save(newCategory));
        return ResponseEntity.created(em.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(em);
    }

    @PutMapping("/wasteCategories/{id}")
    ResponseEntity<?> replaceCategory(@RequestBody WasteCategory newWC, @PathVariable Long id) {
      
      WasteCategory updateWC = repo.findById(id)
      .map( wc -> {
        wc.setCategoryName(newWC.getCategoryName());
        wc.setDescription(newWC.getDescription());
        return repo.save(wc);
      })
      .orElseGet(() -> {
        newWC.setId(id);
        return repo.save(newWC);
    });

      EntityModel<WasteCategory> entityModel = assembler.toModel(updateWC);
      return ResponseEntity
      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
      .body(entityModel);
    }

    @DeleteMapping("/wasteCategories/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        repo.deleteById(id);;
        return ResponseEntity.noContent().build();
    }
    

}
