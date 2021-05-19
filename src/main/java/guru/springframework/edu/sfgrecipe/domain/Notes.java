/**
 * 
 */
package guru.springframework.edu.sfgrecipe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * @author edmen
 * @date 19 May 2021
 *
 */
@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Recipe recipe;
	
	@Lob
	private String recipeNotes;
	
	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}
	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	/**
	 * @return the recipeNotes
	 */
	public String getRecipeNotes() {
		return recipeNotes;
	}
	/**
	 * @param recipeNotes the recipeNotes to set
	 */
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}
}
