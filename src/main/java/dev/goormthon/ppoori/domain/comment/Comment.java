package dev.goormthon.ppoori.domain.comment;

import dev.goormthon.ppoori.domain.policy.Policy;
import dev.goormthon.ppoori.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@NoArgsConstructor @Getter
@Entity
public class Comment extends BaseTimeEntity {

    // 몇 시간 전 이거 구현할 수 있을듯!
    // dto 넘겨줄 때 시간 계산해서 넘겨주면 되겠다!
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "policy_id")
    private Policy policy;

    private String writer;
    private String content;

    @Builder
    public Comment(Policy policy, String content) {
        this.policy = policy;
        this.writer = "어피치" + ((int)(Math.random() * 9000) + 1000);
        this.content = content;
    }
}
