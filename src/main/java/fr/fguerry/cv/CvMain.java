package fr.fguerry.cv;

import java.io.IOException;
import java.io.InputStream;

import fr.fguerry.cv.model.CvContent;
import fr.fguerry.cv.parser.CvParser;
import fr.fguerry.cv.parser.JsonCvParser;
import fr.fguerry.cv.render.CvRenderer;
import fr.fguerry.cv.render.swing.SwingCvRenderer;

/**
 * Main class to visualize the CV in Swing
 * 
 * @author fguerry
 *
 */
public class CvMain {

	public static void main(String[] args) throws IOException {
		final InputStream cvStream = CvMain.class.getResourceAsStream("cv-fguerry.json");
		final CvParser parser = new JsonCvParser();
		final CvContent cv = parser.parse(cvStream);
		final CvRenderer renderer = new SwingCvRenderer();
		renderer.render(cv);
	}

}
