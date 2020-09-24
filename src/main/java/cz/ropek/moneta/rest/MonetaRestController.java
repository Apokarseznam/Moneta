package cz.ropek.moneta.rest;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class MonetaRestController {

	List<String> list = new ArrayList<String>();

	@GetMapping("/text")
	public List<String> getList() {
		return list;
	}

	@PostMapping("/text")
	public String addList(@RequestBody String text) {

		String[] array = text.split("");

		for (int i = 0; i < array.length; i++)
			if (array[i].matches("[aeiou]")) 
				array[i] = array[i].toUpperCase();
			else array[i] = array[i].toLowerCase();
			
		text = String.join("", array);

		text = new StringBuilder(text).reverse().toString();
		text = text.replaceAll("\\s+", " ").trim();
		
		list.add(text);

		return text;
	}
	
}
