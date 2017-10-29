package fr.fguerry.cv.render.swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.fguerry.cv.model.CvContent;
import fr.fguerry.cv.render.AbstractCvRenderer;
import fr.fguerry.cv.svg.SVGUtil;

/**
 * This class allow to render a {@link CvContent} as a Swing application.
 * 
 * @author fguerry
 *
 */
public class SwingCvRenderer extends AbstractCvRenderer<JFrame, SwingBlockContext> {

	public SwingCvRenderer() {
		super(SwingHeaderRenderer.class, SwingSectionRenderer.class, SwingSplitLineRenderer.class);
	}

	@Override
	public void render(CvContent cv) {
		SwingUtilities.invokeLater(() -> super.render(cv));
	}

	@Override
	public JFrame createContext(CvContent cv) {
		final String title = cv.getTitle();
		final JFrame frame = new JFrame(title == null ? "CV Viewer" : title);
		frame.setIconImage(SVGUtil.createSVGImage(getClass().getResource("cv-icon.svg")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(210, 297));
		return frame;
	}

	@Override
	public SwingBlockContext createBlockContext(CvContent cv, JFrame context) {
		final JPanel panel = new JPanel(new GridBagLayout());
		context.setContentPane(panel);
		return new SwingBlockContext(panel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	@Override
	public void showInContext(CvContent cv, JFrame frame) {
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
