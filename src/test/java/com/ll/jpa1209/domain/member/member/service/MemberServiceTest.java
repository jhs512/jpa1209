package com.ll.jpa1209.domain.member.member.service;
//23 11 27, p 13200, 3강, memberService.join, 2부, 테스트케이스 추가
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
//12강, 파트 1, 4부
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
// 21강, 파트 2, 게시물 리스트 출력시, 각 아이템의 댓글 수도 출력, 여기서 N + 1 문제가 발생
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @DisplayName("회원가입")
    @Test
    void t1() {
        RsData<Member> joinRs = memberService.join("usernew","1234");
        Member member = joinRs.getData();

        assertThat(member.getId()).isGreaterThan(0L);
    }
    @DisplayName("2번 글에 댓글들을 추가한다.")
    @Test
    void t5() {
        Member member1 = memberService.findById(1L).get();
        Article article2 = articleService.findById(2L).get();

        article2.addComment(member1, "댓글3");

    }
    @DisplayName("1번 글의 댓글 중 마지막 것을 삭제한다.")
    @Test
    void t6() {
        Article article = articleService.findById(1L).get();
        ArticleComment lastComment = article.getComments().getLast();
        article.removeComment(lastComment);
    }

}
