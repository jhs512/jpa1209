package com.ll.jpa1209.domain.member.member.service;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.domain.member.member.repository.MemberRepository;
import com.ll.jpa1209.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//23 11 28, p 13200, 5강, 파트 1, 1부
import java.util.Optional;
// 10강, 파트 1, 2부
import java.time.LocalDateTime;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password) {
        Member member = Member.builder()

                .modifyDate(LocalDateTime.now())
                .username(username)
                .password(password)
                .build();

        memberRepository.save(member);

        return RsData.of("200", "%s님 가입을 환영합니다.".formatted(username), member);
    }
    public Optional<Member> findById(long id){
        return memberRepository.findById(id);
    }
    public long count(){
        return memberRepository.count();
    }

}
