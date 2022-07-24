package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq){
        List<ArticleDto> articleDtoList = new ArrayList<>();

        articleDtoList.add(new ArticleDto(3, "제목 3", "내용 3"));
        articleDtoList.add(new ArticleDto(2, "제목 2", "내용 2"));
        articleDtoList.add(new ArticleDto(1, "제목 1", "내용 1"));

        rq.setAttr("articles", articleDtoList);

        rq.view("usr/article/list");

    }
}
