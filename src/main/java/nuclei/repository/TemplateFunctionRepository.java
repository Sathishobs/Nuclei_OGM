/**
 * 
 */
package nuclei.repository;

import nuclei.domain.TemplateFunction;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Karthikeyan
 *
 */
@Repository
public interface TemplateFunctionRepository extends GraphRepository<TemplateFunction>{

}
