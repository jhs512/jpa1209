package com.ll.jpa1209.global.initData;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.domain.member.member.service.MemberService;
import com.ll.jpa1209.global.rsData.RsData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.article.article.service.ArticleService;
@Profile("!prod")
@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner initNotProdData(
            MemberService memberService,
            ArticleService articleService
    ) {
        return args -> {
            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();

            articleService.write(member1.getId(), "제목1", "내용1");
            articleService.write(member1.getId(), "제목2", "내용2");

            articleService.write(member2.getId(), "제목3", "내용3");
            articleService.write(member2.getId(), "제목4", "내용4");
        };
    }
}
