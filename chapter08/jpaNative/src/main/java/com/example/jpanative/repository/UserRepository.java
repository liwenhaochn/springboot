package com.example.jpanative.repository;

import com.example.jpanative.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    /*
     * jpql的原生方式，这些查询不会替换User为表名，所以必须使用实际的表名
     * 也务必使用数据库中实际的字段名
     *
     * ***这是因为nativeQuery的属性决定的
     *
     * */
    @Query(value = "select * from jpaNative where id=:id", nativeQuery = true)
    User fetchUserById(String id);

    @Query(value = "select * from jpaNative", nativeQuery = true)
    List<User> fetchAll();

    @Query(value = "select * from jpaNative where name like ?1%",
            countQuery = "select count(*) from jpaNative where name = ?1",
            nativeQuery = true)
    Page<User> fetchUserPageByName(String name, Pageable pageable);

    /**
     *
     * 这里会替换User为实际的表名，字段名也会替换
     *
     * ***这是因为nativeQuery的属性决定的，默认为false
     *
     * @param name
     * @param age
     */
    @Modifying
    @Query("update User set age = :age where name = :name")
    void updateUserAgeByName(@Param("name") String name, @Param("age") int age);

    @Modifying
    @Query("delete from User where name = :name")
    void deleteByName(@Param("name") String name);

}
