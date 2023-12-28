package com.ll.jpa1209.domain.article.articleTag.entity;
// 25강, 게시물 태그 추가
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;
//33강, 엔티티 클래스에 한번 정해지면 변하지 않는 필드들은 얼마든지 추가가능
import com.ll.jpa1209.domain.member.member.entity.Member;


@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class ArticleTag extends BaseEntity{
    @ManyToOne(fetch = LAZY)
    private Article article;
    @ManyToOne(fetch = LAZY)
    private Member author;
    private String content;

}
