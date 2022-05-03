package org.emoflon.gips.core.api;

import org.emoflon.gips.core.GipsConstraint;
import org.emoflon.gips.core.GipsEngine;
import org.emoflon.gips.intermediate.GipsIntermediate.Constraint;
import org.emoflon.ibex.gt.api.GraphTransformationAPI;

public abstract class GipsConstraintFactory<EMOFLON_API extends GraphTransformationAPI> {
	protected final GipsEngine engine;
	protected final EMOFLON_API eMoflonApi;

	public GipsConstraintFactory(final GipsEngine engine, final EMOFLON_API eMoflonApi) {
		this.engine = engine;
		this.eMoflonApi = eMoflonApi;
	}

	public abstract GipsConstraint<? extends Constraint, ? extends Object, ? extends Number> createConstraint(
			final Constraint constraint);
}