package org.emoflon.roam.build.generator.templates

import org.emoflon.roam.build.generator.GeneratorTemplate
import org.emoflon.roam.build.generator.TemplateData
import org.emoflon.roam.intermediate.RoamIntermediate.MappingConstraint
import org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticExpression
import org.emoflon.roam.intermediate.RoamIntermediate.UnaryArithmeticExpression
import org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticLiteral
import org.emoflon.roam.intermediate.RoamIntermediate.DoubleLiteral
import org.emoflon.roam.intermediate.RoamIntermediate.IntegerLiteral
import org.emoflon.roam.intermediate.RoamIntermediate.ArithmeticValue
import org.emoflon.roam.intermediate.RoamIntermediate.ValueExpression
import org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeValue
import org.emoflon.roam.intermediate.RoamIntermediate.TypeSumExpression
import org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingNode
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorMappingValue
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorMappingNodeFeatureValue
import org.emoflon.roam.intermediate.RoamIntermediate.MappingSumExpression
import org.emoflon.roam.intermediate.RoamIntermediate.ContextMappingValue
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorMappingNodeValue
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorMappingFeatureValue
import org.emoflon.roam.intermediate.RoamIntermediate.ObjectiveFunctionValue
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorTypeFeatureValue
import org.emoflon.roam.intermediate.RoamIntermediate.IteratorTypeValue
import java.util.HashMap
import org.emoflon.roam.intermediate.RoamIntermediate.SetOperation
import org.emoflon.roam.intermediate.RoamIntermediate.FeatureExpression
import org.emoflon.roam.intermediate.RoamIntermediate.StreamExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolBinaryExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolUnaryExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolLiteral
import org.emoflon.roam.intermediate.RoamIntermediate.RelationalExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolStreamExpression
import org.emoflon.roam.intermediate.RoamIntermediate.BoolValue
import org.emoflon.roam.intermediate.RoamIntermediate.StreamFilterOperation
import org.emoflon.roam.intermediate.RoamIntermediate.StreamSelectOperation
import org.emoflon.roam.intermediate.RoamIntermediate.ContextTypeFeatureValue
import org.emoflon.roam.intermediate.RoamIntermediate.BinaryArithmeticOperator
import org.eclipse.emf.ecore.EObject
import org.emoflon.roam.intermediate.RoamIntermediate.Constraint
import java.util.HashSet

abstract class ConstraintTemplate <CONTEXT extends Constraint> extends GeneratorTemplate<CONTEXT> {

	public val iterator2variableName = new HashMap<SetOperation, String>();
	public val builderMethodNames = new HashSet<String>
	public val builderMethods = new HashMap<EObject,String>
	public val builderMethodDefinitions = new HashMap<EObject,String>

	new(TemplateData data, CONTEXT context) {
		super(data, context)
	}

	
	def String generateComplexConstraint(ArithmeticExpression constExpr, ArithmeticExpression dynamicExpr);
	
	def String generateConstTermBuilder(ArithmeticExpression constExpr) {
		return '''«parseExpression(constExpr, ExpressionContext.constConstraint)»'''
	}
	
	def String generateVariableTermBuilder(ArithmeticExpression expr) {
		if(expr instanceof BinaryArithmeticExpression) {
			if(expr.operator == BinaryArithmeticOperator.ADD || expr.operator == BinaryArithmeticOperator.SUBTRACT) {
				return generateVariableTermBuilder(expr.lhs) + generateVariableTermBuilder(expr.rhs)
			} else if(expr.operator == BinaryArithmeticOperator.MULTIPLY || expr.operator == BinaryArithmeticOperator.DIVIDE) {
				return "null"
			} else {
				//CASE: Pow
				return "null"
			}
		} else if(expr instanceof UnaryArithmeticExpression) {
			generateBuilderMethod(expr)
			return '''terms.add(«builderMethods.get(expr)»(context));
			'''
		} else if(expr instanceof ArithmeticValue) {
			return generateVariableTermBuilder(expr.value)
		} else {
			throw new IllegalAccessException("Ilp term may not be constant")
		}
	}
	
