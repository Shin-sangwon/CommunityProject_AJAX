<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>게시물 수정</h1>

<script>
    function ArticleModify__submitForm(form){
        form.title.value = form.title.value.trim();
        form.body.value = form.body.value.trim();

        if(form.title.value.length == 0){
            alert('제목을 입력해주세요.');
            form.title.focus();
            return;
        }

        if(form.body.value.length == 0){
            alert('내용을 입력해주세요.');
            form.title.focus();
            return;
        }

        form.submit();
    }

</script>

<form method = "POST" onsubmit="ArticleModify__submitForm(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="100" placeholder="수정할 제목을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="300" placeholder="수정할 내용을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>전송</span>
        <div>
            <input type="submit" value ="수정" />
        </div>
    </div>

</form>