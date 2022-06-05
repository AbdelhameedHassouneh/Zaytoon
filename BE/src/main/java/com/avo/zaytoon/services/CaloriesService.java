package com.avo.zaytoon.services;

import com.avo.zaytoon.utils.dtos.CaloricNeedsDTO;
import com.avo.zaytoon.utils.entites.CaloricNeedsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CaloriesService {
    public ResponseEntity<CaloricNeedsResponse> calculateCaloricNeeds(CaloricNeedsDTO caloricNeedsDTO) {
        double result = 0;
        switch (caloricNeedsDTO.getGender()){
            case MALE:
                result = ((10* caloricNeedsDTO.getWeight()) + (6.25 * caloricNeedsDTO.getHeight()) - (5 * caloricNeedsDTO.getAge()) + 5) * caloricNeedsDTO.getLevel_of_activity().getLevelOfActivityValue();
                break;
            case FEMALE:
                result =  ((10 * caloricNeedsDTO.getWeight()) + (6.25 * caloricNeedsDTO.getHeight()) - (5 * caloricNeedsDTO.getAge()) -161) * caloricNeedsDTO.getLevel_of_activity().getLevelOfActivityValue();
                break;
        }
        CaloricNeedsResponse  caloricNeedsResponse = new CaloricNeedsResponse();
        caloricNeedsResponse.setCaloric_needs(result);

        return new ResponseEntity<CaloricNeedsResponse>(caloricNeedsResponse,HttpStatus.OK);
    }
}
