package com.ll.jpa1209.domain.article.articleCommnet.repository;
//13강, OneToMany 필드 없이도 똑같은 일을 할 수 있습니다.
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long>{
    Optional<ArticleComment> findFirstByOrderByIdDesc();

    Optional<ArticleComment> findFirstByArticleIdOrderByIdDesc(long id);


}
