package com.neonatal.backend.services;

import com.neonatal.backend.entities.Rule;
import com.neonatal.backend.repositories.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that defines service operations for rules Design.  This is the class that connects the rules controller to
 * the rules data within the neonatal database's rules table.  The rules controller calls a method within this class,
 * which then queries rules table within the database, runs logic on the retrived data (if needed) then returns the
 * information back to the controller.
 */
@Service
public class RulesService {

    @Autowired
    private RulesRepository rulesRepository;

    /* Example of a get by id call
    public Rule findById(Long id){
        Optional<Rule> rules = rulesRepository.findById(id);
        if (rules.isPresent()){
            return rules.get();
        }else {
            return null;
        }
    }
     */

    /**
     * Get all the rules, and return them as a list of type Rule
     * @return List of Rule objects
     */
    public List<Rule> getAll(){
        return rulesRepository.findAll();
    }

    /**
     * Add a rule to the database
     * @param rule Rule type to be added
     * @return Rule type that was added
     */
    public Rule add(Rule rule){
        return rulesRepository.save(rule);
    }

}
