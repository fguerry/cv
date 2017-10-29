package fr.fguerry.cv.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Test;

import fr.fguerry.cv.model.CvContent;

/**
 * Simple test case to load a sample cv from Json and test its content.
 * 
 * @author fguerry
 *
 */
public class JsonParserTest {

	@Test
	public void testJsonParser() throws Exception {
		CvParser parser = new JsonCvParser();
		final InputStream sampleCvStream = getClass().getResourceAsStream("sample-cv.json");
		final CvContent parse = parser.parse(sampleCvStream);
		assertNotNull(parse);
		assertEquals("title", parse.getTitle());
	}

}
