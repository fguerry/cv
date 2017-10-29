package fr.fguerry.cv.render;

import fr.fguerry.cv.model.CvBlock;
import fr.fguerry.cv.model.CvElement;

/**
 * API to render a single {@link CvBlock}. It makes use of a blocks context
 * provided by the calling {@link CvRenderer} to do so.
 * 
 * @author fguerry
 *
 * @param <Type>
 * @param <BlocksContext>
 */
public interface BlockRenderer<Type extends CvElement, BlocksContext> {
	void renderInContext(Type block, BlocksContext context);
}
