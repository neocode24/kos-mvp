package com.kt.kafka_produce;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

  @RequestMapping("/test")
  public List<Article> test() {
    List<Article> list = new ArrayList<Article>();

    for(int i=1; i<=10; i++) {
            Article article = new Article();
            article.setSeq(i);
            article.setText("This is text");
            article.setTitle("This is title");
            article.setWriter("I am writer");             

            list.add(article);
    }
    return list;
  }

  @RequestMapping(value = "article/{seq}", method = RequestMethod.POST)
  public Article detail(@PathVariable("seq") long seq, @RequestBody Article data) {

        Article article = new Article();
        article.setSeq(seq);
        article.setText("This is text");
        article.setTitle("This is title");
        article.setWriter("I am writer");

    return article;
  }
}
