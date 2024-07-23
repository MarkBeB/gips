package org.emoflon.gips.build.transformation;

import org.eclipse.emf.ecore.EObject;
import org.emoflon.gips.gipsl.gipsl.GipsConstraint;

public interface GipsTracer {
	static final String BUILDER_EXTENSON_ID = "org.emoflon.gips.build.GipsTraceExtension";

	void clearTrace(String srcModelId, String dstModelId);

	void trace(EObject srcNode, EObject dstNode);

	void map(String srcModelId, EObject srcNode, String dstModelId, EObject dstNode);
}

