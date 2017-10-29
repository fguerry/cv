package fr.fguerry.cv.model;

/**
 * Base class for some parts of the Cv content model. The basic element provides
 * only a title.
 * 
 * @author fguerry
 *
 */
public abstract class CvBasicElement implements CvElement {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
