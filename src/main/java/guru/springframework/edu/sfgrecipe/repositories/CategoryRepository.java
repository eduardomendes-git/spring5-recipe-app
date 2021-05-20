/**
 * 
 */
package guru.springframework.edu.sfgrecipe.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.edu.sfgrecipe.domain.Category;

/**
 * @author edmen
 * @date 20 May 2021
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
