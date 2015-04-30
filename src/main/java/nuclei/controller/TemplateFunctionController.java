/**
 * 
 */
package nuclei.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import nuclei.domain.TemplateAttributes;
import nuclei.domain.TemplateFunction;
import nuclei.service.TemplateFunctionService;
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
public class TemplateFunctionController extends
		MainController<TemplateFunction> {

	@Autowired
	private TemplateFunctionService templateFunctionService;

	@RequestMapping(value = "/functions", method = RequestMethod.GET)
	public @ResponseBody Iterable<TemplateFunction> list(
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.list();
	}

	@RequestMapping(value = "/function", method = RequestMethod.POST)
	public TemplateFunction create(@FormDataParam("UUID") String UUID,
			@FormDataParam("function") String function,
			@FormDataParam("description") String description,
			final HttpServletResponse response) {

		TemplateFunction entity = new TemplateFunction();
		entity.setUUID(Integer.parseInt(UUID));
		entity.setFunction(function);
		entity.setDescription(description);
		
		response.setHeader("Cache-Control", "no-cache");
		super.create(entity);

		return entity;
	}

	//add attributes
	@RequestMapping(value = "/function", method = RequestMethod.PUT)
	public TemplateFunction addAttribute(@FormDataParam("id") String id,
			@FormDataParam("UUID") String UUID,
			@FormDataParam("name") String name,
			@FormDataParam("value") String value,
			final HttpServletResponse response) {

		Long functionId = Long.parseLong(id);

		TemplateFunction entity = new TemplateFunction();

		List<TemplateAttributes> templateAttribute = new ArrayList<TemplateAttributes>();
		TemplateAttributes attribute = new TemplateAttributes();

		attribute.setUUID(Integer.parseInt(UUID));
		attribute.setName(name);
		attribute.setValue(value);

		templateAttribute.add(attribute);

		TemplateFunction function = templateFunctionService.find(functionId);
		function.setUUID(entity.getUUID());
		function.setFunction(entity.getFunction());
		function.setDescription(entity.getDescription());
		function.setTemplateAttributes(templateAttribute);

		setHeaders(response);
		return super.update(functionId, function);
	}
	
	@RequestMapping(value = "/function/{id}", method = RequestMethod.GET)
	public TemplateFunction find(@PathVariable Long id,
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.find(id);
	}

	@RequestMapping(value = "/function/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, final HttpServletResponse response) {
		setHeaders(response);
		super.delete(id);
	}
	
	@RequestMapping(value = "/function/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public TemplateFunction update(@PathVariable Long id, @RequestBody TemplateFunction entity,
			final HttpServletResponse response) {
		setHeaders(response);
		return super.update(id, entity);
	}
	
	@Override
	public MainService<TemplateFunction> getService() {
		return templateFunctionService;
	}
}
