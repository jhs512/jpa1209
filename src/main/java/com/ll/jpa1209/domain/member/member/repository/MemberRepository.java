package com.ll.jpa1209.domain.member.member.repository;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import com.ll.jpa1209.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
