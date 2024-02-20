package com.techlearners.blogapp.articles;

import com.techlearners.blogapp.articles.dtos.CreateArticleRequest;
import com.techlearners.blogapp.articles.dtos.UpdateArticleRequest;
import com.techlearners.blogapp.users.UserService;
import com.techlearners.blogapp.users.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {

    private ArticlesRepositroy articlesRepositroy;
    private UsersRepository usersRepository;



    public ArticlesService(ArticlesRepositroy articlesRepositroy, UsersRepository usersRepository) {
        this.articlesRepositroy = articlesRepositroy;
        this.usersRepository = usersRepository;
    }

    public Iterable<ArticleEntity> getAllArticles(){
        return articlesRepositroy.findAll();
    }

    public ArticleEntity getArticleBySlug(String slug){
        var article = articlesRepositroy.findBySlug(slug);
        if(article == null){
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }

    public ArticleEntity createArticle(CreateArticleRequest a, long authorId){
        var author = usersRepository.findById(authorId).orElseThrow(() -> new UserService.UserNotFoundException (authorId));
        return articlesRepositroy.save(ArticleEntity.builder()
                .title(a.getTitle())
                //TODO: create a proper sluggification function
                .slug(a.getTitle().toLowerCase().replaceAll("\\s+", "-"))
                .body(a.getBody())
                .subtitle(a.getSubtitle())
                .author(author)
                .build());
    }

    public ArticleEntity updateArticle(Long articleId, UpdateArticleRequest a){
        var article = articlesRepositroy.findById(articleId).orElseThrow(() -> new ArticleNotFoundException(articleId));

        if(a.getTitle() != null){
            article.setTitle(a.getTitle());
            article.setSlug((a.getTitle().toLowerCase().replaceAll("\\s+", "-")));
        }
        if(a.getBody() != null){
            article.setBody(a.getBody());
        }
        if(a.getSubtitle() != null){
            article.setSubtitle((a.getSubtitle()));
        }
        return  articlesRepositroy.save(article);
    }




    static class ArticleNotFoundException extends IllegalArgumentException {
        public ArticleNotFoundException(String slug) {
            super("User " + slug + " not found");
        }

        public ArticleNotFoundException(Long id) {
            super("User with id: " + id + " not found");
        }
    }
}
