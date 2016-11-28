/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package org.dakhani.utils;

import java.io.InputStream;

/**
 * @author Sami Dakhani Created on Nov 27, 2016
 *
 */
public class ResourceLoader {

	/**
	 * Reads a resource file in src/main/resources as a string
	 * 
	 * @param fileName
	 * @return
	 */
	public InputStream loadResource(final String fileName) {

		ClassLoader classLoader = this.getClass().getClassLoader();

		try {
			return classLoader.getResourceAsStream(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
