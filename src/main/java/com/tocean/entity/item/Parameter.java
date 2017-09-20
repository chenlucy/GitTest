package com.tocean.entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */
@Entity
@Data
@Table(name="item_parameter")
public class Parameter extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty
    @Column(name="UUID",unique = true,nullable = false,length = 44)
    private String uuid;

    @JsonProperty
    @NotEmpty
    @Length(max = 255)
    @Column(name = "NAME")
    private String Name;


//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CATEGORY", nullable = false)
//    private Category category;

    @JsonProperty
    @Valid
    @NotEmpty
    @OneToMany(mappedBy = "parameter", fetch = FetchType.LAZY, cascade = {javax.persistence.CascadeType.ALL}, orphanRemoval = true)
    @OrderBy("orders asc")
    private List<ParameterDtl> parameterDtls = new ArrayList<ParameterDtl>();
}
