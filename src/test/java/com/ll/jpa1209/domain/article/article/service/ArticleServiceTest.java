package com.ll.jpa1209.domain.article.article.service;
//23 11 27, p 13200, 3강, memberService.join, 2부, 테스트케이스 추가

import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.domain.member.member.service.MemberService;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @DisplayName("글쓰기")
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1,"제목", "내용");
        Article article = writeRs.getData();
        assertThat(article.getId()).isGreaterThan(0L);
    }
    void t2(){
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();
        assertThat(author.getUsername()).isEqualTo("user1");
    }
}
