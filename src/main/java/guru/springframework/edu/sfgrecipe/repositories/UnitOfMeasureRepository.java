/**
 * 
 */
package guru.springframework.edu.sfgrecipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.edu.sfgrecipe.domain.UnitOfMeasure;

/**
 * @author edmen
 * @date 20 May 2021
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
