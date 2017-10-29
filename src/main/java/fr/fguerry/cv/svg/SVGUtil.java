package fr.fguerry.cv.svg;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;

import javax.swing.Icon;

import com.kitfox.svg.SVGCache;
import com.kitfox.svg.SVGUniverse;
import com.kitfox.svg.app.beans.SVGIcon;

/**
 * Utility class to load SVG resources as {@link Icon}s or {@link Image}s.
 * 
 * @author fguerry
 *
 */
public class SVGUtil {

	public static SVGIcon createSVGIcon(final URL resource) {
		final SVGUniverse universe = SVGCache.getSVGUniverse();
		final URI network = universe.loadSVG(resource);
		final SVGIcon svgIcon = new SVGIcon();
		svgIcon.setSvgUniverse(universe);
		svgIcon.setAntiAlias(true);
		svgIcon.setInterpolation(SVGIcon.INTERP_BICUBIC);
		svgIcon.setSvgURI(network);
		return svgIcon;
	}

	public static Image createSVGImage(final URL resource) {
		final SVGIcon icon = createSVGIcon(resource);
		final BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		icon.paintIcon(null, image.getGraphics(), 0, 0);
		return image;
	}
}
