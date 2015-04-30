package nuclei.service;

import nuclei.domain.Entity;

import org.springframework.data.neo4j.repository.GraphRepository;

public abstract class GenericService<T> implements MainService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;

    public Iterable<T> findAll() {
        return getRepository().findAll(DEPTH_LIST);
    }

    public T find(Long id) {
    	Long id1=id.longValue();
        return getRepository().findOne(id1, DEPTH_ENTITY);
    }

    public void delete(Long id) {
    	Long id1=id.longValue();
        getRepository().delete(id1);
    }

    public T createOrUpdate(T entity) {
        getRepository().save(entity, DEPTH_ENTITY);
        return find(((Entity) entity).getId());
    }

    public abstract GraphRepository<T> getRepository();
}
