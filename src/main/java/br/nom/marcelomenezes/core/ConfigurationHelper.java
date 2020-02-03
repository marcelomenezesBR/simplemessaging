package br.nom.marcelomenezes.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHelper {

	private static Properties properties;
	
	public static void init() {
		properties = new Properties();
		final InputStream stream = ConfigurationHelper.class
				.getResourceAsStream("/config.properties");
		if (stream == null) {
			throw new RuntimeException("No properties!!!");
		}
		try {
			properties.load(stream);
		} catch (final IOException e) {
			throw new RuntimeException("Configuration could not be loaded!");
		}
	}
	
	public static Properties getProperties() {
		if (properties==null)
			init();
		return properties;
	}
}
