package fr.fguerry.cv.model;

/**
 * A split line is an element (sub element of a {@link CvSection} actually) that
 * present a title, a subtitle and a detailed content. Rendering details depend
 * on mode of the chosen renderer.
 * 
 * @author fguerry
 *
 */
public class SplitLine extends CvBasicElement implements CvSubBlock {
	private String subTitle;
	private String content;

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
