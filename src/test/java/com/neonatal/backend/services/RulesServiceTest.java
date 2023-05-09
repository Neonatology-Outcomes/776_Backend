package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.models.SubBundlePOJO;
import com.neonatal.backend.repositories.*;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RulesServiceTest {

    @Mock
    public SubBundle_Repository mocksubBundleRepository = Mockito.mock(SubBundle_Repository.class);
    @Mock
    public CriteriaBundlesRepository mockcriteriaBundlesRepository = Mockito.mock(CriteriaBundlesRepository.class);
    @Mock
    public RecommendationBundleRepository mockrecommendationBundleRepository = Mockito.mock(RecommendationBundleRepository.class);
    @Mock
    public CriteriaObjectRepository mockcriteriaObjectRepository = Mockito.mock(CriteriaObjectRepository.class);
    @Mock
    public RecommendationObjectRepository mockrecommendationObjectRepository = Mockito.mock(RecommendationObjectRepository.class);
    @Mock
    public ParentBundleRepository mockparentBundleRepository = Mockito.mock(ParentBundleRepository.class);
    @Mock
    public BirthDetailsRepository mockbirthDetailsRepository = Mockito.mock(BirthDetailsRepository.class);
    public RulesService rulesServiceUAT;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllHappyPath(){
        //setup
        Sub_Bundle mocksubBundle = new Sub_Bundle();
        List<Sub_Bundle> mocksubBundleList = List.of(mocksubBundle);
        Criteria_Bundles mockcriteriaBundles = new Criteria_Bundles();
        List<Criteria_Bundles> mockCritBundleList = List.of(mockcriteriaBundles);
        Recommendation_Bundle mockRecBundle = new Recommendation_Bundle();
        List<Recommendation_Bundle> mockRecBundleList = List.of(mockRecBundle);
        Criteria_Object mockCritObject = new Criteria_Object();
        List<Criteria_Object> mockCritObjList = List.of(mockCritObject);
        Recommendation_Object mockRecObj = new Recommendation_Object();
        List<Recommendation_Object> mockRecObjList = List.of(mockRecObj);

        when(mocksubBundleRepository.findAll()).thenReturn(mocksubBundleList);
        when(mockcriteriaBundlesRepository.getBySub_bundle_id(10l)).thenReturn(mockCritBundleList);
        when(mockrecommendationBundleRepository.getBySub_bundle_id(10l)).thenReturn(mockRecBundleList);
        when(mockcriteriaObjectRepository.getByCriteria_bundles_id(10l)).thenReturn(mockCritObjList);
        when(mockrecommendationObjectRepository.getByRecommendation_object_id(10l)).thenReturn(mockRecObjList);
        //test
        ArrayList<RuleObjectPOJO> results = rulesServiceUAT.getAll();
        //assert
        RuleObjectPOJO mockRuleObjectPOJO = new RuleObjectPOJO(
                "name",
                "condition",
                "action");
        ArrayList<RuleObjectPOJO> expected = new ArrayList<>();
        expected.add(mockRuleObjectPOJO);
        assertEquals(expected, results);
    }

    @Test
    public void addRulesHappyPath(){
        //setup
        Parent_Bundle mockParentBundle = new Parent_Bundle();
        Sub_Bundle mockSubBundle = new Sub_Bundle();
        Criteria_Bundles mockCritBundle = new Criteria_Bundles();
        Recommendation_Bundle mockRecBundle = new Recommendation_Bundle();
        Criteria_Object mockCritObj = new Criteria_Object();
        List<Criteria_Object> mockCritObjList = List.of(mockCritObj);
        Recommendation_Object mockRecObj = new Recommendation_Object();
        List<Recommendation_Object> mockRecObjList = List.of(mockRecObj);
        when(mockparentBundleRepository.save(mockParentBundle)).thenReturn(mockParentBundle);
        when(mocksubBundleRepository.save(mockSubBundle)).thenReturn(mockSubBundle);
        when(mockcriteriaBundlesRepository.save(mockCritBundle)).thenReturn(mockCritBundle);
        when(mockrecommendationBundleRepository.save(mockRecBundle)).thenReturn(mockRecBundle);
        when(mockcriteriaObjectRepository.saveAll(mockCritObjList)).thenReturn(mockCritObjList);
        when(mockrecommendationObjectRepository.saveAll(mockRecObjList)).thenReturn(mockRecObjList);
        List<SubBundlePOJO> mockSubBundleList = List.of(new SubBundlePOJO());
        ParentBundlePOJO mockParentBundlePOJO = new ParentBundlePOJO(
                "",
                "",
                "",
                "",
                mockSubBundleList
        );
        //test
        String results = rulesServiceUAT.addRules(mockParentBundlePOJO);
        //assert
        String expected = "success";
        assertEquals(expected, results);
    }

    @Test
    public void mapCriteriaObjectToEntityHappyPath(){
        //setup
        Criteria_Object mockCritObj = new Criteria_Object();
        List<Criteria_Object> mockCritObjList = List.of(mockCritObj);
        //test
        //rulesServiceUAT.mapCriteriaObjectToEntity(mockCritObjList, 10l);
        /*
        this method is private within RulesService and can't be called
         */
        //assert
    }
    @Test
    public void addRecomObjectToEntityHappyPath(){
        /*
        like mapCriteriaObjectToEntity, this method is private and can't be called using RulesServiceUAT
         */
        //setup
        //test
        //assert
    }
    @Test
    public void getNurseTasksHappyPath(){
        //setup
        rulesServiceUAT = new RulesService();
        Birth_Details birthDetailsFromDB = new Birth_Details(
                1,
                "348732",
                1440,
                29,
                4,
                new Date(1683508081),
                "01:00:00",
                new Date(1683508081),
                "01:00:00");
        List<Birth_Details> babyList =  List.of(birthDetailsFromDB);
        when(mockbirthDetailsRepository.getBirthDetails()).thenReturn(babyList);

        List<Recommendation_Object> recommendations = List.of(new Recommendation_Object(
           5,
           "category",
           "field",
           "type",
           99f,
           99f,
           "unit",
           "4:29"
        ));
        when(mockrecommendationObjectRepository.getAllRecommendations()).thenReturn(recommendations);
        //test
        List<NurseTasks> results = rulesServiceUAT.getNurseTasks();
        //assert
        String taskString = "field type 99 4:29";
        NurseTasks expectedNurseTasks = new NurseTasks();
        expectedNurseTasks.setUhid(birthDetailsFromDB.getUhid());
        expectedNurseTasks.setBirth_weight(birthDetailsFromDB.getBirth_weight());
        expectedNurseTasks.setDateofbirth(birthDetailsFromDB.getDateofbirth());
        expectedNurseTasks.setTasks(List.of(taskString));
        List<NurseTasks> expected = List.of();

        assertEquals(expected, results);
    }

    @Test
    public void getNurseTasksNoBabies(){
        //setup
        rulesServiceUAT = new RulesService();
        List<Birth_Details> babyList =  List.of();
        when(mockbirthDetailsRepository.getBirthDetails()).thenReturn(babyList);

        List<Recommendation_Object> recommendations = List.of(new Recommendation_Object(
                5,
                "category",
                "field",
                "type",
                99f,
                99f,
                "unit",
                "4:29"
        ));
        when(mockrecommendationObjectRepository.getAllRecommendations()).thenReturn(recommendations);
        //test
        List<NurseTasks> results = rulesServiceUAT.getNurseTasks();
        //assert
        List<NurseTasks> emptyNurseList = List.of();
        assertEquals(emptyNurseList, results);
    }

    @Test
    public void getNurseTasksNoRecommendations(){
        //setup
        rulesServiceUAT = new RulesService();
        Birth_Details birthDetailsFromDB = new Birth_Details(
                1,
                "348732",
                1440,
                29,
                4,
                new Date(1683508081),
                "01:00:00",
                new Date(1683508081),
                "01:00:00");
        List<Birth_Details> babyList =  List.of(birthDetailsFromDB);
        when(mockbirthDetailsRepository.getBirthDetails()).thenReturn(babyList);

        List<Recommendation_Object> recommendations = List.of();
        when(mockrecommendationObjectRepository.getAllRecommendations()).thenReturn(recommendations);
        //test
        List<NurseTasks> results = rulesServiceUAT.getNurseTasks();
        //assert
        String taskString = "";
        NurseTasks expectedNurseTasks = new NurseTasks();
        expectedNurseTasks.setUhid(birthDetailsFromDB.getUhid());
        expectedNurseTasks.setBirth_weight(birthDetailsFromDB.getBirth_weight());
        expectedNurseTasks.setDateofbirth(birthDetailsFromDB.getDateofbirth());
        expectedNurseTasks.setTasks(List.of(taskString));
        List<NurseTasks> expected = List.of();

        assertEquals(expected, results);
    }

}
