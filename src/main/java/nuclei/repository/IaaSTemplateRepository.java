/**
 * 
 */
package nuclei.repository;

import nuclei.domain.IaaSTemplate;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Karthikeyan
 *
 */
@Repository
public interface IaaSTemplateRepository extends GraphRepository<IaaSTemplate>{

}