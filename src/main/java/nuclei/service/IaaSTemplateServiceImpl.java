/**
 * 
 */
package nuclei.service;

import nuclei.domain.IaaSTemplate;
import nuclei.repository.IaaSTemplateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author Karthikeyan
 *
 */
@Service("templateService")
public class IaaSTemplateServiceImpl extends GenericService<IaaSTemplate> implements IaaSTemplateService {

	@Autowired
	private IaaSTemplateRepository templateRepository;

	@Override
	public GraphRepository<IaaSTemplate> getRepository() {
		return templateRepository;
	}
}
