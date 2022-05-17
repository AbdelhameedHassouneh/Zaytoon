package com.avo.avocado.controllers;

import com.avo.avocado.repositories.UserRepository;
import com.avo.avocado.services.CaloriesService;
import com.avo.avocado.utils.dtos.CaloricNeedsDTO;
import com.avo.avocado.utils.entites.CaloricNeedsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CaloriesService caloriesService;

    @GetMapping("caloric_needs")
    public ResponseEntity<CaloricNeedsResponse> calculateCaloricNeeds(@RequestBody CaloricNeedsDTO caloricNeedsDTO)  {
        return  caloriesService.calculateCaloricNeeds(caloricNeedsDTO);
    }
}
