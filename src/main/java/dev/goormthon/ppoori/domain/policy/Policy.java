package dev.goormthon.ppoori.domain.policy;

import dev.goormthon.ppoori.domain.comment.Comment;
import dev.goormthon.ppoori.global.common.BaseTimeEntity;
import dev.goormthon.ppoori.global.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor @Getter
@Entity
public class Policy {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "policy_id")
    private Long id;

    private String name;  // 정책명
    private String title;  // 제목
    private String subject;  // 지원 대상
    private String detail;  // 지원 내용
    private String summary;  // AI 요약
    private String department;  // 부서
    private String contact;  // 문의처

    @Enumerated(EnumType.STRING)
    private Category category;  // 카테고리

    @Column(columnDefinition = "integer default 0")
    private int hateRate = 0;  // 관심 없어요

    @Column(columnDefinition = "integer default 0")
    private int likeRate = 0;  // 맘에 들어요

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public void plusHateRate() {
        this.hateRate += 1;
    }

    public void minusHateRate() {
        this.hateRate -= 1;
    }

    public void plusLikeRate() {
        this.likeRate += 1;
    }

    public void minusLikeRate() {
        this.likeRate -= 1;
    }
}
