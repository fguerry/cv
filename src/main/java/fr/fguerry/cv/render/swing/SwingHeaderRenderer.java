package fr.fguerry.cv.render.swing;

import javax.swing.JLabel;

import fr.fguerry.cv.model.CvHeader;
import fr.fguerry.cv.render.BlockRenderer;
import fr.fguerry.cv.render.BlockRendererRange;

/**
 * This class renders {@link CvHeader}s instances into a Swing application.
 * 
 * @author fguerry
 *
 */
@BlockRendererRange(CvHeader.class)
public class SwingHeaderRenderer implements BlockRenderer<CvHeader, SwingBlockContext> {

	@Override
	public void renderInContext(CvHeader block, SwingBlockContext context) {
		context.constraints.gridx = 0;
		context.constraints.gridwidth = 2;
		context.panel.add(new JLabel("header"), context.constraints);
		context.constraints.gridy++;
	}

}
