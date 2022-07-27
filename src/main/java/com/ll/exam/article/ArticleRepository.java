package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private static long lastId;
    private static List<ArticleDto> data;

    static {
        data = new ArrayList<>();
        lastId = 0;
    }

    public long write(String title, String body){
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        data.add(newArticleDto);

        return id;
    }

    public List<ArticleDto> findAll() {
        return data;
    }

    public ArticleDto findById(long id) {
        for(var articleDto : data) {
            if(articleDto.getId() == id){
                return articleDto;
            }
        }

        return null;
    }

    public void delete(long id) {

        ArticleDto articleDto = findById(id);

        if(articleDto == null) return;

        data.remove(articleDto);

    }

    public void modify(Rq rq, long id) {
        ArticleDto articleDto = findById(id);

        if(articleDto == null) return;

        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        articleDto.setTitle(title);
        articleDto.setBody(body);
    }
}
