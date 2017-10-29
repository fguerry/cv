package fr.fguerry.cv.model;

/**
 * A CvSection is represented as a titled entry with composite content. A
 * typical section would be "education" or "skills"... A section contains
 * sub-elements identified by the common API {@link CvSubBlock}.
 * 
 * @author fguerry
 *
 */
public class CvSection extends CvCompositeElement<CvSubBlock> implements CvBlock {
}
