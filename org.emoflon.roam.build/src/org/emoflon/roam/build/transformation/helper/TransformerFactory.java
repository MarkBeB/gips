package org.emoflon.roam.build.transformation.helper;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.roam.build.transformation.RoamTransformationData;
import org.emoflon.roam.intermediate.RoamIntermediate.Constraint;
import org.emoflon.roam.intermediate.RoamIntermediate.StreamExpression;
import org.emoflon.roam.intermediate.RoamIntermediate.SumExpression;

public class TransformerFactory {
	final protected RoamTransformationData data;
	
	public TransformerFactory(final RoamTransformationData data) {
		this.data = data;
	}
	
	public BooleanExpressionTransformer createBooleanTransformer(final EObject context) throws Exception{
		if(context instanceof Constraint constraint) {
			return new BooleanInConstraintTransformer(data, constraint, this);
		} else if(context instanceof StreamExpression streamExpr) {
			return new BooleanInStreamTransformer(data, streamExpr, this);
		} else {
			throw new IllegalArgumentException("Transforming boolean expressions within the given context is undefined. Context: "+context);
		}
	}
	
	public RelationalExpressionTransformer createRelationalTransformer(final EObject context) throws Exception{
		if(context instanceof Constraint constraint) {
			return new RelationalInConstraintTransformer(data, constraint, this);
		} else if(context instanceof StreamExpression streamExpr) {
			return new RelationalInStreamTransformer(data, streamExpr, this);
		} else {
			throw new IllegalArgumentException("Transforming relational expressions within the given context is undefined. Context: "+context);
		}
	}
	
	public ArithmeticExpressionTransformer createArithmeticTransformer(final EObject context) throws Exception{
		if(context instanceof Constraint constraint) {
			return new ArithmeticInConstraintTransformer(data, constraint, this);
		} else if(context instanceof StreamExpression streamExpr) {
			return new ArithmeticInStreamTransformer(data, streamExpr, this);
		} else {
			throw new IllegalArgumentException("Transforming arithmetic expressions within the given context is undefined. Context: "+context);
		}
	}
	
	public StreamExpressionTransformer createStreamTransformer(final EObject context) throws Exception {
		if(context instanceof Constraint constraint) {
			return new StreamInConstraintTransformer(data, constraint, this);
		} else if(context instanceof SumExpression sumExpr) {
			return new StreamInSumTransformer(data, sumExpr, this);
		} else {
			throw new IllegalArgumentException("Transforming arithmetic expressions within the given context is undefined. Context: "+context);
		}
	}
	
	public AttributeExpressionTransformer createAttributeTransformer(final EObject context) throws Exception {
		if(context instanceof Constraint constraint) {
			return new AttributeInConstraintTransformer(data, constraint, this);
		} else if(context instanceof StreamExpression streamExpr) {
			return new AttributeInStreamTransformer(data, streamExpr, this);
		} else {
			throw new IllegalArgumentException("Transforming arithmetic expressions within the given context is undefined. Context: "+context);
		}
	} 

}
