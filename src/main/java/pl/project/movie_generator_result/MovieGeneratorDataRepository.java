package pl.project.movie_generator_result;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGeneratorDataRepository extends CrudRepository<MovieGeneratorDataEntity, Integer> {
}
