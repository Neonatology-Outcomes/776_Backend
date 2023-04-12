package com.neonatal.backend.controllers;

import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.models.RuleObjectPOJO;
import com.neonatal.backend.services.JwtUtils;
import com.neonatal.backend.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Class that defines what GET, POST calls related to the Rules and Actions tables
 */

@RestController
public class RulesController {

    @Autowired
    private RulesService rulesService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * Gets all bundle information and returns them as a JSON array of rows with values
     * for: Rule Name, Condition, Action
     * @return an ArrayList of RUleOBjectPOJO that represents the JSON.
     */
    @RequestMapping("/getBundle")
    @GetMapping
    public ArrayList<RuleObjectPOJO> getBundle(){ return rulesService.getAll(); } // Get all Rules


    /**
     * Saves the bundle passed as a JSON to the /saveBundle address into the database
     * @param parentBundle ParentBundlePOJO object representing the JSON that is passed
     * @return A string "success" if successful // TODO: Change this?
     */
    @RequestMapping(value= "/saveBundle/" , method= RequestMethod.POST)
    @PostMapping
    public String saveBundle(@RequestBody ParentBundlePOJO parentBundle){ return rulesService.addRules(parentBundle);}

    @RequestMapping("/getJWT")
    @GetMapping
    public String getJWT() {
        System.out.println("JWT generated.");
        return jwtUtils.encodeJwt("brandt"); }

    @RequestMapping("/checkJWT")
    @GetMapping
    public boolean checkJWT(@RequestHeader("Authorization") String authorization) {
        return jwtUtils.checkAuthorization(authorization);
    }

}
