package fr.fguerry.cv.render;

import fr.fguerry.cv.model.CvContent;

/**
 * API to render the given CV into a visual representation of some sort.
 * 
 * @author fguerry
 *
 */
public interface CvRenderer {
	void render(CvContent cv);
}
