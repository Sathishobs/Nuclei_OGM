/**
 * 
 */
package nuclei.repository;

import nuclei.domain.Member;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sathish
 *
 */
@Repository
public interface MemberRepository extends GraphRepository<Member>{

}
