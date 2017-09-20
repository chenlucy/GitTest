package com.tocean.entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/8.
 */
@Entity
@Data
@Table(name="item_review")
public class Review extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     *
     * positive 好评  moderate 中评 negative 差评
     *
     */
    public enum Type {
        positive, moderate, negative;
    }

    /**
     * 评价终端设备
     * @author alan.yan
     * web 主力网
     * microWeb 微商城
     * mobileApp 手机应用
     *
     */
    public enum fromType {
        web, microWeb, mobileApp;
    }

    /**
     *
     * admin 来自官方
     * member 来自个人
     *
     */
    public enum forType {
        member,admin;
    }

    @JsonProperty
    @Id
    @Column(name = "UUID", unique = true, nullable = false, length = 44)
    private String uuid;

    @JsonProperty
    @NotEmpty
    @Length(max = 200)
    @Column(name = "CONTENT", nullable = false, updatable = false)
    private String content;

    @Column(name = "IP", nullable = false, updatable = false)
    private String ip;

    @Column(name = "FROM_TYPE", nullable = false)
    private Review.fromType fromType;


    @JsonProperty
    @Column(name = "IS_SHOW", nullable = false)
    private Boolean isshow;

    @JsonProperty
    @NotNull
    @Min(1L)
    @Max(5L)
    @Column(name = "SSCORE", nullable = false, updatable = false)
    private Integer sscore;

    @JsonProperty
    @NotNull
    @Min(1L)
    @Max(5L)
    @Column(name = "LSCORE", nullable = false, updatable = false)
    private Integer lscore;

    @JsonProperty
    @NotNull
    @Min(1L)
    @Max(5L)
    @Column(name = "QSCORE", nullable = false, updatable = false)
    private Integer qscore;

    @JsonProperty
    @Min(1L)
    @Max(5L)
    @Column(name = "SCORE", nullable = false, updatable = false)
    private Integer score;

    @JsonProperty
    @Min(1L)
    @Max(5L)
    @Column(name = "USED_NUM", nullable = false)
    private Integer usedNum;

    @JsonProperty
    @Min(1L)
    @Max(5L)
    @Column(name = "NOT_USER_NUM", nullable = false)
    private Integer notUserNum;

    @Column(name = "FOR_TYPE", nullable = false)
    private Review.forType forType; //回复类型0其它用户回复1官方回复

    @Column(name = "FOR_UUID", updatable = false)
    private String forUuid; //评论回复对应的评论uuid

//    @OneToMany(mappedBy = "FOR_UUID",
//            fetch = FetchType.LAZY,
//            cascade = { javax.persistence.CascadeType.REMOVE })
//    @OrderBy("forType desc")
//    private Set<Review> replyReviews = new HashSet<Review>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = { javax.persistence.CascadeType.REMOVE })
    @JoinColumn(name = "P_UUID")
    private Product product; //商品




//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FORM_UUID")
//    private Member forMember; //回复用户的UUID,针对其它用户有效果
//
//    // ------------
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "MENBER_UUID")
//    private Member member;
}
