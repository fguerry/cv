package fr.fguerry.cv.model;

import java.util.List;

/**
 * Abstract class to describe an element of the model that contains a list of
 * sub elements.
 * 
 * @author fguerry
 *
 * @param <Type> type of the sub element.
 */
public abstract class CvCompositeElement<Type extends CvElement> extends CvBasicElement {
	private List<Type> blocks;

	public List<Type> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Type> blocks) {
		this.blocks = blocks;
	}

}
