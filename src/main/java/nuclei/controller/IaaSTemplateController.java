/**
 * 
 */
package nuclei.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import nuclei.domain.IaaSTemplate;
import nuclei.domain.TemplateFunction;
import nuclei.repository.IaaSTemplateRepository;
import nuclei.service.IaaSTemplateService;
import nuclei.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
public class IaaSTemplateController extends MainController<IaaSTemplate> {

	@Autowired
	private IaaSTemplateService templateService;
	@Autowired
	private IaaSTemplateRepository templateRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("home", new IaaSTemplate());
		return "index";
	}

	@RequestMapping(value = "/templates", method = RequestMethod.GET)
	public @ResponseBody Iterable<IaaSTemplate> list(
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.list();
	}

	/*
	 * 
	 * insert IaasTemplate values
	 */
	@RequestMapping(value = "/template", method = RequestMethod.POST)
	public IaaSTemplate create(@FormDataParam("UUID") String UUID,
			@FormDataParam("script") String script,
			@FormDataParam("onIaas") String onIaas,
			final HttpServletResponse response) {

		IaaSTemplate entity = new IaaSTemplate();
		entity.setUUID(Integer.parseInt(UUID));
		entity.setScript(script);
		entity.setOnIaas(onIaas);

		response.setHeader("Cache-Control", "no-cache");
		super.create(entity);
		return entity;
	}

	/*
	 * 
	 * create functions
	 */

	@RequestMapping(value = "/template", method = RequestMethod.PUT)
	public IaaSTemplate addFunction(@FormDataParam("id") String id,
			@FormDataParam("UUID") String UUID,
			@FormDataParam("function") String function,
			@FormDataParam("description") String description,
			final HttpServletResponse response) {

		IaaSTemplate entity = new IaaSTemplate();

		Long iaasId = Long.parseLong(id);

		List<TemplateFunction> templateFunction = new ArrayList<TemplateFunction>();
		TemplateFunction functions = new TemplateFunction();
		functions.setUUID(Integer.parseInt(UUID));
		functions.setFunction(function);
		functions.setDescription(description);

		templateFunction.add(functions);

		IaaSTemplate iaas = templateService.find(iaasId);
		iaas.setUUID(entity.getUUID());
		iaas.setScript(entity.getScript());
		iaas.setOnIaas(entity.getOnIaas());

		iaas.setDriverFunction(templateFunction);

		setHeaders(response);
		return super.update(iaasId, iaas);
	}

	@RequestMapping(value = "/template/{id}", method = RequestMethod.GET)
	public IaaSTemplate find(@PathVariable Long id,
			final HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		return super.find(id);
	}

	@RequestMapping(value = "/template/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id, final HttpServletResponse response) {

		setHeaders(response);
		super.delete(id);
	}

	@RequestMapping(value = "/template/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public IaaSTemplate update(@PathVariable Long id,
			@RequestBody IaaSTemplate entity, final HttpServletResponse response) {
		setHeaders(response);
		return super.update(id, entity);
	}

	@Override
	public MainService<IaaSTemplate> getService() {
		return templateService;
	}

}
