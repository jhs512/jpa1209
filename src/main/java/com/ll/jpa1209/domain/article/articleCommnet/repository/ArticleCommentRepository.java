package com.ll.jpa1209.domain.article.articleCommnet.repository;

//30강, 1번 회원이 작성한 댓글 찾기, ArticleComment 에 author 필드가 있으니 쉽다.
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    List<ArticleComment> findByAuthorId(long Id);
}
