/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.caelum.vraptor.scan;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.config.BasicConfiguration;

/**
 * A classpath resolver based on ServletContext
 * 
 * @author Sérgio Lopes
 * @since 3.2
 */
public class WebBasedClasspathResolver implements ClasspathResolver {
	private static final Logger logger = LoggerFactory
			.getLogger(WebBasedClasspathResolver.class);
	private static final String WEBINF_DIR = "/WEB-INF/classes";
	private static final String MAVEN_DIR = "target/classes";

	private final ServletContext servletContext;

	public WebBasedClasspathResolver(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private String findClassesDir() {
		String classesDirName = servletContext.getRealPath(WEBINF_DIR);
		if (classesDirName != null) {
			logger.info("Trying " + WEBINF_DIR);
			File classesDir = new File(classesDirName);
			if (!classesDir.exists()) {
				logger.info("Trying " + MAVEN_DIR);
				classesDir = new File(MAVEN_DIR);
				classesDirName = classesDir.getAbsolutePath();
			}
		}
		return classesDirName;
	}

	public URL findWebInfClassesLocation() {
		try {
			String webInfClassesDir = findClassesDir();
			if (webInfClassesDir != null) {
				return new URL("file:" + webInfClassesDir + "/");
			} else {
				// try to guess WEB-INF/classes from vraptor.jar location
				return new StandaloneClasspathResolver()
						.findWebInfClassesLocation();
			}
		} catch (Exception e) {
			throw new ScannerException(
					"Could not determine WEB-INF/classes location", e);
		}
	}

	public List<String> findBasePackages() {
		ArrayList<String> packages = new ArrayList<String>();

		// find packages from web.xml
		String packagesParam = servletContext
				.getInitParameter(BasicConfiguration.BASE_PACKAGES_PARAMETER_NAME);
		if (packagesParam != null) {
			Collections.addAll(packages, packagesParam.trim()
					.split("\\s*,\\s*"));
		}

		// find plugin packages
		new StandaloneClasspathResolver().getPackagesFromPluginsJARs(packages);
		return packages;
	}

	@Override
	public ClassLoader getClassLoader() {
		return WebBasedClasspathResolver.class.getClassLoader();
	}

}