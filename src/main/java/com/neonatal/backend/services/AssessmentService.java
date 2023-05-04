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
     * @param assessment an Assessment json/object which is sent in a POST request
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

    /**
     * Gets the compliance totals based on unique uhid. Assessments are counted in buckets based on the unique assessments (same assessments are in the same bucket)
     * @return a list of CompliancePOJO's for each unique uhid which contain the results of the compliance calculation
     */
    public List<CompliancePOJO> getCompliance(){
        List<CompliancePOJO> calculatedCompliance = new ArrayList<>(); // stores all the compliancePOJO's
        try{
            List<String> uhids = assessmentRepository.getUniqueUhid();
            for(String uhid: uhids){ // for each unique uhid
                CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
                List<Assessment> assessments = assessmentRepository.getByUhid(uhid);

                // Index in List<AssessmentPOJO>, count>
                HashMap<String, Integer> hm = new HashMap<>();

                for(Assessment a : assessments){ // for each assessment
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
    }

}
