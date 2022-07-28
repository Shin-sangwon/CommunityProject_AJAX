import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.Util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void assertJ__assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    void ObjectMapper__objToJsonStr() {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");

        String jsonStr = Util.json.toStr(articleDto, "");
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim());
    }

    @Test
    void ObjectMapper__jsonStrToObj() {
        ArticleDto articleDtoOrigin = new ArticleDto(1, "제목", "내용");
        String jsonStr = Util.json.toStr(articleDtoOrigin, "");

        ArticleDto articleDtoFromJson = Util.json.toObj(jsonStr, ArticleDto.class, null);

        assertThat(articleDtoOrigin).isEqualTo(articleDtoFromJson);
    }

    @Test
    void ObjectMapper__listToJson() {
        List<ArticleDto> dtoList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            dtoList.add(new ArticleDto(i, "제목"+i, "내용+i"));
            sb.append(Util.json.toStr(dtoList.get(i), ""));
        }

        System.out.println(sb);
    }
}