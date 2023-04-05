package com.neonatal.backend.controllers;

import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.repositories.AssessmentRepository;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ArrayList<RuleObjectPOJO> rules(){ return rulesService.getAll(); } // Get all Rules

    @PostMapping
    public String addRule(@RequestBody ParentBundlePOJO parentBundle){ return rulesService.addRules(parentBundle);}

}
