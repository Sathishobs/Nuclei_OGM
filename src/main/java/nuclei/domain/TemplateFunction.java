/**
 * 
 */
package nuclei.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Karthikeyan
 *
 */

public class TemplateFunction extends Entity {

	private Integer UUID;
	private String function;
	private String description;

	@Relationship(type = "attribute")
	List<TemplateAttributes> templateAttributes;

	public TemplateFunction() {
		templateAttributes = new ArrayList<TemplateAttributes>();
	}

	public TemplateFunction(Integer UUID, String function, String description) {
		this();
		this.UUID = UUID;
		this.function = function;
		this.description = description;
	}

	public Integer getUUID() {
		return UUID;
	}

	public void setUUID(Integer UUID) {
		this.UUID = UUID;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TemplateAttributes> getTemplateAttributes() {
		return templateAttributes;
	}

	public void setTemplateAttributes(
			List<TemplateAttributes> templateAttributes) {
		this.templateAttributes = templateAttributes;
	}

	@Override
	public String toString() {
		return "Template{" + "id=" + getId() + 
				", UUID=" + UUID + 
				",function=" + function + 			
				", description=" + description + 
						'}';
	}
}