package com.tocean.entity.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tocean.base.baseObject.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/9/8.
 */
@Entity
@Data
@Table(name = "item_parameter_dtl")
public class ParameterDtl extends BaseEntity{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty
    @Column(name="UUID",unique =true,nullable = false,length = 44)
    private String uuid;

    @JsonProperty
    @NotEmpty
    @Length(max = 200)
    @Column(name="NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARAMETER_UUID",nullable = false)
    private Parameter parameter;
}
