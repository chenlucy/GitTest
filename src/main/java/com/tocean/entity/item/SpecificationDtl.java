package com.tocean.entity.item;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tocean.base.baseObject.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "item_specification_dtl")
public class SpecificationDtl extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UUID", unique = true, nullable = false, length = 44)
    private String uuid;

    @NotEmpty
    @Length(max = 200)
    @Column(name = "NAME", length = 200,nullable = false)
    private String name;

    @Length(max = 200)
    @Column(name = "IMAGE", length = 200)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="S_UUID",nullable = false)
    private Specification specification;

    @ManyToMany(mappedBy = "specificationDtls", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

}
