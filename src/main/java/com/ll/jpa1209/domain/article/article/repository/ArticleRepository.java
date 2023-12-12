package com.ll.jpa1209.domain.article.article.repository;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//21강, 파트 2, 게시물 리스트 출력시, 각 아이템의 댓글 수도 출력, 여기서 N + 1 문제가 발생
import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {
    List<Article> findByOrderByIdDesc();

}
