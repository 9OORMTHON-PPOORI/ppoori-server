package dev.goormthon.jejucart.domain.policy;

import dev.goormthon.jejucart.domain.comment.Comment;
import dev.goormthon.jejucart.global.common.BaseTimeEntity;
import dev.goormthon.jejucart.global.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor @Getter
@Entity
public class Policy extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "policy_id")
    private Long id;

    private String name;  // 정책명
    private String title;  // 제목
    private String subject;  // 지원 대상
    private String detail;  // 지원 내용
    private String contact;  // 문의처
    private String target;  // 검색 타겟

    @Enumerated(EnumType.STRING)
    private Category category;  // 카테고리

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    private int hateRate;  // 관심 없어요
    private int likeRate;  // 맘에 들어요

    public void plusHateRate() {
        this.hateRate += 1;
        // return this.hateRate;
    }

    public void minusHateRate() {
        this.hateRate -= 1;
        // return this.hateRate;
    }

    public void plusLikeRate() {
        this.likeRate += 1;
        // return this.likeRate;
    }

    public void minusLikeRate() {
        this.likeRate -= 1;
        // return this.likeRate;
    }
}
