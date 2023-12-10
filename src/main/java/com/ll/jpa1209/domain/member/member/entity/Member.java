package com.ll.jpa1209.domain.member.member.entity;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
//9강, 모든 엔티티가 가져야할 공통 속성을 모아두는 클래스 BaseEntity 도입
import com.ll.jpa1209.global.jpa.baseEntity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
// 10강, 파트 1, 2부
import java.time.LocalDateTime;

@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access =PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Member extends BaseEntity {

    private String username;
    private String password;



}
