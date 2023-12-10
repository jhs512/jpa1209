package com.ll.jpa1209.domain.article.article.entity;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현

import com.ll.jpa1209.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.member.member.entity.Member;
import jakarta.persistence.ManyToOne;
// 8강, @ManyToOne(fetch = LAZY) 를 통해서 데이터를 필요한 만큼만 FETCH. 추가로 필요한 데이터가 있으면 자동 FETCH
import static jakarta.persistence.FetchType.LAZY;
//9강, 모든 엔티티가 가져야할 공통 속성을 모아두는 클래스 BaseEntity 도입
import com.ll.jpa1209.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.experimental.SuperBuilder;
@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Article extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member author;
    private String title;


}
