package com.example.validator.entity;

import com.example.MyUserConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private long id;

    @NotNull(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度为5~20个字符")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "最小18岁")
    @Max(value = 60, message = "最大60岁")
    private Integer age;

    @Email(message = "请输入邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @MyUserConstraint
    private String city;

}
