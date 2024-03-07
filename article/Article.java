package article;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(exclude = {"id"})
public class Article {


    private int id;
    private String title;
    private String content;
    private String writer;


    @Builder(builderMethodName = "builder")
    public Article(int id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;

    }
}
