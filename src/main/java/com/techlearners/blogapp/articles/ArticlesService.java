package com.techlearners.blogapp.articles;

import org.springframework.stereotype.Service;

@Service
public class ArticlesService {

    private ArticlesRepositroy articlesRepositroy;

    public ArticlesService(ArticlesRepositroy articlesRepositroy) {
        this.articlesRepositroy = articlesRepositroy;
    }
}
