/**
 * 
 */
package guru.springframework.edu.sfgrecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author edmen
 *
 */
@Controller
public class IndexController {

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {
		return "index";
	}
}
