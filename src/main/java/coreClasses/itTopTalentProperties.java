package coreClasses;

import java.io.IOException;
import java.util.Properties;

public class itTopTalentProperties extends Properties{
	private static itTopTalentProperties props = null;

	private itTopTalentProperties() throws IOException
	{
		load(getClass().getResourceAsStream("/ittoptalent.properties"));
	}

	public static synchronized itTopTalentProperties getInstance() throws IOException
	{
		if (props == null)
		{
			props = new itTopTalentProperties();
		}
		return props;
	}
}
