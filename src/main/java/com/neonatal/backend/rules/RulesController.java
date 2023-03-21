package com.neonatal.backend.rules;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Rule> rules(){ return rulesService.getAll(); } // Get all Rules

    @PostMapping
    public Rule addRule(@RequestBody Rule rule){ return rulesService.add(rule); } // Input new rule to the database

}
