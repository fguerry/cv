package fr.fguerry.cv.render.swing;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import fr.fguerry.cv.model.CvBlock;

/**
 * This context class holds all necessary information to render {@link CvBlock}s
 * into a Swing application.
 * 
 * @author fguerry
 *
 */
public class SwingBlockContext {
	final JPanel panel;
	final GridBagConstraints constraints;

	public SwingBlockContext(JPanel panel, GridBagConstraints constraints) {
		super();
		this.panel = panel;
		this.constraints = constraints;
	}
}
