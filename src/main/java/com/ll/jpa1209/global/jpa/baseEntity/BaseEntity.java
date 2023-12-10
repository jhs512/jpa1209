package com.ll.jpa1209.global.jpa.baseEntity;
//9강, 모든 엔티티가 가져야할 공통 속성을 모아두는 클래스 BaseEntity 도입
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
// 10강, 파트 1, 2부
import java.time.LocalDateTime;
// 10강, 파트 1, 2부
import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// 10강, 파트 1, 2부
import lombok.*;
// 10강, 파트 1, 2부
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //@CreatedDate , @LastModifiedDate를 사용하기 위해 필요
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    @Setter
    private LocalDateTime modifyDate;
}
