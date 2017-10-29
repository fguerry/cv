package fr.fguerry.cv.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * A sub block can be any composite sub element that is contained by à
 * {@link CvSection}.
 * 
 * @author fguerry
 *
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
		@Type(value = SplitLine.class, name = "line")
})
public interface CvSubBlock extends CvBlock {

}
