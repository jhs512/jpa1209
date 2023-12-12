package com.ll.jpa1209.domain.article.article.service;
//23 11 27, p 13200, 3강, memberService.join, 2부, 테스트케이스 추가

import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import com.ll.jpa1209.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.domain.member.member.service.MemberService;
// 10강, 파트 1, 2부
import com.ll.jpa1209.standard.util.Ut;
//13강, OneToMany 필드 없이도 똑같은 일을 할 수 있습니다.
import com.ll.jpa1209.domain.member.member.service.MemberService;

import java.util.List;

// 13강, OneToMany 필드 없이도 똑같은 일을 할 수 있습니다.


@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;

    @DisplayName("글쓰기")
    @Test
    void t1() {
        RsData<Article> writeRs = articleService.write(1,"제목", "내용");
        Article article = writeRs.getData();
        assertThat(article.getId()).isGreaterThan(0L);
    }
    @DisplayName("1번 글을 가져온다.")
    @Test
    void t2(){
       Article article = articleService.findById(1L).get();
       assertThat(article.getTitle()).isEqualTo("제목1");
    }
    @DisplayName("1번 글의 작성자의 username 은 user1 이다.")
    @Test
    void t3(){
        Article article = articleService.findById(1L).get();
        Member author = article.getAuthor();
    }
    @DisplayName("1번 글의 제목을 수정한다.")
    @Test
    void t4(){
        Article article = articleService.findById(1L).get();

        Ut.thread.sleep(1000);

        articleService.modify(article,"수정된 제목","수정된 내용");
        Article article_ = articleService.findById(1L).get();
        assertThat(article_.getTitle()).isEqualTo("수정된 제목");
    }
    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    void t5(){
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(2L).get();

        article2.addComment(member1,"댓글3");
    }
    @DisplayName("1번 글에 댓글들을 수정한다.")
    @Test
    void t6(){
        Article article1 = articleService.findById(1L).get();
        article1.getComments().getLast().setBody("수정된 댓글");

    }
    @DisplayName("1번 글의 댓글 중 마지막 것을 삭제한다.")
    @Test
    void t7(){
        Article article1 = articleService.findById(1L).get();

        ArticleComment lastComment = article1.getComments().getLast();
        article1.removeComment(lastComment);
    }
    @DisplayName("게시물 별 댓글 수 출력")
    @Test
    void t8(){
        List<Article> articles = articleService.findAll();

        articles.forEach(article ->{
            System.out.println("게시물번호:" + article.getId());
            System.out.println("댓글 수:" + article.getComments().size());

        });
    }

}
