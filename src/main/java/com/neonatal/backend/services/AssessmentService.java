package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
import com.neonatal.backend.models.*;
import com.neonatal.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    /**
     * Saves an assessment json that matches the entity structure
     *
     * @return "success"
     */
    public String saveAssessment(Assessment assessment){
        try{
            assessmentRepository.save(assessment);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }


}
