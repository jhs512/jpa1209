package com.ll.jpa1209.domain.article.articleTag.repository;

//31강, 1번 회원이 게시물에 추가한 태그 찾기, findByArticle_authorId 도입
import com.ll.jpa1209.domain.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long>{
    List<ArticleTag> findArticle_authorId(long authorId);

}
