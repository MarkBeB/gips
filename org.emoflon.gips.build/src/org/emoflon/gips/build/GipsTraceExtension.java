package org.emoflon.gips.build;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.emoflon.gips.build.transformation.GipsTracer;

public final class GipsTraceExtension implements GipsTracer {

	private static GipsTracer INSTANCE;

	public static GipsTracer getTraceMapping(String context) {
		if (INSTANCE == null) {
			INSTANCE = new GipsTraceExtension();
		}
		
		

		return INSTANCE;
	}

	private static Collection<GipsTracer> collectExtensions() {
		final var config = Platform.getExtensionRegistry().getConfigurationElementsFor(GipsTracer.BUILDER_EXTENSON_ID);

		final var result = new LinkedList<GipsTracer>();

		for (final var e : config) {
			try {
				final var api = (GipsTracer) e.createExecutableExtension("class");
				result.add(api);
			} catch (final CoreException ex) {
				System.err.println(ex.getMessage());
			}
		}

		return result;
	}

	private final Collection<GipsTracer> extensions;

	private GipsTraceExtension() {
		extensions = collectExtensions();
	}

	private void run(Consumer<GipsTracer> action) {
		for (final var ext : extensions) {
			try {
				action.accept(ext);
			} catch (final Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void clearTrace(String srcModelId, String dstModelId) {
		run(ext -> ext.clearTrace(srcModelId, dstModelId));
	}

	@Override
	public void trace(EObject srcNode, EObject dstNode) {
		run(ext -> ext.trace(srcNode, dstNode));
	}
	
	@Override
	public void map(String srcModelId, EObject srcNode, String dstModelId, EObject dstNode) {
		run(ext -> ext.map(srcModelId, srcNode, dstModelId, dstNode));
	}

//	def
//
//	static void runBuilderExtensions(Consumer<GipsBuilderExtension> action) {
//		final val ISafeRunnable runnable = new ISafeRunnable() {
//			
//			override handleException(Throwable e) {
//				System.err.println(e.getMessage())
//			}
//			
//			override run() throws Exception {
//				collectExtensions(GipsBuilderExtension.BUILDER_EXTENSON_ID, "class", typeof(GipsBuilderExtension))
//						.forEach(action);
//			}
//
//		};
//		SafeRunner.run(runnable);
//	}
//
//	def
//
//	static <T> Collection<T> collectExtensions(String extensionID, String property, Class<T> extensionType) {
//		final val extensions = new ArrayDeque<T>();
//		final val config = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionID);
//		try {
//			for (final IConfigurationElement e : config) {
//				final val o = e.createExecutableExtension(property);
//				if (extensionType.isInstance(o)) {
//					extensions.add(extensionType.cast(o));
//				}
//			}
//		} catch (final CoreException ex) {
//			System.err.println(ex.message)
//		}
//
//		return extensions;
//	}
}
