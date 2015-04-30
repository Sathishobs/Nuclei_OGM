/**
 * 
 */
package nuclei.controller;

import javax.servlet.http.HttpServletResponse;

import nuclei.domain.TemplateAttributes;
import nuclei.service.AttributesService;
import nuclei.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.multipart.FormDataParam;

/**
 * @author Karthikeyan
 *
 */

@RestController
public class AttributesController extends MainController<TemplateAttributes> {

	@Autowired
	private AttributesService attributesService;

	@RequestMapping(value = "/attributes", method = RequestMethod.GET)
	public @ResponseBody Iterable<TemplateAttributes> list(
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.list();
	}

	@RequestMapping(value = "/attribute", method = RequestMethod.POST)
	public TemplateAttributes create(@FormDataParam("UUID") Long UUID,
			@FormDataParam("name") String name,
			@FormDataParam("value") String value,
			final HttpServletResponse response) {

		TemplateAttributes entity = new TemplateAttributes();
		entity.setUUID(UUID.intValue());
		entity.setName(name);
		entity.setValue(value);

		response.setHeader("Cache-Control", "no-cache");
		super.create(entity);
		return entity;

	}

	@RequestMapping(value = "/attribute/{id}", method = RequestMethod.GET)
	public TemplateAttributes find(@PathVariable Long id,
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.find(id);
	}

	@RequestMapping(value = "/attribute/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, final HttpServletResponse response) {
		setHeaders(response);
		super.delete(id);
	}

	@RequestMapping(value = "/attribute/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public TemplateAttributes update(@PathVariable Long id,
			@RequestBody TemplateAttributes entity,
			final HttpServletResponse response) {
		setHeaders(response);
		return super.update(id, entity);
	}

	@Override
	public MainService<TemplateAttributes> getService() {
		return attributesService;
	}

}
