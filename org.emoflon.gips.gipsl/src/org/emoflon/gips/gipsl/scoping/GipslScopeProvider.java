/*
 * generated by Xtext 2.25.0
 */
package org.emoflon.gips.gipsl.scoping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.emoflon.gips.gipsl.gipsl.EditorGTFile;
import org.emoflon.gips.gipsl.gipsl.GipsConstraint;
import org.emoflon.gips.gipsl.gipsl.GipsContextExpr;
import org.emoflon.gips.gipsl.gipsl.GipsFeatureExpr;
import org.emoflon.gips.gipsl.gipsl.GipsFeatureLit;
import org.emoflon.gips.gipsl.gipsl.GipsFeatureNavigation;
import org.emoflon.gips.gipsl.gipsl.GipsLambdaAttributeExpression;
import org.emoflon.gips.gipsl.gipsl.GipsLambdaSelfExpression;
import org.emoflon.gips.gipsl.gipsl.GipsMapping;
import org.emoflon.gips.gipsl.gipsl.GipsMappingAttributeExpr;
import org.emoflon.gips.gipsl.gipsl.GipsMappingContext;
import org.emoflon.gips.gipsl.gipsl.GipsMappingVariable;
import org.emoflon.gips.gipsl.gipsl.GipsMappingVariableReference;
import org.emoflon.gips.gipsl.gipsl.GipsNodeAttributeExpr;
import org.emoflon.gips.gipsl.gipsl.GipsObjective;
import org.emoflon.gips.gipsl.gipsl.GipsPatternAttributeExpr;
import org.emoflon.gips.gipsl.gipsl.GipsPatternContext;
import org.emoflon.gips.gipsl.gipsl.GipsSelect;
import org.emoflon.gips.gipsl.gipsl.GipsStreamArithmetic;
import org.emoflon.gips.gipsl.gipsl.GipsStreamNavigation;
import org.emoflon.gips.gipsl.gipsl.GipsStreamSet;
import org.emoflon.gips.gipsl.gipsl.GipsTypeAttributeExpr;
import org.emoflon.gips.gipsl.gipsl.GipsTypeCast;
import org.emoflon.gips.gipsl.gipsl.GipsTypeContext;
import org.emoflon.gips.gipsl.gipsl.ImportedPattern;
import org.emoflon.gips.gipsl.gipsl.impl.EditorGTFileImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsConstraintImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsContextExprImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsMappingAttributeExprImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsMappingImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsNodeAttributeExprImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsObjectiveImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsPatternAttributeExprImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsSelectImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsStreamArithmeticImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsStreamNavigationImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsStreamSetImpl;
import org.emoflon.gips.gipsl.gipsl.impl.GipsTypeAttributeExprImpl;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.utils.GTEditorModelUtils;
import org.emoflon.ibex.gt.editor.utils.GTEditorPatternUtils;

