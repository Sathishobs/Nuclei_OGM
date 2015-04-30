/**
 * 
 */
package nuclei.domain;

/**
 * @author Karthikeyan
 *
 */

public class TemplateAttributes extends Entity {

	private Integer UUID;
	private String name;
	private String value;

	public Integer getUUID() {
		return UUID;
	}

	public void setUUID(Integer UUID) {
		this.UUID = UUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Taxonomy{" + "id=" + getId() +	
				", UUID=" + UUID+
				", name=" + name+	
				", value=" + value+	
				 '}';
	}
}
