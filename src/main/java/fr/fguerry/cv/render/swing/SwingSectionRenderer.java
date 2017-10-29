package fr.fguerry.cv.render.swing;

import java.awt.Insets;

import javax.swing.JLabel;

import fr.fguerry.cv.model.CvSection;
import fr.fguerry.cv.render.BlockRenderer;
import fr.fguerry.cv.render.BlockRendererRange;

/**
 * This class renders {@link CvSection}s instances into a Swing application.
 * 
 * @author fguerry
 *
 */
@BlockRendererRange(CvSection.class)
public class SwingSectionRenderer implements BlockRenderer<CvSection, SwingBlockContext> {

	@Override
	public void renderInContext(CvSection block, SwingBlockContext context) {
		context.constraints.gridwidth = 2;
		context.constraints.gridx = 0;
		context.constraints.insets = new Insets(5, 5, 5, 5);
		final JLabel label = new JLabel(block.getTitle());
		label.setFont(label.getFont().deriveFont(18f));
		context.panel.add(label, context.constraints);
		context.constraints.gridy++;
	}

}
