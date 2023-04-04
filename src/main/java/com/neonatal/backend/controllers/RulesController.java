package com.neonatal.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neonatal.backend.models.ParentBundlePOJO;
import com.neonatal.backend.services.RulesService;

@RestController
public class RulesController {

	@Autowired
	RulesService analyticsService;

	public RulesController() {
		System.out.println("Analytics Controller Layer");
	}

	@RequestMapping(value = "/saveBundle/", method = RequestMethod.POST)
	public ResponseEntity<ParentBundlePOJO> saveBundle(@RequestBody ParentBundlePOJO parentBundlePOJO) {

		System.out.println("hello");
		ParentBundlePOJO returnObj = analyticsService.saveBundle(parentBundlePOJO);
		System.out.println("bye 1");
		return new ResponseEntity<ParentBundlePOJO>(returnObj, HttpStatus.OK);
	}

}
