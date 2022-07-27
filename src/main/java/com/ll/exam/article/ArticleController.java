package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;


import java.util.ArrayList;
import java.util.List;

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {
       articleService = new ArticleService();
    }

    public void showList(Rq rq){
        List<ArticleDto> articleDtoList = articleService.findAll();

        rq.setAttr("articles", articleDtoList);

        rq.view("usr/article/list");

    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq){
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);

        rq.appendBody("%d번 게시물이 생성 되었습니다.".formatted(id));
        rq.appendBody("<div><a href=\"/usr/article/list/free\">목록으로 돌아가기</a></div>");
        rq.appendBody("<div><a href=\"/usr/article/write/free\">또 작성하기</a></div>");
    }

    public void showDetail(Rq rq){
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("/usr/article/detail");
    }

    public void doDelete(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if(id == 0){
            rq.appendBody("알맞은 번호를 입력 해 주세요");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if(articleDto == null){
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        articleService.delete(id);

        rq.appendBody("삭제가 완료되었습니다.");
        rq.appendBody("<div><a href=\"/usr/article/list/free\">목록으로 돌아가기</a></div>");
    }

    public void showModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("usr/article/modify");
    }

    public void doModify(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        articleService.modify(rq, id);

        rq.appendBody("%d번 게시물이 수정되었습니다.".formatted(id));
        rq.appendBody("<div><a href=\"/usr/article/detail/free/%d\">수정된 글로 이동</a></div>".formatted(id));
        rq.appendBody("<div><a href=\"/usr/article/list/free\">목록으로 돌아가기</a></div>");

    }
}
