package com.ll.jpa1209.domain.article.articleCommnet.service;
//13강, OneToMany 필드 없이도 똑같은 일을 할 수 있습니다.
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import com.ll.jpa1209.domain.article.articleCommnet.repository.ArticleCommentRepository;
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;
    public RsData<ArticleComment> write(Member author, Article article, String body){
        ArticleComment articleComment = ArticleComment.builder()
                .author(author)
                .article(article)
                .body(body)
                .build();

        articleCommentRepository.save(articleComment);
        return RsData.of("200","%d번 댓글이 작성되었습니다.".formatted(articleComment.getId()),articleComment);
    }
    public Optional<ArticleComment> findLatest(){
        return articleCommentRepository.findFirstByOrderByIdDesc();
    }
    @Transactional
    public void modify(ArticleComment comment, String body){
        comment.setBody(body);
    }
    public Optional<ArticleComment> findFirstByArticleIdORderByIdDesc(long l){
        return articleCommentRepository.findFirstByArticleIdOrderByIdDesc(l);
    }
    public void delete(ArticleComment comment){
        articleCommentRepository.delete(comment);
    }

}