	def String generateVariableTermBuilder(ValueExpression expr);
	
	def void generateBuilderMethod(UnaryArithmeticExpression expr);
	
	def void generateBuilderMethod(MappingSumExpression expr);
	
	def void generateBuilderMethod(TypeSumExpression expr);
	
	def void generateForeignBuilderMethod(MappingSumExpression expr) {
		val methodName = '''builder_«builderMethods.size»'''
		builderMethods.put(expr, methodName)
		val method = '''
	protected void «methodName»() {
		for(«data.mapping2mappingClassName.get(expr.mapping)» «getIteratorVariableName(expr)» : engine.getMapper(«expr.mapping.name»).getMappings().values().parallelStream()
			.«parseExpression(expr.filter, ExpressionContext.varStream)».collect(Collectors.toList())) {
			double constValue = «parseExpression(expr.expression, ExpressionContext.varConstraint)
			»;
			ILPTerm<Integer, Double> term = new ILPTerm<Integer, Double>(«getIteratorVariableName(expr)», constValue);
			terms.add(term);
		}
	}
		'''
		builderMethodDefinitions.put(expr, method)
	}
	
	def String parseExpression(ArithmeticExpression expr, ExpressionContext contextType) {
		if(expr instanceof BinaryArithmeticExpression) {
			switch(expr.operator) {
				case ADD: {
					return '''«parseExpression(expr.lhs, contextType)» + «parseExpression(expr.rhs, contextType)»'''
				}
				case DIVIDE: {
					return '''«parseExpression(expr.lhs, contextType)» / «parseExpression(expr.rhs, contextType)»'''
				}
				case MULTIPLY: {
					return '''«parseExpression(expr.lhs, contextType)» * «parseExpression(expr.rhs, contextType)»'''
				}
				case POW: {
					return '''Math.pow(«parseExpression(expr.lhs, contextType)», «parseExpression(expr.rhs, contextType)»'''
				}
				case SUBTRACT: {
					return '''«parseExpression(expr.lhs, contextType)» - «parseExpression(expr.rhs, contextType)»'''
				}
			}
		} else if(expr instanceof UnaryArithmeticExpression) {
			switch(expr.operator) {
				case ABSOLUTE: {
					return '''Math.abs(«parseExpression(expr.expression, contextType)»)'''
				}
				case BRACKET: {
					return '''(«parseExpression(expr.expression, contextType)»)'''
				}
				case COSINE: {
					return '''Math.cos(«parseExpression(expr.expression, contextType)»)'''
				}
				case NEGATE: {
					return '''-«parseExpression(expr.expression, contextType)»'''
				}
				case SINE: {
					return '''Math.sin(«parseExpression(expr.expression, contextType)»)'''
				}
				case SQRT: {
					return '''Math.sqrt(«parseExpression(expr.expression, contextType)»)'''
				}
			}
		} else if(expr instanceof ArithmeticLiteral) {
			if(expr instanceof DoubleLiteral) {
				return String.valueOf(expr.literal)
			} else {
				return String.valueOf((expr as IntegerLiteral).literal)
			}
		} else {
			val value = expr as ArithmeticValue
			switch(contextType) {
				case constConstraint: {
					return parseExpression(value.value, ExpressionContext.constConstraint);
				}
				case constStream: {
					return parseExpression(value.value, ExpressionContext.constStream);
				}
				case varConstraint: {
					return parseExpression(value.value, ExpressionContext.varConstraint);
				}
				case varStream: {
					return parseExpression(value.value,  ExpressionContext.varStream);
				}
			}
		}
		
	}
	
