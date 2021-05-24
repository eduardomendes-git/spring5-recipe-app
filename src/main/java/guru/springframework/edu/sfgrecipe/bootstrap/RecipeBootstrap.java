/**
 * 
 */
package guru.springframework.edu.sfgrecipe.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.edu.sfgrecipe.domain.Category;
import guru.springframework.edu.sfgrecipe.domain.Ingredient;
import guru.springframework.edu.sfgrecipe.domain.Notes;
import guru.springframework.edu.sfgrecipe.domain.Recipe;
import guru.springframework.edu.sfgrecipe.domain.UnitOfMeasure;
import guru.springframework.edu.sfgrecipe.domain.enums.Difficulty;
import guru.springframework.edu.sfgrecipe.repositories.CategoryRepository;
import guru.springframework.edu.sfgrecipe.repositories.RecipeRepository;
import guru.springframework.edu.sfgrecipe.repositories.UnitOfMeasureRepository;

/**
 * @author edmen
 * @date 20 May 2021
 *
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeRepository recipeRepository;
	
	public RecipeBootstrap(CategoryRepository categoryRepository,
						   UnitOfMeasureRepository unitOfMeasureRepository,
						   RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipes());
		
	}
	
	private List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		// Get Units of Measure
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
		if (!eachUomOptional.isPresent()) {
			throw new RuntimeException("Each - Expected UOM not found.");
		}
		
		Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		if (!tablespoonUomOptional.isPresent()) {
			throw new RuntimeException("Tablespoon - Expected UOM not found.");
		}
		
		Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		if (!teaspoonUomOptional.isPresent()) {
			throw new RuntimeException("Teaspoon - Expected UOM not found.");
		}
		
		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
		if (!dashUomOptional.isPresent()) {
			throw new RuntimeException("Dash - Expected UOM not found.");
		}
		
		Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
		if (!pintUomOptional.isPresent()) {
			throw new RuntimeException("Pint - Expected UOM not found.");
		}
		
		Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
		if (!cupUomOptional.isPresent()) {
			throw new RuntimeException("Cup - Expected UOM not found.");
		}
		
		UnitOfMeasure eachUom		= eachUomOptional.get();
		UnitOfMeasure tablespoonUom	= tablespoonUomOptional.get();
		UnitOfMeasure teaspoonUom	= teaspoonUomOptional.get();
		UnitOfMeasure dashUom		= dashUomOptional.get();
		UnitOfMeasure pintUom		= pintUomOptional.get();
		UnitOfMeasure cupUom		= cupUomOptional.get();
		
		// Get Categories
		Optional<Category> americanCatOptional = categoryRepository.findByDescription("American");
		if (!americanCatOptional.isPresent()) {
			throw new RuntimeException("American - Expected Category not found.");
		}
		
		Optional<Category> mexicanCatOptional = categoryRepository.findByDescription("Mexican");
		if (!mexicanCatOptional.isPresent()) {
			throw new RuntimeException("Mexican - Expected Category not found.");
		}
		
		Category americanCategory = americanCatOptional.get();
		Category mexicanCategory = mexicanCatOptional.get();
		
		Recipe guacaRecipe = new Recipe();
		guacaRecipe.setDescription("Perfect Guacamole");
		guacaRecipe.setPreparationTime(10);
		guacaRecipe.setCookingTime(0);
		guacaRecipe.setDifficulty(Difficulty.EASY);
		guacaRecipe.setDirections("TBD");
		
		Notes guacaNotes = new Notes();
		guacaNotes.setRecipeNotes("TBD");
		guacaNotes.setRecipe(guacaRecipe);
		guacaRecipe.setNotes(guacaNotes);
		
		guacaRecipe.getIngredients().add(new Ingredient("Ripe Avocados", new BigDecimal(10), eachUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal(0.5), teaspoonUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), eachUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Serrano chiles, steasms and seeds removed, minced", new BigDecimal(2), eachUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Freshly grated black pepper", new BigDecimal(2), dashUom, guacaRecipe));
		guacaRecipe.getIngredients().add(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUom, guacaRecipe));
		
		guacaRecipe.getCategories().add(americanCategory);
		guacaRecipe.getCategories().add(mexicanCategory);
		
		recipes.add(guacaRecipe);
		
		Recipe tacosRecipe = new Recipe();
		tacosRecipe.setDescription("Spicy grilled chicken Taco");
		tacosRecipe.setPreparationTime(20);
		tacosRecipe.setCookingTime(10);
		tacosRecipe.setDifficulty(Difficulty.MODERATE);
		tacosRecipe.setDirections("TBD");
		
		Notes tacosNotes = new Notes();
		tacosNotes.setRecipeNotes("TBD");
		tacosNotes.setRecipe(tacosRecipe);
		tacosRecipe.setNotes(tacosNotes);
		
		tacosRecipe.getIngredients().add(new Ingredient("Ancho Chilly powder", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Dried oregano", new BigDecimal(1), teaspoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Dried cumin", new BigDecimal(2), teaspoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(2), teaspoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(2), teaspoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Clove of garlic, chopped", new BigDecimal(2), eachUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Finely grated orange zestr", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Olive oil", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Boneless chicken thighs", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Small corn tortillas", new BigDecimal(2), tablespoonUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Packed baby arugula", new BigDecimal(2), eachUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Medium ripe avocados, slic", new BigDecimal(2), cupUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Radishes, thinly sliced", new BigDecimal(2), pintUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Cherry tomatoes halved", new BigDecimal(2), eachUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Red onion thinly sliced", new BigDecimal(2), eachUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(2), cupUom, tacosRecipe));
		tacosRecipe.getIngredients().add(new Ingredient("Cup sower cream thinned with 1/4 cup milk", new BigDecimal(2), eachUom, tacosRecipe));
		
		tacosRecipe.getCategories().add(americanCategory);
		tacosRecipe.getCategories().add(mexicanCategory);
		
		recipes.add(tacosRecipe);
		
		return recipes;
	}
}
