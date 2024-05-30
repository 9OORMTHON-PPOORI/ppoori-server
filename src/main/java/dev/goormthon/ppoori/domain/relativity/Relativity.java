package dev.goormthon.ppoori.domain.relativity;

import dev.goormthon.ppoori.global.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@Getter @Entity
public class Relativity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "pk")
    private Long pk;
    private Long policyId;  // 정책 아이디

    @Enumerated(EnumType.STRING)
    private Category category;  // 카테고리

    private float rate_student;  // 대학생
    private float rate_jobseeker;  // 취준생
    private float rate_worker;  // 재직자
    private float rate_newlyweds;  // 신혼부부
    private float rate_industry;  // 농업 및 어업인
    private float rate_artist;  // 예술가
}
