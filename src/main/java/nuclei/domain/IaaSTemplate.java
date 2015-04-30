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

public class IaaSTemplate extends Entity {

	private Integer UUID;
	private String script;
	private String onIaas;

	@Relationship(type = "function")
	List<TemplateFunction> driverFunction;

	public IaaSTemplate() {
		driverFunction = new ArrayList<TemplateFunction>();
	}

	public IaaSTemplate(Integer UUID, String script, String onIaas) {
		this();
		this.UUID = UUID;
		this.script = script;
		this.onIaas = onIaas;
	}

	public Integer getUUID() {
		return UUID;
	}

	public void setUUID(Integer uUID) {
		this.UUID = uUID;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getOnIaas() {
		return onIaas;
	}

	public void setOnIaas(String onIaas) {
		this.onIaas = onIaas;
	}

	public List<TemplateFunction> getDriverFunction() {
		return driverFunction;
	}

	public void setDriverFunction(List<TemplateFunction> driverFunction) {
		this.driverFunction = driverFunction;
	}

	@Override
	public String toString() {
		return "Template{" + "id=" + getId() + 
				", UUID=" + UUID + 
				", script=" + script + 
				", onIaas=" + onIaas + 
				", driverFunction=" + driverFunction +				
				'}';
	}
}