package com.tocean.entity.item;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Data
@Table(name = "item_tag")
public class Tag extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UUID", unique = true, nullable = false, length = 44)
    private String uuid;

    @NotEmpty
    @Length(max = 255)
    @Column(name = "NAME",nullable = false)
    private String name;

//    @NotNull(groups = { BaseEntity.Save.class })
    @Column(name = "TYPE", nullable = false)
    private indexType type;

    @Length(max=255)
    @Column(name = "ICON")
    private String icon;

    @Length(max=255)
    @Column(name = "MEMO")
    private String memo;

    @Column(name = "ISSYSTEM")
    private Boolean isSystem;

    @Column(name = "ISUSEED")
    private Boolean isUseed;

    @Column(name = "MODELID")
    private String modelId;

//    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
//    private Set<Article> articles = new HashSet<Article>();

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

    /**
     * @author alan.yan
     *         article 文章
     *         product 产品
     */
    public enum indexType {
        index, ecIndex, microIndex;
    }

//    @PreRemove
//    public void preRemove() {
//        Set<Article> _set1 = getArticles();
//        if (_set1 != null) {
//            Iterator<Article> _iterator = _set1.iterator();
//            while (_iterator.hasNext()) {
//                Article _article = _iterator.next();
//                _article.getTags().remove(this);
//            }
//        }
//
//        Set<Product> _set2 = getProducts();
//        if (_set2 != null) {
//            Iterator<Product> _iterator = _set2.iterator();
//            while (_iterator.hasNext()) {
//                Product _product = _iterator.next();
//                _product.getTags().remove(this);
//            }
//        }
//    }
}