	def String parseExpression(BoolExpression expr, ExpressionContext contextType) {
		if(expr instanceof BoolBinaryExpression) {
			switch(expr.operator) {
				case AND: {
					return '''«parseExpression(expr.lhs, contextType)» && «parseExpression(expr.rhs, contextType)»'''
				}
				case OR: {
					return '''«parseExpression(expr.lhs, contextType)» || «parseExpression(expr.rhs, contextType)»'''			
				}
			}
		} else if(expr instanceof BoolUnaryExpression) {
			switch(expr.operator) {
				case NOT: {
					return '''!«parseExpression(expr.expression, contextType)»'''
				}
			}
		} else if(expr instanceof BoolLiteral) {
			return '''«(expr.literal)?"true":"false"»''';
		} else if(expr instanceof RelationalExpression) {
			return parseRelationalExpression(expr, contextType)
		} else if(expr instanceof BoolStreamExpression) {
			switch(expr.operator) {
				case EXISTS: {
					return '''«parseExpression(expr.stream, contextType)».isPresent()'''
				}
				case NOTEXISTS: {
					return '''!«parseExpression(expr.stream, contextType)».isPresent()'''
				}
			}
		} else {
			val value = expr as BoolValue;
			switch(contextType) {
				case constConstraint: {
					return parseExpression(value.getValue(), ExpressionContext.constStream);
				}
				case constStream: {
					return parseExpression(value.getValue(), ExpressionContext.constStream);
				}
				case varConstraint: {
					return parseExpression(value.getValue(), ExpressionContext.varStream);
				}
				case varStream: {
					return parseExpression(value.getValue(), ExpressionContext.varStream);
				}
			}
		}
	}
	
	def String parseRelationalExpression(RelationalExpression expr, ExpressionContext contextType) {
		switch(expr.operator) {
			case EQUAL: {
				return '''«parseExpression(expr.lhs, contextType)» == «parseExpression(expr.rhs, contextType)»'''
			}
			case GREATER: {
				return '''«parseExpression(expr.lhs, contextType)» > «parseExpression(expr.rhs, contextType)»'''
			}
			case GREATER_OR_EQUAL: {
				return '''«parseExpression(expr.lhs, contextType)» >= «parseExpression(expr.rhs, contextType)»'''
			}
			case LESS: {
				return '''«parseExpression(expr.lhs, contextType)» < «parseExpression(expr.rhs, contextType)»'''
			}
			case LESS_OR_EQUAL: {
				return '''«parseExpression(expr.lhs, contextType)» <= «parseExpression(expr.rhs, contextType)»'''
			}
			case NOT_EQUAL: {
				return '''«parseExpression(expr.lhs, contextType)» != «parseExpression(expr.rhs, contextType)»'''
			}
		}
	}
	
	def String parseExpression(StreamExpression expr, ExpressionContext contextType) {
		switch(contextType) {
			case constConstraint: {
				return parseConstExpression(expr);
			}
			case constStream: {
				return parseConstExpression(expr);
			}
			case varConstraint: {
				return parseVarExpression(expr);
			}
			case varStream: {
				return parseVarExpression(expr);
			}
		}
	}
	
	def String parseConstExpression(StreamExpression expr) {
		if(expr.current instanceof StreamFilterOperation) {
			if(expr.child === null) {
				return '''filter(«getIteratorVariableName(expr)» -> «parseExpression((expr.current as StreamFilterOperation).predicate, ExpressionContext.constStream)»)'''
			} else {
				return '''filter(«getIteratorVariableName(expr)» -> «parseExpression((expr.current as StreamFilterOperation).predicate, ExpressionContext.constStream)»)
				.«parseExpression(expr.child, ExpressionContext.constStream)»'''
			}
		} else {
			val selectOp = expr.current as StreamSelectOperation
			imports.add(data.classToPackage.getImportsForType(selectOp.type))
			if(expr.child === null) {
				return '''filter(«getIteratorVariableName(expr)» -> «getIteratorVariableName(expr)» instanceof «selectOp.type.name»)
				.map(«getIteratorVariableName(expr)» -> («selectOp.type.name») «getIteratorVariableName(expr)»)'''
			} else {
				return '''filter(«getIteratorVariableName(expr)» -> «getIteratorVariableName(expr)» instanceof «selectOp.type.name»)
				.map(«getIteratorVariableName(expr)» -> («selectOp.type.name») «getIteratorVariableName(expr)»)
				.«parseExpression(expr.child, ExpressionContext.constStream)»'''
			}
		}
	}
	
