package com.tanvirsingh.essentiallinuxguide;

/**
 * Created by kalol on 2/12/17.
 */

public class article_function {
    private String articleData;

    public article_function() {

    }

    public article_function(String articleData){
        this.articleData = articleData;
    }

    public String getArticleData() {
        return articleData;
    }

    public void setTitle(String name) {
        this.articleData = name;
    }
}
