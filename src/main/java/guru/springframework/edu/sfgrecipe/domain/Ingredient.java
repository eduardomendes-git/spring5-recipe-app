/**
 * 
 */
package guru.springframework.edu.sfgrecipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author edmen
 * @date 19 May 2021
 *
 */
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unitOfMeasure;
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = unitOfMeasure;
		this.recipe = recipe;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
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
	 * @return the unitOfMeasure
	 */
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	/**
	 * @param unitOfMeasure the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
}
