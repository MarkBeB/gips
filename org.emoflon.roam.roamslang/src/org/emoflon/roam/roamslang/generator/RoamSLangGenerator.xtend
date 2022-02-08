/*
 * generated by Xtext 2.25.0
 */
package org.emoflon.roam.roamslang.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.emoflon.roam.roamslang.roamSLang.EditorGTFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import java.util.function.Consumer
import org.eclipse.core.runtime.ISafeRunnable
import org.eclipse.core.runtime.SafeRunner
import java.util.Collection
import java.util.ArrayDeque
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.CoreException
import java.io.FileNotFoundException

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class RoamSLangGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// extract model out of the resource
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl())
		val rs = new ResourceSetImpl;
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl())
		val model = resource.contents.get(0) as EditorGTFile;
		val output = rs.createResource(URI.createURI(resource.URI.trimFileExtension+".xmi"))
		// add model and resolve
		output.contents.add(model)
		EcoreUtil.resolveAll(output)
		
		// configure save options
		val saveOptions = (output as XMIResource).getDefaultSaveOptions()
		saveOptions.put(XMIResource.OPTION_ENCODING,"UTF-8");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION,Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		// save output
		(output as XMIResource).save(saveOptions)
		System.out.println("Xtext model saved to: "+output.URI.path)
		
		// run the builder with model
		val workspace = getWorkspace()
		val project = getProjectOfResource(workspace, output)
		if(project === null)
			throw new FileNotFoundException("Could not find xtext model file: "+ output.URI.path)
			
		runBuilderExtensions([ext | ext.build(project, output)])
	}
	
	/**
	 * @returns the resource plugin workspace 
	 */
	def static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace()
	}
	
	/**
	 * Returns the project for resource URI in a given workspace
	 * 
	 * @param workspace
	 * 				to be searched in for the project
	 * @param resource
	 * 				in the project, which should be returned
	 * @return the project for the given resource or null, if no corresponding project
	 * 				is found or the segment count for the resource is to small
	 * 
	 */
	def static IProject getProjectOfResource(IWorkspace workspace, Resource resource) {
		if(resource.URI.segmentCount<2)
				return null;
				
		for(project : workspace.root.projects) {
			val projectName = resource.URI.segment(1)
			if(project.name.equalsIgnoreCase(projectName)) {
				return project;
			}
		}
		
		return null;
	}
	
	/**
	 * Runs builder extensions with for all extensions with the GrapelBuilderExtension ID as a runnable.
	 * 
	 * @param action
	 * 			the consumer action for the GrapelBuilderExtension
	 * 
	 */
	def static void runBuilderExtensions(Consumer<RoamBuilderExtension> action) {
		val ISafeRunnable runnable = new ISafeRunnable() {
			
			override handleException(Throwable e) {
				System.err.println(e.getMessage())
			}
			
			override run() throws Exception {
				collectExtensions(RoamBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(RoamBuilderExtension))
						.forEach(action);
			}

		};
		SafeRunner.run(runnable);
	}
	
	/**
	 * Collects all registered extensions with the given ID.
	 * 
	 * @param extensionID
	 *            the ID of the extension
	 * @param property
	 *            the name of the property
	 * @param extensionType
	 *            the extension type
	 * @return all extensions with the given ID as extensions of the given type
	 */
	def static <T> Collection<T> collectExtensions(String extensionID, String property, Class<T> extensionType) {
		val extensions = new ArrayDeque<T>();
		val config = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionID);
		try {
			for (IConfigurationElement e : config) {
				val o = e.createExecutableExtension(property);
				if (extensionType.isInstance(o)) {
					extensions.add(extensionType.cast(o));
				}
			}
		} catch (CoreException ex) {
			System.err.println(ex.message)
		}

		return extensions;
	}
}
 