package com.ll.jpa1209.domain.article.articleCommnet.entity;
//11강, 파트 1, 3부
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.member.member.entity.Member;
import com.ll.jpa1209.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity{
    @ManyToOne(fetch = LAZY)
    private Article article;
    @ManyToOne(fetch = LAZY)
    private Member author;
    private String body;

}
