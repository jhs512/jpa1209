package com.ll.jpa1209.global.initData;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.article.article.repository.ArticleRepository;
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.domain.member.member.service.MemberService;
import com.ll.jpa1209.global.rsData.RsData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.article.article.service.ArticleService;
//11강, 파트 1, 3부
import com.ll.jpa1209.domain.article.article.entity.Article;
//11강, 파트 1, 3부
import org.springframework.boot.ApplicationArguments;
import org.springframework.transaction.annotation.Transactional;
//11강, 파트 1, 3부
import org.springframework.boot.ApplicationArguments;
import org.springframework.transaction.annotation.Transactional;
//12강, 파트 1, 4부
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
//13강, OneToMany 필드 없이도 똑같은 일을 할 수 있습니다.



@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private final MemberService memberService;
    private final ArticleService articleService;


    @Bean
    public ApplicationRunner initNotProdData(){
        return args -> {
            self.work1();

        };
    }
    @Transactional
    public void work1(){
        if (memberService.count() > 0 ) return;


        Member member1 = memberService.join("user1", "1234").getData();
        Member member2 = memberService.join("user2", "1234").getData();

        Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
        Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

        Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
        Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

        article1.addComment(member1,"댓글1");
        article1.addComment(member1,"댓글2");

        article2.addComment(member1,"댓글3");
        article2.addComment(member1,"댓글4");
        article2.addComment(member1,"댓글5");

        article1.addTag("자바");
        article1.addTag("백엔드");
        article2.addTag("프레임워크");
        article2.addTag("스프링부트");
        article2.addTag("프레임워크","스프링부트");



    }

}
