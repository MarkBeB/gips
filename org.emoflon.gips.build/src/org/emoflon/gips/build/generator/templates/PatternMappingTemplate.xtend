package org.emoflon.gips.build.generator.templates

import org.emoflon.gips.build.generator.GeneratorTemplate
import org.emoflon.gips.build.generator.TemplateData
import org.emoflon.ibex.patternmodel.IBeXPatternModel.IBeXContextPattern
import org.emoflon.ibex.patternmodel.IBeXPatternModel.IBeXContextAlternatives
import org.emoflon.gips.intermediate.GipsIntermediate.PatternMapping

class PatternMappingTemplate extends GeneratorTemplate<PatternMapping> {
	
	IBeXContextPattern pattern;
	
	new(TemplateData data, PatternMapping context) {
		super(data, context)
	}
	
	override init() {
		packageName = data.apiData.gipsMappingPkg
		className = data.mapping2mappingClassName.get(context)
		fqn = packageName + "." + className
		filePath = data.apiData.gipsMappingPkgPath + "/" + className + ".java"
		imports.add("org.emoflon.gips.core.gt.GTMapping")
		imports.add(data.apiData.rulesPkg+"."+data.mapping2patternClassName.get(context))
		imports.add(data.apiData.matchesPkg+"."+data.mapping2matchClassName.get(context))
		
		pattern = (context.pattern instanceof IBeXContextPattern) ? context.pattern as IBeXContextPattern : (context.pattern as IBeXContextAlternatives).context
		imports.addAll(data.classToPackage.getImportsForNodeTypes(pattern.signatureNodes))
	}
	
	override generate() {
		code = '''package «packageName»;
		
«FOR imp : imports»
import «imp»;
«ENDFOR»
		
public class «className» extends GTMapping<«data.mapping2matchClassName.get(context)», «data.mapping2patternClassName.get(context)»> {
	public «className»(final String ilpVariable, final «data.mapping2matchClassName.get(context)» match) {
		super(ilpVariable, match);
	}

	«FOR node : pattern.signatureNodes»
	public «node.type.name» get«node.name.toFirstUpper»() {
		return match.get«node.name.toFirstUpper»();
	}
	«ENDFOR»
}'''
	}

}