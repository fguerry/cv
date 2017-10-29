package fr.fguerry.cv.parser;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.fguerry.cv.model.CvContent;

/**
 * Parse a CV from a Json input stream.
 * 
 * @author fguerry
 *
 */
public class JsonCvParser implements CvParser {

	@Override
	public CvContent parse(InputStream sampleCvStream) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(sampleCvStream, CvContent.class);
	}

}
