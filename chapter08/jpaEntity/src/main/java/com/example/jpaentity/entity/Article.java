package com.example.jpaentity.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Table(name = "jpaEntity")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * 标题
    * */
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    /*
    * 类型
    *
    * 遇到问题：Column 'type' has duplicated value '?' in ENUM
    *
    * 网上说需要设置UTF8，yaml配置了但是还是失败
    * 暂时修改为英文
    * */
    @Column(columnDefinition = "enum('image','words')")
    private String type;

    /*
    * 可读
    * */
    private Boolean available = Boolean.TRUE;

    /*
    * 关键字
    * */
    @Size(min = 0, max = 20)
    private String keyword;

    /*
    * 描述
    * */
    @Size(max = 25)
    private String description;

    /*
    * 正文
    * */
    @Column(nullable = false)
    private String body;

    /*
    * 虚拟字段
    * */
    @Transient
    private List keywordlist;

    public List getKeywordlist() {
        return Arrays.asList(keyword.trim().split("|"));
    }

    public void setKeywordlist(List keywordlist) {
        this.keywordlist = keywordlist;
    }
}
