package com.ll.jpa1209.domain.article.article.entity;

//23 11 27, p 13200, 3강, memberService.join, 1부, 구현

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
//23 11 28, p 13200, 5강, 파트 1, 1부
import com.ll.jpa1209.domain.member.member.entity.Member;
import jakarta.persistence.ManyToOne;


@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    private Member author;
    private String title;
    private String body;

}
