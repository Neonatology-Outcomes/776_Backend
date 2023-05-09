package com.neonatal.backend.services;

import com.neonatal.backend.entities.Birth_Details;
import com.neonatal.backend.entities.Recommendation_Object;
import com.neonatal.backend.models.NurseTasks;
import com.neonatal.backend.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import  java.util.Date;
import java.util.List;
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
