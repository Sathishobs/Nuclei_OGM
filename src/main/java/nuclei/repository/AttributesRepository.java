/**
 * 
 */
package nuclei.repository;

import nuclei.domain.TemplateAttributes;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Karthikeyan
 *
 */
@Repository
public interface AttributesRepository extends GraphRepository<TemplateAttributes>{

}