/**
 * This class contains custom scoping description.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class GipslScopeProvider extends AbstractGipslScopeProvider {

	protected Map<Resource, Map<URI, Resource>> resourceCache = new HashMap<>();
	protected Set<EDataType> variableDataTypes = Set.of(EcorePackage.Literals.EDOUBLE, EcorePackage.Literals.EFLOAT,
			EcorePackage.Literals.EINT, EcorePackage.Literals.ELONG, EcorePackage.Literals.ESHORT,
			EcorePackage.Literals.EBYTE, EcorePackage.Literals.EBOOLEAN);

	@Override
	public IScope getScope(EObject context, EReference reference) {
		try {
			return getScopeInternal(context, reference);
		} catch (Exception e) {
			e.printStackTrace();
			return IScope.NULLSCOPE;
		}
	}

	public IScope getScopeInternal(EObject context, EReference reference) throws Exception {
		if (GipslScopeContextUtil.isPatternImportPattern(context, reference)) {
			return scopeForImportedPatternPattern((ImportedPattern) context, reference);
		} else if (GipslScopeContextUtil.isGipsMapping(context, reference)) {
			return scopeForGipsMapping((GipsMapping) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingVariableType(context, reference)) {
			return scopeForGipsMappingVariableType((GipsMappingVariable) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingVariableParameter(context, reference)) {
			return scopeForGipsMappingVariableParameter((GipsMappingVariable) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingVariableReference(context, reference)) {
			return scopeForGipsMappingVariableReference((GipsMappingVariableReference) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingContext(context, reference)) {
			return scopeForGipsMappingContext((GipsMappingContext) context, reference);
		} else if (GipslScopeContextUtil.isGipsTypeContext(context, reference)) {
			return scopeForGipsTypeContext((GipsTypeContext) context, reference);
		} else if (GipslScopeContextUtil.isGipsPatternContext(context, reference)) {
			return scopeForGipsPatternContext((GipsPatternContext) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingAttributeExprMapping(context, reference)) {
			return scopeForGipsMappingAttributeExprMapping((GipsMappingAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsPatternAttributeExprMapping(context, reference)) {
			return scopeForGipsPatternAttributeExprMapping((GipsPatternAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsTypeAttributeExprMapping(context, reference)) {
			return scopeForGipsTypeAttributeExprMapping((GipsTypeAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsMappingAttributeExprNode(context, reference)) {
			return scopeForGipsMappingAttributeExprNode((GipsMappingAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsContextExprNode(context, reference)) {
			return scopeForGipsContextExprNode((GipsContextExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsContextExprFeature(context, reference)) {
			return scopeForGipsContextExprFeature((GipsContextExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsLambdaAttributeExpressionVariable(context, reference)) {
			return scopeForGipsLambdaAttributeExpressionVariable((GipsLambdaAttributeExpression) context, reference);
		} else if (GipslScopeContextUtil.isGipsLambdaSelfExpressionVariable(context, reference)) {
			return scopeForGipsLambdaSelfExpressionVariable((GipsLambdaSelfExpression) context, reference);
		} else if (GipslScopeContextUtil.isGipsLambdaAttributeExpression(context, reference)) {
			return scopeForGipsLambdaAttributeExpression((GipsLambdaAttributeExpression) context, reference);
		} else if (GipslScopeContextUtil.isGipsSelect(context, reference)) {
			return scopeForGipsSelect((GipsSelect) context, reference);
		} else if (GipslScopeContextUtil.isGipsNodeAttributeExprNode(context, reference)) {
			return scopeForGipsNodeAttributeExprNode((GipsNodeAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsNodeAttributeExprFeature(context, reference)) {
			return scopeForGipsNodeAttributeExprFeature((GipsNodeAttributeExpr) context, reference);
		} else if (GipslScopeContextUtil.isGipsFeatureNavigationFeature(context, reference)) {
			return scopeForGipsFeatureNavigationFeature((GipsFeatureNavigation) context, reference);
		} else if (GipslScopeContextUtil.isGipsFeatureLit(context, reference)) {
			return scopeForGipsFeatureLit((GipsFeatureLit) context, reference);
		} else if (GipslScopeContextUtil.isGipsTypeCast(context, reference)) {
			return scopeForGipsTypeCast((GipsTypeCast) context, reference);
		}

		else {
			return super.getScope(context, reference);
		}
	}

	protected Resource loadResource(final Resource requester, final URI gtModelUri) {
		Map<URI, Resource> cache = resourceCache.get(requester);
		if (cache == null) {
			cache = new HashMap<>();
			resourceCache.put(requester, cache);
		}

		Resource other = cache.get(gtModelUri);
		if (other == null) {
			XtextResourceSet rs = new XtextResourceSet();
			try {
				other = rs.getResource(gtModelUri, true);
			} catch (Exception e) {
				return other;
			}
			cache.put(gtModelUri, other);

			if (other == null)
				return other;

			EcoreUtil2.resolveLazyCrossReferences(other, () -> false);
		}

		return other;
	}

	private IScope scopeForImportedPatternPattern(ImportedPattern context, EReference reference) {
		if (context == null || context.getFile() == null || context.getFile().isBlank())
			return IScope.NULLSCOPE;

		Resource resource = null;
		String currentImport = context.getFile().replace("\"", "");
		File importFile = new File(currentImport);
		if (importFile.exists() && importFile.isFile() && importFile.isAbsolute()) {
			URI gtModelUri = URI.createFileURI(currentImport);
			resource = loadResource(context.eResource(), gtModelUri);
			if (resource == null)
				return IScope.NULLSCOPE;
		} else {
			// 1. Case: package name
			if (!(currentImport.contains("/") || currentImport.contains("\\"))) {
				IProject currentProject = GipslScopeContextUtil.getCurrentProject(context.eResource());

				String currentFile = context.eResource().getURI().toString().replace("platform:/resource/", "")
						.replace(currentProject.getName(), "");
				currentFile = currentProject.getLocation().toPortableString() + currentFile;
				currentFile = currentFile.replace("/", "\\");

				IWorkspace ws = ResourcesPlugin.getWorkspace();
				for (IProject project : ws.getRoot().getProjects()) {
					try {
						if (!project.hasNature("org.emoflon.gips.gipsl.ui.gipsNature"))
							continue;
					} catch (CoreException e) {
						continue;
					}

					File projectFile = new File(project.getLocation().toPortableString());
					List<File> gtFiles = new LinkedList<>();
					GipslScopeContextUtil.gatherFilesWithEnding(gtFiles, projectFile, ".gipsl", true);

					for (File gtFile : gtFiles) {
						URI gtModelUri;
						try {
							gtModelUri = URI.createFileURI(gtFile.getCanonicalPath());
						} catch (IOException e) {
							continue;
						}

						String fileString = gtModelUri.toFileString();

						if (fileString.equals(currentFile))
							continue;

						resource = loadResource(context.eResource(), gtModelUri);
						if (resource == null)
							continue;

						EObject gtModel = resource.getContents().get(0);

						if (gtModel == null)
							continue;

						if (gtModel instanceof EditorGTFile gipsEditorFile) {
							if (gipsEditorFile.getPackage().getName().equals(context.getFile())) {
								break;
							}
						}
						resource = null;
					}

					if (resource != null)
						break;
				}
			} else { // 2. Case: relative path
				IProject currentProject = GipslScopeContextUtil.getCurrentProject(context.eResource());
				if (currentProject == null)
					return IScope.NULLSCOPE;

				String absolutePath = null;
				try {
					absolutePath = Paths.get(currentProject.getLocation().toPortableString())
							.resolve(Paths.get(currentImport)).toFile().getCanonicalPath();
				} catch (IOException e) {
					return IScope.NULLSCOPE;
				}
				URI gtModelUri = URI.createFileURI(absolutePath);
				resource = loadResource(context.eResource(), gtModelUri);
				if (resource == null)
					return IScope.NULLSCOPE;
			}
		}

		Set<String> allPatterns = new HashSet<>();
		EditorGTFile currentFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
		currentFile.getPatterns().forEach(p -> allPatterns.add(p.getName()));

		EcoreUtil2.resolveLazyCrossReferences(resource, () -> false);
		EObject gtModel = resource.getContents().get(0);
		if (gtModel instanceof org.emoflon.ibex.gt.editor.gT.EditorGTFile gtFile) {
			return Scopes.scopeFor(gtFile.getPatterns().stream().filter(p -> !allPatterns.contains(p.getName()))
					.collect(Collectors.toList()));
		} else if (gtModel instanceof EditorGTFile gipsFile) {
			return Scopes.scopeFor(gipsFile.getPatterns().stream().filter(p -> !allPatterns.contains(p.getName()))
					.collect(Collectors.toList()));
		} else {
			return IScope.NULLSCOPE;
		}

	}

	private IScope scopeForGipsPatternContext(GipsPatternContext context, EReference reference) {
		return Scopes.scopeFor(GipslScopeContextUtil.getAllEditorPatterns(context));
	}

	public IScope scopeForGipsMapping(GipsMapping context, EReference reference) {
		return Scopes.scopeFor(GipslScopeContextUtil.getAllEditorPatterns(context));
	}

	public IScope scopeForGipsMappingVariableType(GipsMappingVariable context, EReference reference) {
		return Scopes.scopeFor(variableDataTypes);
	}

	public IScope scopeForGipsMappingVariableParameter(GipsMappingVariable context, EReference reference) {
		if (context.getType() == null)
			return IScope.NULLSCOPE;

		GipsMapping mapping = GTEditorPatternUtils.getContainer(context, GipsMappingImpl.class);
		if (mapping == null)
			return IScope.NULLSCOPE;

		EditorPattern pattern = mapping.getPattern();
		if (pattern == null)
			return IScope.NULLSCOPE;

		if (pattern.getParameters() == null || pattern.getParameters().isEmpty())
			return IScope.NULLSCOPE;

		// TODO: Exclude parameters that are not exclusively used in attribute
		// assignments (i.e. parameters used in conditions for pattern matching)
		return Scopes.scopeFor(pattern.getParameters().stream()
				.filter(param -> variableDataTypes.contains(param.getType())).collect(Collectors.toList()));
	}

	public IScope scopeForGipsMappingVariableReference(GipsMappingVariableReference context, EReference reference) {
		Set<Class<?>> classes = Set.of(GipsContextExprImpl.class, GipsMappingAttributeExprImpl.class);
		EObject parent = (EObject) GipslScopeContextUtil.getContainer(context, classes);
		if (parent == null) {
			return IScope.NULLSCOPE;
		}
		if (parent instanceof GipsContextExpr contextExpr) {
			EObject contextType = null;
			GipsConstraint constraintContext = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
			if (constraintContext != null) {
				contextType = constraintContext.getContext();
			} else {
				GipsObjective objectiveContext = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
				if (objectiveContext != null) {
					contextType = objectiveContext.getContext();
				} else {
					return IScope.NULLSCOPE;
				}
			}
			if (contextType instanceof GipsMappingContext mappingContext && mappingContext.getMapping() != null
					&& mappingContext.getMapping().getVariables() != null
					&& !mappingContext.getMapping().getVariables().isEmpty()) {
				return Scopes.scopeFor(mappingContext.getMapping().getVariables());
			} else {
				return IScope.NULLSCOPE;
			}

		} else if (parent instanceof GipsMappingAttributeExpr mappingExpr) {
			if (mappingExpr.getMapping() != null && mappingExpr.getMapping().getVariables() != null
					&& !mappingExpr.getMapping().getVariables().isEmpty()) {
				return Scopes.scopeFor(mappingExpr.getMapping().getVariables());
			} else {
				return IScope.NULLSCOPE;
			}
		} else {
			return IScope.NULLSCOPE;
		}
	}

	public IScope scopeForGipsMappingContext(GipsMappingContext context, EReference reference) {
		EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
		return Scopes.scopeFor(editorFile.getMappings());
	}

	public IScope scopeForGipsTypeContext(GipsTypeContext context, EReference reference) {
		EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
		return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile));
	}

	public IScope scopeForGipsMappingAttributeExprMapping(GipsMappingAttributeExpr context, EReference reference) {
		EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
		return Scopes.scopeFor(editorFile.getMappings());
	}

	public IScope scopeForGipsMappingAttributeExprNode(GipsMappingAttributeExpr context, EReference reference) {
		return Scopes.scopeFor(context.getMapping().getPattern().getNodes());
	}

	private IScope scopeForGipsTypeAttributeExprMapping(GipsTypeAttributeExpr context, EReference reference) {
		EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
		return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile));
	}

	private IScope scopeForGipsPatternAttributeExprMapping(GipsPatternAttributeExpr context, EReference reference) {
		return Scopes.scopeFor(GipslScopeContextUtil.getAllEditorPatterns(context));
	}

	public IScope scopeForGipsContextExprNode(GipsContextExpr context, EReference reference) {
		EObject contextType = null;
		GipsConstraint parent = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
		if (parent != null) {
			contextType = parent.getContext();
		} else {
			GipsObjective parentAlt = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
			if (parentAlt != null) {
				contextType = parentAlt.getContext();
			} else {
				return IScope.NULLSCOPE;
			}
		}

		if (contextType instanceof GipsMappingContext mappingContext) {
			// Return context nodes only!
			return Scopes.scopeFor(mappingContext.getMapping().getPattern().getNodes().stream()
					.filter(node -> !node.isLocal() && node.getOperator() != EditorOperator.CREATE)
					.collect(Collectors.toList()));
		} else if (contextType instanceof GipsPatternContext patternContext) {
			// Return context nodes only!
			return Scopes.scopeFor(patternContext.getPattern().getNodes().stream()
					.filter(node -> !node.isLocal() && node.getOperator() != EditorOperator.CREATE)
					.collect(Collectors.toList()));
		} else {
			return IScope.NULLSCOPE;
		}
	}

	public IScope scopeForGipsLambdaAttributeExpressionVariable(GipsLambdaAttributeExpression context,
			EReference reference) {
		Set<Class<?>> classes = Set.of(GipsStreamSetImpl.class, GipsStreamArithmeticImpl.class);
		EObject parent = (EObject) GipslScopeContextUtil.getContainer(context, classes);
		if (parent == null) {
			return IScope.NULLSCOPE;
		}

		if (parent instanceof GipsStreamSet streamSet) {
			return Scopes.scopeFor(List.of(streamSet.getLambda()));
		} else {
			GipsStreamArithmetic streamArithmetic = (GipsStreamArithmetic) parent;
			return Scopes.scopeFor(List.of(streamArithmetic.getLambda()));
		}
	}

	private IScope scopeForGipsLambdaSelfExpressionVariable(GipsLambdaSelfExpression context, EReference reference) {
		Set<Class<?>> classes = Set.of(GipsStreamSetImpl.class, GipsStreamArithmeticImpl.class);
		EObject parent = (EObject) GipslScopeContextUtil.getContainer(context, classes);
		if (parent == null) {
			return IScope.NULLSCOPE;
		}

		if (parent instanceof GipsStreamSet streamSet) {
			return Scopes.scopeFor(List.of(streamSet.getLambda()));
		} else {
			GipsStreamArithmetic streamArithmetic = (GipsStreamArithmetic) parent;
			return Scopes.scopeFor(List.of(streamArithmetic.getLambda()));
		}
	}

	public IScope scopeForGipsLambdaAttributeExpression(GipsLambdaAttributeExpression context, EReference reference) {
		Set<Class<?>> classes = Set.of(GipsContextExprImpl.class, GipsMappingAttributeExprImpl.class,
				GipsPatternAttributeExprImpl.class, GipsTypeAttributeExprImpl.class, GipsStreamNavigationImpl.class,
				GipsStreamSetImpl.class, GipsSelectImpl.class, GipsStreamArithmeticImpl.class);
		EObject parent = (EObject) GipslScopeContextUtil.getContainer(context, classes);
		if (parent == null) {
			return IScope.NULLSCOPE;
		}

		while (parent != null) {
			if (parent instanceof GipsSelect select) {
				return Scopes.scopeFor(((EClass) select.getType()).getEAllStructuralFeatures());
			} else if (parent instanceof GipsMappingAttributeExpr mapping) {
				return Scopes.scopeFor(mapping.getMapping().getPattern().getNodes());
			} else if (parent instanceof GipsPatternAttributeExpr pattern) {
				return Scopes.scopeFor(pattern.getPattern().getNodes());
			} else if (parent instanceof GipsTypeAttributeExpr type) {
				return Scopes.scopeFor(type.getType().getEAllStructuralFeatures());
			} else if (parent instanceof GipsContextExpr contextExpr) {
				if (contextExpr.getExpr() != null) {
					if (contextExpr.getExpr() instanceof GipsNodeAttributeExpr nodeExpr) {
						GipsFeatureExpr expr = GipslScopeContextUtil.findLeafExpression(nodeExpr.getExpr());
						if (expr instanceof GipsFeatureLit lit) {
							EClass clazz = (EClass) lit.getFeature().getEType();
							return Scopes.scopeFor(clazz.getEAllStructuralFeatures());
						} else {
							return IScope.NULLSCOPE;
						}
					} else if (contextExpr.getExpr() instanceof GipsFeatureExpr featExpr) {
						GipsFeatureExpr expr = GipslScopeContextUtil.findLeafExpression(featExpr);
						if (expr instanceof GipsFeatureLit lit) {
							EClass clazz = (EClass) lit.getFeature().getEType();
							return Scopes.scopeFor(clazz.getEAllStructuralFeatures());
						} else {
							return IScope.NULLSCOPE;
						}
					} else {
						return IScope.NULLSCOPE;
					}
				} else {
					return IScope.NULLSCOPE;
				}
			} else if (parent instanceof GipsStreamNavigation nav) {
				if (nav.getLeft() instanceof GipsSelect select) {
					return Scopes.scopeFor(((EClass) select.getType()).getEAllStructuralFeatures());
				} else {
					parent = (EObject) GipslScopeContextUtil.getContainer(parent, classes);
				}
			} else {
				parent = (EObject) GipslScopeContextUtil.getContainer(parent, classes);
			}
			// TODO: Traverese nested stream expressions recursively to derive the current
			// type
		}

		// TODO: For now we'll exit this gracefully if anything unexpected occurs
		return IScope.NULLSCOPE;
	}

	public IScope scopeForGipsSelect(GipsSelect context, EReference reference) {
		Set<Class<?>> classes = Set.of(GipsContextExprImpl.class, GipsMappingAttributeExprImpl.class,
				GipsPatternAttributeExprImpl.class, GipsTypeAttributeExprImpl.class, GipsNodeAttributeExprImpl.class);
		EObject parent = (EObject) GipslScopeContextUtil.getContainer(context, classes);
		if (parent instanceof GipsMappingAttributeExpr || parent instanceof GipsPatternAttributeExpr) {
			// TODO: Find all rules that refine the rule that corresponds to this mapping
			// TODO: Deactivated for now, since we do not support rule inheritance in any
			// meaningful way
			// return Scopes.scopeFor(List.of(mapping.getMapping().getRule()));
			return IScope.NULLSCOPE;
		} else if (parent instanceof GipsTypeAttributeExpr typeExpr) {
			EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
			return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
					.filter(c -> c.getEAllSuperTypes().contains(typeExpr.getType())).collect(Collectors.toSet()));
		} else if (parent instanceof GipsContextExpr contextExpr) {
			if (contextExpr.getExpr() != null) {
				if (contextExpr.getExpr() instanceof GipsNodeAttributeExpr nodeExpr) {
					GipsFeatureExpr expr = GipslScopeContextUtil.findLeafExpression(nodeExpr.getExpr());
					if (expr instanceof GipsFeatureLit lit) {
						EClass clazz = (EClass) lit.getFeature().getEType();
						EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
						return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
								.filter(c -> c.getEAllSuperTypes().contains(clazz)).collect(Collectors.toSet()));
					} else {
						return IScope.NULLSCOPE;
					}
				} else if (contextExpr.getExpr() instanceof GipsFeatureExpr featExpr) {
					GipsFeatureExpr expr = GipslScopeContextUtil.findLeafExpression(featExpr);
					if (expr instanceof GipsFeatureLit lit) {
						EClass clazz = (EClass) lit.getFeature().getEType();
						EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
						return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
								.filter(c -> c.getEAllSuperTypes().contains(clazz)).collect(Collectors.toSet()));
					} else {
						return IScope.NULLSCOPE;
					}
				} else {
					return IScope.NULLSCOPE;
				}
			} else {
				return IScope.NULLSCOPE;
			}
		} else {
			return IScope.NULLSCOPE;
		}
	}

//	private IScope scopeForGipsContains(GipsContains context, EReference reference) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public IScope scopeForGipsContextExprFeature(GipsContextExpr context, EReference reference) {
		if (context.getTypeCast() == null) {
			EObject contextType = null;
			GipsConstraint parent = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
			if (parent != null) {
				contextType = parent.getContext();
			} else {
				GipsObjective parentAlt = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
				if (parentAlt != null) {
					contextType = parentAlt.getContext();
				} else {
					return IScope.NULLSCOPE;
				}
			}

			if (contextType instanceof GipsTypeContext typeContext && typeContext.getType() instanceof EClass type) {
				return Scopes.scopeFor(type.getEAllStructuralFeatures());
			} else {
				return IScope.NULLSCOPE;
			}
		} else {
			return Scopes.scopeFor(context.getTypeCast().getType().getEAllStructuralFeatures());
		}

	}

	public IScope scopeForGipsNodeAttributeExprFeature(GipsNodeAttributeExpr context, EReference reference) {
		if (context.getTypeCast() == null) {
			return Scopes.scopeFor(context.getNode().getType().getEAllStructuralFeatures());
		} else {
			return Scopes.scopeFor(context.getTypeCast().getType().getEAllStructuralFeatures());
		}

	}

	public IScope scopeForGipsNodeAttributeExprNode(GipsNodeAttributeExpr context, EReference reference) {
		if (context.eContainer() instanceof GipsContextExpr) {
			EObject contextType = null;
			GipsConstraint root = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
			if (root != null) {
				contextType = root.getContext();
			} else {
				GipsObjective rootAlt = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
				if (rootAlt != null) {
					contextType = rootAlt.getContext();
				} else {
					return IScope.NULLSCOPE;
				}
			}

			if (contextType instanceof GipsMappingContext mappingContext) {
				// Return context nodes only!
				return Scopes.scopeFor(mappingContext.getMapping().getPattern().getNodes().stream()
						.filter(node -> !node.isLocal() && node.getOperator() != EditorOperator.CREATE)
						.collect(Collectors.toList()));
			} else if (contextType instanceof GipsPatternContext patternContext) {
				// Return context nodes only!
				return Scopes.scopeFor(patternContext.getPattern().getNodes().stream()
						.filter(node -> !node.isLocal() && node.getOperator() != EditorOperator.CREATE)
						.collect(Collectors.toList()));
			} else {
				return IScope.NULLSCOPE;
			}
		} else if (context.eContainer() instanceof GipsLambdaAttributeExpression lambda) {
			return scopeForGipsLambdaAttributeExpression(lambda, reference);
		} else {
			GipsMappingAttributeExpr parentExpr = (GipsMappingAttributeExpr) context.eContainer();
			return Scopes.scopeFor(parentExpr.getMapping().getPattern().getNodes());
		}
	}

	public IScope scopeForGipsFeatureNavigationFeature(GipsFeatureNavigation context, EReference reference) {
		GipsFeatureLit parentFeature = (GipsFeatureLit) context.getLeft();
		if (parentFeature.getFeature().getEType() instanceof EClass parentClass) {
			if (parentFeature.getTypeCast() == null) {
				return Scopes.scopeFor(parentClass.getEAllStructuralFeatures());
			} else {
				return Scopes.scopeFor(parentFeature.getTypeCast().getType().getEAllStructuralFeatures());
			}

		} else {
			return IScope.NULLSCOPE;
		}
	}

	public IScope scopeForGipsFeatureLit(GipsFeatureLit context, EReference reference) {
		if (context.eContainer() instanceof GipsNodeAttributeExpr nodeExpr) {
			if (nodeExpr.getTypeCast() == null) {
				return Scopes.scopeFor(nodeExpr.getNode().getType().getEAllStructuralFeatures());
			} else {
				return Scopes.scopeFor(nodeExpr.getTypeCast().getType().getEAllStructuralFeatures());
			}
		} else if (context.eContainer() instanceof GipsContextExpr contextExpr) {
			if (contextExpr.getTypeCast() == null) {
				EObject contextType = null;
				GipsConstraint root = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
				if (root != null) {
					contextType = root.getContext();
				} else {
					GipsObjective rootAlt = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
					if (rootAlt != null) {
						contextType = rootAlt.getContext();
					} else {
						return IScope.NULLSCOPE;
					}
				}

				if (contextType instanceof GipsTypeContext typeContext
						&& typeContext.getType() instanceof EClass type) {
					return Scopes.scopeFor(type.getEAllStructuralFeatures());
				} else {
					return IScope.NULLSCOPE;
				}
			} else {
				return Scopes.scopeFor(contextExpr.getTypeCast().getType().getEAllStructuralFeatures());
			}
		} else if (context.eContainer() instanceof GipsLambdaAttributeExpression lambda) {
			return scopeForGipsLambdaAttributeExpression(lambda, reference);
		} else {
			GipsFeatureNavigation parent = (GipsFeatureNavigation) context.eContainer();
			GipsFeatureLit parentFeature = (GipsFeatureLit) parent.getLeft();
			if (context == parentFeature) {
				if (parent.eContainer() instanceof GipsNodeAttributeExpr parentNodeExpr) {
					if (parentNodeExpr.getTypeCast() == null) {
						return Scopes.scopeFor(parentNodeExpr.getNode().getType().getEAllStructuralFeatures());
					} else {
						return Scopes.scopeFor(parentNodeExpr.getTypeCast().getType().getEAllStructuralFeatures());
					}
				} else if (parent.eContainer() instanceof GipsContextExpr contextExpr) {
					if (contextExpr.getTypeCast() == null) {
						EObject contextType = null;
						GipsConstraint root = GTEditorPatternUtils.getContainer(context, GipsConstraintImpl.class);
						if (root != null) {
							contextType = root.getContext();
						} else {
							GipsObjective rootAlt = GTEditorPatternUtils.getContainer(context, GipsObjectiveImpl.class);
							if (rootAlt != null) {
								contextType = rootAlt.getContext();
							} else {
								return IScope.NULLSCOPE;
							}
						}

						if (contextType instanceof GipsTypeContext typeContext
								&& typeContext.getType() instanceof EClass type) {
							return Scopes.scopeFor(type.getEAllStructuralFeatures());
						} else {
							return IScope.NULLSCOPE;
						}
					} else {
						return Scopes.scopeFor(contextExpr.getTypeCast().getType().getEAllStructuralFeatures());
					}
				} else if (parent.eContainer() instanceof GipsLambdaAttributeExpression lambda) {
					return scopeForGipsLambdaAttributeExpression(lambda, reference);
				} else {
					GipsFeatureNavigation parentNavigation = (GipsFeatureNavigation) parent.eContainer();
					parentFeature = (GipsFeatureLit) parentNavigation.getLeft();
					if (parentFeature.getFeature().getEType() instanceof EClass parentClass) {
						if (parentFeature.getTypeCast() == null) {
							return Scopes.scopeFor(parentClass.getEAllStructuralFeatures());
						} else {
							return Scopes.scopeFor(parentFeature.getTypeCast().getType().getEAllStructuralFeatures());
						}

					} else {
						return IScope.NULLSCOPE;
					}
				}
			} else {
				if (parentFeature.getFeature().getEType() instanceof EClass parentClass) {
					if (parentFeature.getTypeCast() == null) {
						return Scopes.scopeFor(parentClass.getEAllStructuralFeatures());
					} else {
						return Scopes.scopeFor(parentFeature.getTypeCast().getType().getEAllStructuralFeatures());
					}
				} else {
					return IScope.NULLSCOPE;
				}
			}

		}
	}

	public IScope scopeForGipsTypeCast(GipsTypeCast context, EReference reference) {
		if (context.eContainer() instanceof GipsContextExpr contextExpr) {
			Set<Class<?>> classes = Set.of(GipsConstraintImpl.class, GipsObjectiveImpl.class);
			EObject root = (EObject) GipslScopeContextUtil.getContainer(context, classes);
			EObject contextType = null;
			if (root instanceof GipsConstraint constr) {
				contextType = constr.getContext();
			} else if (root instanceof GipsObjectiveImpl obj) {
				contextType = obj.getContext();
			} else {
				return IScope.NULLSCOPE;
			}
			if (contextType instanceof GipsTypeContext type && type.getType() instanceof EClass clazz) {
				EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
				return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
						.filter(c -> c.getEAllSuperTypes().contains(clazz)).collect(Collectors.toSet()));
			} else {
				return IScope.NULLSCOPE;
			}
		} else if (context.eContainer() instanceof GipsNodeAttributeExpr atrExpr) {
			EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
			return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
					.filter(c -> c.getEAllSuperTypes().contains(atrExpr.getNode().getType()))
					.collect(Collectors.toSet()));
		} else if (context.eContainer() instanceof GipsFeatureLit lit) {
			if (!lit.getFeature().isMany()) {
				EditorGTFile editorFile = GTEditorPatternUtils.getContainer(context, EditorGTFileImpl.class);
				return Scopes.scopeFor(GTEditorModelUtils.getClasses(editorFile).stream()
						.filter(c -> c.getEAllSuperTypes().contains(lit.getFeature().getEType()))
						.collect(Collectors.toSet()));
			} else {
				return IScope.NULLSCOPE;
			}
		} else {
			return IScope.NULLSCOPE;
		}
	}

}
