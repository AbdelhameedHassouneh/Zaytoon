package com.avo.zaytoon.controllers;

import com.avo.zaytoon.repositories.UserRepository;
import com.avo.zaytoon.services.CaloriesService;
import com.avo.zaytoon.utils.dtos.CaloricNeedsDTO;
import com.avo.zaytoon.utils.entites.CaloricNeedsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CaloriesService caloriesService;

    @PostMapping("caloric_needs")
    public ResponseEntity<CaloricNeedsResponse> calculateCaloricNeeds(@RequestBody CaloricNeedsDTO caloricNeedsDTO)  {
        return  caloriesService.calculateCaloricNeeds(caloricNeedsDTO);
    }
}
