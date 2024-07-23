package org.emoflon.gips.build;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.gips.build.generator.GipsCodeGenerator;
import org.emoflon.gips.build.generator.GipsImportManager;
import org.emoflon.gips.build.transformation.GipsToIntermediate;
import org.emoflon.gips.debugger.better.DebugService;
import org.emoflon.gips.debugger.trace.TraceMap;
import org.emoflon.gips.debugger.trace.TraceModelBuilder;
import org.emoflon.gips.debugger.trace.resolver.ResolverEcore2Id;
import org.emoflon.gips.gipsl.generator.GipsBuilderExtension;
import org.emoflon.gips.gipsl.gipsl.EditorGTFile;
import org.emoflon.gips.intermediate.GipsIntermediate.GipsIntermediateModel;
import org.emoflon.ibex.patternmodel.IBeXPatternModel.IBeXModel;
import org.moflon.core.utilities.LogUtils;

public class GipsProjectBuilder implements GipsBuilderExtension {

	private static Logger logger = Logger.getLogger(GipsProjectBuilder.class);

	@Override
	public void build(IProject project, Resource resource) {
		LogUtils.info(logger, "GipsProjectBuilder: Building project <" + project.getName() + ">");
		// clean old code and create folders
		try {
			LogUtils.info(logger, "GipsProjectBuilder: cleaning old code...");
			GipsBuilderUtils.removeGeneratedCode(project, GipsBuilderUtils.GEN_FOLDER + "/**");
			GipsBuilderUtils.createFolders(project);
		} catch (CoreException e) {
			LogUtils.error(logger, e.toString());
			e.printStackTrace();
			return;
		}

		LogUtils.info(logger, "GipsProjectBuilder: transforming Gipsl models...");
		// create intermediate Gips model and ibex patterns
		EditorGTFile gipsSlangFile = (EditorGTFile) resource.getContents().get(0);
		// use transformer to create intermediate gips model out of the gipsSlang file
		GipsToIntermediate transformer = new GipsToIntermediate(gipsSlangFile);
		GipsIntermediateModel model = null;
		try {
			model = transformer.transform();
		} catch (Exception e) {
			LogUtils.error(logger, e.toString());
			e.printStackTrace();
			return;
		}
		model.setName(resource.getURI().trimFileExtension().lastSegment());
		IBeXModel ibexModel = model.getIbexModel();

		LogUtils.info(logger, "GipsProjectBuilder: building eMoflon-API...");
		GipsAPIData gipsApiData = null;
		// build emoflon API and update Manifest
		if (ibexModel != null) {
			try {
				gipsApiData = GipsBuilderUtils.buildEMoflonAPI(project, ibexModel);
				gipsApiData.project = project;
				GipsBuilderUtils.updateManifest(project, GipsBuilderUtils::processManifestForPackage);
			} catch (CoreException e) {
				LogUtils.error(logger, e.toString());
				e.printStackTrace();
				return;
			}
		}

		// save ibex-patterns and gt-rules for the hipe engine builder
		GipsBuilderUtils.saveResource(EcoreUtil.copy(ibexModel),
				gipsApiData.apiPackageFolder.getLocation() + "/ibex-patterns.xmi");
		GipsBuilderUtils.saveResource(model, gipsApiData.apiPackageFolder.getLocation() + "/gips/gips-model.xmi");
		gipsApiData.intermediateModelURI = URI.createPlatformResourceURI(
				gipsApiData.apiPackageFolder.getProjectRelativePath() + "/gips/gips-model.xmi", true);

		// build HiPE engine code
		if (ibexModel != null && !ibexModel.getPatternSet().getContextPatterns().isEmpty()) {
			IFolder packagePath = project.getFolder(project.getName().replace(".", "/"));
			GipsBuilderUtils.collectEngineBuilderExtensions()
					.forEach(ext -> ext.run(project, packagePath.getProjectRelativePath(), ibexModel));
		}
		// build Gips API
		LogUtils.info(logger, "GipsProjectBuilder: building Gips-API...");
		// set output folders
		gipsApiData.setGipsApiPackage(
				GipsBuilderUtils.getGeneratedProjectFolder(project, GipsBuilderUtils.GIPS_API_FOLDER));
		gipsApiData.setGipsMappingPackage(
				GipsBuilderUtils.getGeneratedProjectFolder(project, GipsBuilderUtils.MAPPING_FOLDER));
		gipsApiData.setGipsMapperPackage(
				GipsBuilderUtils.getGeneratedProjectFolder(project, GipsBuilderUtils.MAPPER_FOLDER));
		gipsApiData.setGipsConstraintPackage(
				GipsBuilderUtils.getGeneratedProjectFolder(project, GipsBuilderUtils.CONSTRAINT_FOLDER));
		gipsApiData.setGipsObjectivePackage(
				GipsBuilderUtils.getGeneratedProjectFolder(project, GipsBuilderUtils.OBJECTIVE_FOLDER));
		// get package dependencies
		GipsImportManager manager = GipsBuilderUtils
				.createGipsImportManager(GipsBuilderUtils.createEPackageRegistry(model));
		// generate files
		GipsCodeGenerator gipsGen = new GipsCodeGenerator(model, gipsApiData, manager);
		gipsGen.generate();
		LogUtils.info(logger, "GipsProjectBuilder: Done!");

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			LogUtils.error(logger, e.toString());
			e.printStackTrace();
		}

		tracing(project, gipsApiData, gipsSlangFile, transformer, model);
	}

	private void tracing(final IProject project, final GipsAPIData gipsApiData, final EditorGTFile gipsSlangFile,
			final GipsToIntermediate transformer, final GipsIntermediateModel model) {
		// tracing
		try {
			var contextId = project.getName(); // gipsSlangFile.eResource().getURI().trimFileExtension().toString();
			var tracer = DebugService.getInstance().getTraceMap(contextId, true);

			try {
				var runtimeTrace = project.getLocation().append("traces").append("gips2ilp-trace.xmi");
				tracer.loadTrace(URI.createFileURI(runtimeTrace.toString()));
			} catch (Exception e) {
				LogUtils.error(logger, e.toString());
			}

			try {
				var traceMap = transformer.getGipsl2GipsTrace();

				var gipslFileUri = gipsSlangFile.eResource().getURI().trimFragment().trimFileExtension().toString()
						+ ".gipsl";
				tracer.setModelUri("gipsl", gipslFileUri);

//				var gipsFileUri = URI.createFileURI(gipsApiData.apiPackageFolder.getLocation() + "/gips/gips-model.xmi");
				var gipsFileUri = gipsApiData.intermediateModelURI;
				tracer.setModelUri("gips", gipsFileUri.toString());

				tracer.addOrReplaceTrace("gipsl", "gips", traceMap);
			} catch (Exception e) {
				LogUtils.error(logger, e.toString());
			}

			try {
				TraceModelBuilder builder = new TraceModelBuilder();
				builder.addModel("gipsl", null);
				builder.addModel("gips", null);

				var traceMap = transformer.getGipsl2GipsTrace();
				var mapping = TraceMap.normalize(traceMap, ResolverEcore2Id.INSTANCE, ResolverEcore2Id.INSTANCE);
				builder.addTraceToModel("gipsl", "gips", mapping);
				GipsBuilderUtils.saveResource(builder.getModelRoot(),
						project.getLocation().append("traces").append("gipsl2gips-trace.xmi").toOSString());
			} catch (Exception e) {
				LogUtils.error(logger, e.toString());
			}
		} catch (Exception ex1) {
			System.err.println(ex1.getMessage());
		}
	}

}
