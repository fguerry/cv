package fr.fguerry.cv.parser;

import java.io.IOException;
import java.io.InputStream;

import fr.fguerry.cv.model.CvContent;

/**
 * API to obtain a CV content from an arbitrary input stream.
 * 
 * @author fguerry
 *
 */
public interface CvParser {

	CvContent parse(InputStream cvStream) throws IOException;

}
