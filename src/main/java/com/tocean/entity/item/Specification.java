package com.tocean.entity.item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.tocean.base.baseObject.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "item_specification")
public class Specification extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UUID", unique = true, nullable = false, length = 44)
    private String uuid;

    @NotEmpty
    @Length(max = 200)
    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @NotNull
    @Column(name = "TYPE", precision = 8, scale = 2, nullable = false)
    private Specification.Type type;

    @Length(max = 200)
    @Column(name = "MEMO", length = 200)
    private String memo;

    @Valid
    @NotEmpty
    @OneToMany(mappedBy = "specification", fetch = FetchType.LAZY, cascade = {javax.persistence.CascadeType.ALL}, orphanRemoval = true)
    @OrderBy("orders asc")
    private List<SpecificationDtl> specificationDtls = new ArrayList<SpecificationDtl>();

    @ManyToMany(mappedBy = "specifications", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

    public enum Type {
        text, image;
    }
}
