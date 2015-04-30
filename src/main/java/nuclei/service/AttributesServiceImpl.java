/**
 * 
 */
package nuclei.service;

import nuclei.domain.TemplateAttributes;
import nuclei.repository.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author Karthikeyan
 *
 */
@Service("attributesService")
public class AttributesServiceImpl extends GenericService<TemplateAttributes> implements AttributesService {

	@Autowired
    private AttributesRepository attributesRepository;

    @Override
    public GraphRepository<TemplateAttributes> getRepository() {
        return attributesRepository;
    }
}
