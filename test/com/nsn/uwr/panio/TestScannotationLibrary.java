package com.nsn.uwr.panio;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

public class TestScannotationLibrary {


	@Test
	public void testFindClasspaths2() throws Exception {
		// given
		URL[] urls = ClasspathUrlFinder.findClassPaths();
		AnnotationDB db = new AnnotationDB();
		
		// when
		db.scanArchives(urls);

		Map<String, Set<String>> annotationIndex = db.getAnnotationIndex();
		Set<String> tests = annotationIndex.get(Test.class.getCanonicalName());

		// then
		Assertions.assertThat(tests).contains(this.getClass().getCanonicalName());
		
	}

}
