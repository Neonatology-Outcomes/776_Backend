package com.neonatal.backend.controllers;

import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.repositories.AssessmentRepository;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that defines what GET, POST, etc. calls will be connected with which service method
 */
@RequestMapping("rules")  // Sets the end point for calls related to Rules Design
@RestController
public class RulesController {

    @Autowired
    private RulesService rulesService;
    @Autowired
    private AssessmentRepository assessmentRepository;

    @GetMapping
    public List<Assessment> rules(){ return assessmentRepository.findAll(); } // Get all Rules

    @PostMapping
    public Assessment addRule(@RequestBody Assessment assessment){ return assessmentRepository.save(assessment); } // Input new rule to the database


	@RequestMapping(value = "/saveBundle/", method = RequestMethod.POST)
	public ResponseEntity<ParentBundlePOJO> saveBundle(@RequestBody ParentBundlePOJO parentBundlePOJO) {

		System.out.println("hello");
		ParentBundlePOJO returnObj = rulesService.saveBundle(parentBundlePOJO);
		System.out.println("bye 1");
		return new ResponseEntity<ParentBundlePOJO>(returnObj, HttpStatus.OK);
	}
	
}
