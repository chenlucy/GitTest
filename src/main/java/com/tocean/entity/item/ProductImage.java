package com.tocean.entity.item;

import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/9/8.
 */
@Entity
@Data
@Table(name = "item_product_image")
public class ProductImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UUID",unique = true,nullable = false,length = 44)
    private String uuid;

    @Length(max = 255)
    @Column(name = "TITLE")
    private String title;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "LARGE")
    private String large;

    @Column(name = "MEDIUM")
    private String medium;

    @Column(name = "SMALL")
    private String small;

    @Min(0L)
    @Column(name = "ORDERS", precision = 8)
    private Integer orders;

    @Transient
    private MultipartFile file;

//    @Transient
//    public boolean isEmpty() {
//        boolean b=	(
//                (getFile() == null) ||
//                        (getFile().isEmpty())
//        )
//                &&
//                (
//                        (StringUtils.isEmpty(getISource())) ||
//                                (StringUtils.isEmpty(getILarge()))||
//                                (StringUtils.isEmpty(getIMedium())) ||
//                                (StringUtils.isEmpty(getISmall()))
//                );
//        return b;
//    }

    public int compareTo(ProductImage productImage) {
        return new CompareToBuilder().append(getOrders(),productImage.getOrders()).toComparison();
    }
}