	def String parseVarExpression(StreamExpression expr) {
		if(expr.current instanceof StreamFilterOperation) {
			if(expr.child === null) {
				return '''filter(«getIteratorVariableName(expr)» -> «parseExpression((expr.current as StreamFilterOperation).predicate, ExpressionContext.varStream)»)'''
			} else {
				return '''filter(«getIteratorVariableName(expr)» -> «parseExpression((expr.current as StreamFilterOperation).predicate, ExpressionContext.varStream)»)
				.«parseExpression(expr.child, ExpressionContext.varStream)»'''
			}
		} else {
			val selectOp = expr.current as StreamSelectOperation
			imports.add(data.classToPackage.getImportsForType(selectOp.type))
			if(expr.child === null) {
				return '''filter(«getIteratorVariableName(expr)» -> «getIteratorVariableName(expr)» instanceof «selectOp.type.name»)
				.map(«getIteratorVariableName(expr)» -> («selectOp.type.name») «getIteratorVariableName(expr)»)'''
			} else {
				return '''filter(«getIteratorVariableName(expr)» -> «getIteratorVariableName(expr)» instanceof «selectOp.type.name»)
				.map(«getIteratorVariableName(expr)» -> («selectOp.type.name») «getIteratorVariableName(expr)»)
				.«parseExpression(expr.child, ExpressionContext.varStream)»'''
			}
		}
	}
	
	def String parseExpression(ValueExpression constExpr, ExpressionContext contextType) {
		switch(contextType) {
			case constConstraint: {
				return parseConstExpression(constExpr);
			}
			case constStream: {
				return parseConstStreamExpression(constExpr);
			}
			case varConstraint: {
				return parseVarExpression(constExpr)
			}
			case varStream: {
			}
		}
	}
	
	def String parseConstExpression(ValueExpression constExpr) {
		if(constExpr instanceof MappingSumExpression) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof TypeSumExpression) {
			imports.add(data.classToPackage.getPackage(constExpr.type.type.EPackage))
			return '''indexer.getObjectsOfType(«constExpr.type.type.EPackage.name».eINSTANCE.get«constExpr.type.type.name»()).stream()
			.«parseExpression(constExpr.filter, ExpressionContext.constConstraint)»
			.reduce(0, (sum, «getIteratorVariableName(constExpr)») -> {
				sum + «parseExpression(constExpr.expression, ExpressionContext.constConstraint)»
			})'''
		} else if(constExpr instanceof ContextTypeFeatureValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextTypeValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ObjectiveFunctionValue) {
			throw new UnsupportedOperationException("Objective function value access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextMappingValue) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof ContextMappingNode) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof IteratorMappingValue) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof IteratorMappingFeatureValue) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof IteratorMappingNodeFeatureValue) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof IteratorMappingNodeValue) {
			throw new UnsupportedOperationException("Mapping access not allowed in constant expressions.");
		} else if(constExpr instanceof IteratorTypeFeatureValue){
			return '''«getIteratorVariableName(constExpr.stream)».«parseFeatureExpression(constExpr.featureExpression)»'''
		} else {
			val itrTypVal = constExpr as IteratorTypeValue
			return '''«getIteratorVariableName(itrTypVal.stream)»'''
		}
	}
	
