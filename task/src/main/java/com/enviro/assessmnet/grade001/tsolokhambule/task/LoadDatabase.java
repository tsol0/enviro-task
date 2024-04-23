package com.enviro.assessmnet.grade001.tsolokhambule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategory;
import com.enviro.assessmnet.grade001.tsolokhambule.task.model.WasteCategoryRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository wcRepository){
        return args -> {
            log.info(
                "Preloading" + wcRepository.save(new WasteCategory("Plastic", "Waste made from plastic"))
            );
            log.info(
                "Preloading" + wcRepository.save(new WasteCategory("Paper", "Waste made from paper"))
            );
            wcRepository.findAll().forEach(wc -> log.info("Preloaded"+ wc));
        };
    }

}
