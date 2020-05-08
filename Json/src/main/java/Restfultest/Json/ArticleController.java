package Restfultest.Json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Article> test() {
		List<Article> list = new ArrayList<Article>();
		
		for(int i=1; i<=10; i++){
			Article article = new Article();
			article.setSeq(1);
			article.setText("This is test");
			article.setTitle("This is Title");
			article.setWriter("I am writer");
			
			list.add(article);
		}
		
		return list;
	}
	
	@RequestMapping(value = "article/{seq}", method = RequestMethod.GET)
	public Article detail(@PathVariable("seq") long seq){
		
		Article article = new Article();
		article.setSeq(seq);
		article.setText("This is test");
		article.setTitle("This is Title");
		article.setWriter("I am writer");
		
		return article;
	}

}
