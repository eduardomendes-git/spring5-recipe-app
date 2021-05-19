/**
 * 
 */
package guru.springframework.edu.sfgrecipe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author edmen
 * @date 19 May 2021
 *
 */
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String		description;
	// TODO Add enum
	//private Difficulty	difficulty
	
	@Lob
	private Byte[]		image;
	private Integer		preparationTime;
	private Integer		cookingTime;
	private Integer		servings;
	private String		source;
	private String		directions;
	private String		url;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes		notes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
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
	 * @return the image
	 */
	public Byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Byte[] image) {
		this.image = image;
	}
	/**
	 * @return the preparationTime
	 */
	public Integer getPreparationTime() {
		return preparationTime;
	}
	/**
	 * @param preparationTime the preparationTime to set
	 */
	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
	/**
	 * @return the cookingTime
	 */
	public Integer getCookingTime() {
		return cookingTime;
	}
	/**
	 * @param cookingTime the cookingTime to set
	 */
	public void setCookingTime(Integer cookingTime) {
		this.cookingTime = cookingTime;
	}
	/**
	 * @return the servings
	 */
	public Integer getServings() {
		return servings;
	}
	/**
	 * @param servings the servings to set
	 */
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}
	/**
	 * @param directions the directions to set
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the notes
	 */
	public Notes getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
}
