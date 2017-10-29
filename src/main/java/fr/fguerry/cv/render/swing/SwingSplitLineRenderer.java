package fr.fguerry.cv.render.swing;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.fguerry.cv.model.SplitLine;
import fr.fguerry.cv.render.BlockRenderer;
import fr.fguerry.cv.render.BlockRendererRange;

/**
 * This class renders {@link SplitLine}s instances into a Swing application.
 * 
 * @author fguerry
 *
 */
@BlockRendererRange(SplitLine.class)
public class SwingSplitLineRenderer implements BlockRenderer<SplitLine, SwingBlockContext> {

	@Override
	public void renderInContext(SplitLine line, SwingBlockContext context) {
		context.constraints.gridwidth = 1;
		context.constraints.gridx = 0;
		context.constraints.insets = new Insets(0, 10, 0, 0);
		context.panel.add(new JLabel(line.getTitle()), context.constraints);
		context.constraints.gridx = 1;
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel(line.getSubTitle()), BorderLayout.NORTH);
		final JTextArea area = new JTextArea(line.getContent());
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		panel.add(area, BorderLayout.CENTER);
		context.panel.add(panel, context.constraints);
		context.constraints.gridy++;
	}

}
