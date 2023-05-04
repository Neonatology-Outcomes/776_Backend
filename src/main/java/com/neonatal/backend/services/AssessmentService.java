package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
import com.neonatal.backend.models.*;
import com.neonatal.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
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
            System.out.println("error");
            ex.printStackTrace();
        }
        return "success";
    }

    public List<CompliancePOJO> getCompliance(){
        List<CompliancePOJO> calculatedCompliance = new ArrayList<>();
        try{
            List<String> uhids = assessmentRepository.getUniqueUhid();
            System.out.println(uhids);
            for(String uhid: uhids){
                System.out.println(uhid);

                CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
//                compliance.setUhid(uhid);

                List<Assessment> assessments = assessmentRepository.getByUhid(uhid);
                System.out.println(assessments);

                // Index in List<AssessmentPOJO>, count
                HashMap<String, Integer> hm = new HashMap<>();

//                int index = 0;
                for(Assessment a : assessments){
                    String fieldName = a.getField_name();

                    if(hm.containsKey(fieldName)){
                        hm.put(fieldName, hm.get(fieldName) + 1);
                    } else {
                        hm.put(fieldName, 1);
                        compliance.getAssessments().add(new AssessmentPOJO(fieldName, a.getRecommendation_bundle_id(), a.getCriteria_bundles_id()));
                    }
                }
                for(AssessmentPOJO ap : compliance.getAssessments()){
                    ap.setOccurrences(hm.get(ap.getFieldName()));
                }
                calculatedCompliance.add(compliance);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return calculatedCompliance;
//        return List<CompliancePOJOs>
//        return "success";
    }

}
