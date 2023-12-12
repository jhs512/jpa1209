package com.ll.jpa1209.domain.article.article.service;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.article.repository.ArticleRepository;
import com.ll.jpa1209.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//23 11 28, p 13200, 5강, 파트 1, 1부
import java.util.Optional;
import com.ll.jpa1209.domain.member.member.entity.Member;
// 10강, 파트 1, 2부
import java.time.LocalDateTime;
//12강, 파트 1, 4부
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(long authorId , String title, String body) {
        Article article = Article.builder()
                .modifyDate(LocalDateTime.now())
                .author(Member.builder().id(authorId).build())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%d번 게시글이 작성되었습니다.".formatted(article.getId()), article);
    }
    public Optional<Article> findById(long id){
        return articleRepository.findById(id);
    }
    @Transactional
    public void modify(Article article, String title , String body){
        article.setTitle(title);
        article.setBody(body);
    }

}
