package com.example.jpa.service;

import com.example.jpa.entity.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> getArticleList();

    public Article findArticleById(long id);
}
