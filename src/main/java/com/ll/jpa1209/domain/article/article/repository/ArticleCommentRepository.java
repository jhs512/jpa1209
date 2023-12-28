package com.ll.jpa1209.domain.article.article.repository;

import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long>{
    List<ArticleComment> findByAuthorId(long authorId);

}