	def String parseConstStreamExpression(ValueExpression constExpr) {
		if(constExpr instanceof MappingSumExpression) {
			throw new UnsupportedOperationException("Nested mapping streams not allowed in mapping stream expressions.");
		} else if(constExpr instanceof TypeSumExpression) {
			imports.add(data.classToPackage.getPackage(constExpr.type.type.EPackage))
			return '''indexer.getObjectsOfType(«constExpr.type.type.EPackage.name».eINSTANCE.get«constExpr.type.type.name»()).stream()
			.«parseExpression(constExpr.filter, ExpressionContext.constStream)»
			.reduce(0, (sum, «getIteratorVariableName(constExpr)») -> {
				sum + «parseExpression(constExpr.expression, ExpressionContext.constStream)»
			})'''
		} else if(constExpr instanceof ContextTypeFeatureValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextTypeValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ObjectiveFunctionValue) {
			throw new UnsupportedOperationException("Objective function value access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextMappingValue) {
			throw new UnsupportedOperationException("Mapping context access not allowed in mapping stream expressions.");
		} else if(constExpr instanceof ContextMappingNode) {
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		} else if(constExpr instanceof IteratorMappingValue) {
			return "1"
		} else if(constExpr instanceof IteratorMappingFeatureValue) {
			return '''«getIteratorVariableName(constExpr.stream)».«parseFeatureExpression(constExpr.featureExpression)»'''
		} else if(constExpr instanceof IteratorMappingNodeFeatureValue) {
			return '''«getIteratorVariableName(constExpr.stream)».get«constExpr.node.name.toFirstUpper»().«parseFeatureExpression(constExpr.featureExpression)»'''
		} else if(constExpr instanceof IteratorMappingNodeValue) {
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		} else if(constExpr instanceof IteratorTypeFeatureValue){
			return '''«getIteratorVariableName(constExpr.stream)».«parseFeatureExpression(constExpr.featureExpression)»'''
		} else {
			//CASE: IteratorTypeValue
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		}
	}
	
	def String parseVarExpression(ValueExpression constExpr) {
		if(constExpr instanceof MappingSumExpression) {
			generateForeignBuilderMethod(constExpr);
			return '''
		«builderMethods.get(constExpr)»();
			'''
		} else if(constExpr instanceof TypeSumExpression) {
			imports.add(data.classToPackage.getPackage(constExpr.type.type.EPackage))
			return '''indexer.getObjectsOfType(«constExpr.type.type.EPackage.name».eINSTANCE.get«constExpr.type.type.name»()).stream()
			.«parseExpression(constExpr.filter, ExpressionContext.varConstraint)»
			.reduce(0, (sum, «getIteratorVariableName(constExpr)») -> {
				sum + «parseExpression(constExpr.expression, ExpressionContext.varConstraint)»
			})'''
		} else if(constExpr instanceof ContextTypeFeatureValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextTypeValue) {
			throw new UnsupportedOperationException("Type context access not allowed in mapping constraints.");
		} else if(constExpr instanceof ObjectiveFunctionValue) {
			throw new UnsupportedOperationException("Objective function value access not allowed in mapping constraints.");
		} else if(constExpr instanceof ContextMappingValue) {
			throw new UnsupportedOperationException("Mapping context access not allowed in mapping stream expressions.");
		} else if(constExpr instanceof ContextMappingNode) {
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		} else if(constExpr instanceof IteratorMappingValue) {
			return "1"
		} else if(constExpr instanceof IteratorMappingFeatureValue) {
			return '''«getIteratorVariableName(constExpr.stream)».«parseFeatureExpression(constExpr.featureExpression)»'''
		} else if(constExpr instanceof IteratorMappingNodeFeatureValue) {
			return '''«getIteratorVariableName(constExpr.stream)».get«constExpr.node.name.toFirstUpper»().«parseFeatureExpression(constExpr.featureExpression)»'''
		} else if(constExpr instanceof IteratorMappingNodeValue) {
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		} else if(constExpr instanceof IteratorTypeFeatureValue){
			return '''«getIteratorVariableName(constExpr.stream)».«parseFeatureExpression(constExpr.featureExpression)»'''
		} else {
			//CASE: IteratorTypeValue
			throw new UnsupportedOperationException("Complex objects are not allowed within arithmetic expressions.");
		}
	}
	
	def String parseFeatureExpression(FeatureExpression expr) {
		if(expr.child === null) {
			//TODO: Watch out for boolean attributes -> isXXXX() instead of getXXXX()
			return '''get«expr.current.feature.name.toFirstUpper»()'''
		} else {
			return '''get«expr.current.feature.name.toFirstUpper»().«parseFeatureExpression(expr.child)»'''
		}
	}

	def String getIteratorVariableName(SetOperation iterator) {
		var itrName = iterator2variableName.get(iterator)
		if(itrName === null) {
			itrName = ""+Character.forDigit(Character.digit('a',0)+iterator2variableName.size,0)
			iterator2variableName.put(iterator, itrName);
		}
		return itrName;
	}
	
}