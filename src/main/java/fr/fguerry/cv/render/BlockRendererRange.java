package fr.fguerry.cv.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import fr.fguerry.cv.model.CvElement;

/**
 * Annotation to provide easy discovery of rendering classes to the
 * {@link AbstractCvRenderer}.
 * 
 * @author fguerry
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BlockRendererRange {
	/**
	 * Tells which kind of {@link CvElement} the annotated type is able to
	 * render.
	 * 
	 * @return
	 */
	Class<? extends CvElement> value() default CvElement.class;
}
