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
    @Autowired
    private CriteriaBundlesRepository criteriaBundleRepository;
    @Autowired
    private CriteriaObjectRepository criteriaObjectRepository;
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

    public List<CompliancePOJO> getCompliance1(){
        List<CompliancePOJO> calculatedCompliance = new ArrayList<>(); // stores all the compliancePOJO's
        try{
            List<String> uhids = assessmentRepository.getUniqueUhid();
            for(String uhid: uhids){ // for each unique uhid
                calculatedCompliance.add(getComplianceByUhid(uhid));
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

    /**
     * Gets the compliance totals based on unique uhid. Assessments are counted in buckets based on the unique assessments (same assessments are in the same bucket). Uses getComplianceByUhid()
     * @return a list of CompliancePOJO's for each unique uhid which contain the results of the compliance calculation
     */
    public List<CompliancePOJO> getCompliance(){
        List<CompliancePOJO> calculatedCompliance = new ArrayList<>(); // stores all the compliancePOJO's
        try{
            List<String> uhids = assessmentRepository.getUniqueUhid();
            for(String uhid: uhids){ // for each unique uhid
                calculatedCompliance.add(getComplianceByUhid(uhid));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return calculatedCompliance;
    }

    /**
     * Gets the compliance for the input uhid. Assessments are counted in buckets based on the unique assessments (same assessments are in the same bucket)
     * @param uhid uhid for baby you want compliance of
     * @return a list of CompliancePOJO's for each unique uhid which contain the results of the compliance calculation
     */
    public CompliancePOJO getComplianceByUhid(String uhid){
        CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
        try{
            List<Assessment> assessments = assessmentRepository.getByUhid(uhid);
            compliance = compileAssessments(uhid, assessments);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return compliance;
    }

    public CompliancePOJO compileAssessments(String uhid, List<Assessment> assessments){
        CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
        try{
            HashMap<String, Integer> hm = new HashMap<>();

            for(Assessment a : assessments){ // for each assessment
                String fieldName = a.getField_name();
                System.out.println(a.getEntrytimestamp());

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return compliance;
    }

    public List<CompliancePOJO> getComplianceByDate(int year, int day){

        List<CompliancePOJO> calculatedCompliance = new ArrayList<>(); // stores all the compliancePOJO's
        try{
            List<String> uhids = assessmentRepository.getUhidByDate(year, day);
            for(String uhid: uhids){ // for each unique uhid
                CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
                List<Assessment> assessments = assessmentRepository.getByUhidDate(uhid, year, day);

                calculatedCompliance.add(compileAssessments(uhid, assessments));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return calculatedCompliance;
    }

    public List<CompliancePOJO> getComplianceByDateAndUhid(String uhid, int year, int day){
        List<CompliancePOJO> calculatedCompliance = new ArrayList<>(); // stores all the compliancePOJO's
        try{
            CompliancePOJO compliance = new CompliancePOJO(uhid, new ArrayList<AssessmentPOJO>());
            List<Assessment> assessments = assessmentRepository.getByUhidDate(uhid, year, day);
            calculatedCompliance.add(compileAssessments(uhid, assessments));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return calculatedCompliance;
    }


    /**
     * Converts the criteria to a format acceptable by SQL WHERE clause
     * @param criteria Criteria Object
     * @return string version of criteria for a SQL WHERE clause
     */
    private String criteriaToString(Criteria_Object criteria){
        StringBuilder sb = new StringBuilder("");
        String type = criteria.getType();
        if(type == null){
            sb.append("Boolean");
            return sb.toString();
        } else if(type.equalsIgnoreCase("Range")){
            sb.append(criteria.getField_name());
            sb.append(" < ");
            sb.append(criteria.getTo_value());
            sb.append(" AND ");
            sb.append(criteria.getFrom_value());
        } else {
            sb.append(criteria.getField_name());
            if(type.equalsIgnoreCase("Greater than")){
                sb.append(" > ");
            } else if(type.equalsIgnoreCase("Less than")){
                sb.append(" < ");
            } else if(type.equalsIgnoreCase("Greater than or equal")){
                sb.append(" >= ");
            } else if(type.equalsIgnoreCase("Less than or equal")){
                sb.append(" <= ");
            } else if(type.equalsIgnoreCase("Equals")){
                sb.append(" = ");
            } else if(type.equalsIgnoreCase("Not equals")){
                sb.append(" != ");
            }
            sb.append(criteria.getFrom_value());
        }
        return sb.toString();
    }


    /**
     * Gets the recommendations for 1 uhid (baby)
     * @param babyDetails the birth details of the baby
     * @return a list of CompliancePOJO's for each unique uhid which contain the results of the compliance calculation
     */
    public List<String> getRecommendation(RecoInputPOJO babyDetails){

//        given sub_bundle_id, parent_bundle_id, uhid
        List<String> output = new ArrayList<>();
        try {
            List<Long> criteriaBundleIds = criteriaBundleRepository.getBySubParent(babyDetails.getParent_bundle_id(), babyDetails.getSub_bundle_id());
//        List<Criteria_Bundles> sub = criteriaBundleRepository.getBySub_bundle_id(babyDetails.getSub_bundle_id());

            StringBuilder whereClause = new StringBuilder();
//        for each criteria bundle id:
            for (long criteriaBundleId : criteriaBundleIds) {
                List<Criteria_Object> criteriaObjects = criteriaObjectRepository.getByCriteria_bundles_id(criteriaBundleId);

                whereClause.append(criteriaToString(criteriaObjects.get(0)));
                for(int i = 1; i < criteriaObjects.size(); i++){
                    whereClause.append(" AND ");
                    whereClause.append(criteriaToString(criteriaObjects.get(i)));
                }
            }

            whereClause.append(" AND ");
            whereClause.append("uhid = " + babyDetails.getUhid());



//        get the criteria from 1 rule

//        parse into a format to compare with uhid details (SELECT * FROM birth_details WHERE gestation <= 32 AND uhid = givenUhid)
//
//                ** How to know which table to query? (take the info from the criteria and search the table headers for it, then query?)
//        if true:

//        Check if there are any assessments for this recommendation?
//
//            ** If so how should be return only the correct recommendation? based on day, overall, etc **
//        if not all the assessments have been done
//
//          compile corresponding recommendations using criteria_bundle_id
//          add recommendations to list
//   return the list of recommendations


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output;
    }

}
