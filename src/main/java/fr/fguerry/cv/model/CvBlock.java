package fr.fguerry.cv.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * A CvBlock is a composite sub element of the main container {@link CvContent}.
 * 
 * @author fguerry
 *
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
		@Type(value = CvHeader.class, name = "header"),
		@Type(value = CvSection.class, name = "section")
})
public interface CvBlock extends CvElement {

}
