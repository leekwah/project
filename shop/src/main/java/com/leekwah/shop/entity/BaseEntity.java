package com.leekwah.shop.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Data
public abstract class BaseEntity extends BaseTimeEntity {

    @CreatedBy // 누가 작성했는지
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy // 누가 수정했는지
    private String modifiedBy;

}
