package com.avo.avocado.services;

import com.avo.avocado.utils.dtos.CaloricNeedsDTO;
import com.avo.avocado.utils.entites.CaloricNeedsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CaloriesService {
    public ResponseEntity<CaloricNeedsResponse> calculateCaloricNeeds(CaloricNeedsDTO caloricNeedsDTO) {
        double result = 0;
        switch (caloricNeedsDTO.getGender()){
            case MALE:
                result = 66.5 + (13.75 * caloricNeedsDTO.getWeight()) + (5.003 * caloricNeedsDTO.getHeight()) -
                        (6.75 * caloricNeedsDTO.getAge()) * caloricNeedsDTO.getLevel_of_activity().getLevelOfActivityValue();
                break;
            case FEMALE:
                result =  655.1 + (9.563 * caloricNeedsDTO.getWeight()) + (1.850 * caloricNeedsDTO.getHeight())
                        - (4.676 * caloricNeedsDTO.getAge()) * caloricNeedsDTO.getLevel_of_activity().getLevelOfActivityValue();
                break;
        }
        CaloricNeedsResponse  caloricNeedsResponse = new CaloricNeedsResponse();
        caloricNeedsResponse.setCaloric_needs(result);

        return new ResponseEntity<CaloricNeedsResponse>(caloricNeedsResponse,HttpStatus.OK);
    }
}
