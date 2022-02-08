package org.emoflon.roam.build.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.emoflon.ibex.gt.codegen.EClassifiersManager;
import org.emoflon.roam.build.RoamAPIData;
import org.emoflon.roam.build.generator.templates.ConstraintFactoryTemplate;
import org.emoflon.roam.build.generator.templates.MapperFactoryTemplate;
import org.emoflon.roam.build.generator.templates.RoamAPITemplate;
import org.emoflon.roam.intermediate.RoamIntermediate.Mapping;
import org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint;
import org.emoflon.roam.intermediate.RoamIntermediate.MappingObjective;
import org.emoflon.roam.intermediate.RoamIntermediate.RoamIntermediateModel;
import org.emoflon.roam.intermediate.RoamIntermediate.TypeConstraint;
import org.emoflon.roam.intermediate.RoamIntermediate.TypeObjective;

public class RoamCodeGenerator {

	final protected TemplateData data;
	protected List<GeneratorTemplate<?>> templates = Collections.synchronizedList(new LinkedList<>());
	
	public RoamCodeGenerator(final RoamIntermediateModel model, final RoamAPIData apiData, final EClassifiersManager classToPackage) {
		data = new TemplateData(model, apiData, classToPackage);
	}
	
	public void generate() {
		templates.add(new RoamAPITemplate(data, data.model));
		templates.add(new MapperFactoryTemplate(data, data.model));
		templates.add(new ConstraintFactoryTemplate(data, data.model));
		data.model.getVariables().parallelStream()
			.filter(mapping -> mapping instanceof Mapping)
			.map(mapping -> (Mapping) mapping)
			.forEach(mapping -> {
				//TODO: create mapping and mapper class templates, then add to list
			});
		data.model.getConstraints().parallelStream().forEach(constraint -> {
			if(constraint instanceof MappingConstraint mappingConstraint) {
				//TODO: create constraint class template, then add to list
			} else {
				TypeConstraint typeConstraint = (TypeConstraint) constraint;
				//TODO: create constraint class template, then add to list
			}
		});
		data.model.getObjectives().parallelStream().forEach(objective -> {
			if(objective instanceof MappingObjective mappingObjective) {
				//TODO: create objective class template, then add to list
			} else {
				TypeObjective typeObjective = (TypeObjective) objective;
				//TODO: create objective class template, then add to list
			}
		});
		templates.parallelStream().forEach(template -> {
			template.generate();
			try {
				template.writeToFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
