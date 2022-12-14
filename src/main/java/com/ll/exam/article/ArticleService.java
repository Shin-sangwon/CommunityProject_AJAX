package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {

    ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body){
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public void delete(long id){
        articleRepository.delete(id);
    }

    public void modify(Rq rq, long id) {
        articleRepository.modify(rq, id);
    }

    public List<ArticleDto> findAllIdGreaterThan(long fromId) {
        return articleRepository.findAllIdGreaterThan(fromId);
    }
}
