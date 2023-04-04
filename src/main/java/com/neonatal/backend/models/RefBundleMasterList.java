package com.neonatal.backend.models;

import java.util.List;

import com.neonatal.backend.entities.Ref_Bundle_Category;
import com.neonatal.backend.entities.Ref_Bundle_Fields;
import com.neonatal.backend.entities.Ref_Bundle_Master_Values;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefBundleMasterList {

	List<Ref_Bundle_Category> categoriesList;
	List<Ref_Bundle_Fields> fieldsList;
	List<Ref_Bundle_Master_Values> valuesList;

}
