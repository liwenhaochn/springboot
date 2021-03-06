package com.example.jdbctemplate;

import com.example.jdbctemplate.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Rollback(true)
@Transactional
class JdbcTemplateApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;


    /*
    * 写在这里保证执行顺序
    *
    * */
    @Test
    void contextLoads() {
        dropTest();
        createTest();
        saveTest();
        System.out.println("--queryTest--");
        queryTest();
        System.out.println("--queryAllTest--");
        queryAllTest();
        updateTest();
        System.out.println("--updateTest--");
        queryAllTest();
        deleteTest();
        System.out.println("--deleteTest--");
        queryAllTest();
    }

    public void dropTest(){
        // 这里存在时才drop
        String sql = "drop table if exists jdbcTemplate";
        jdbcTemplate.execute(sql);

    }


    public void createTest(){
        String sql = "CREATE TABLE `jdbcTemplate` ( `id` varchar(6) not null, `name` varchar(20) not null, `age` int(3) " +
                "not null)";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }


    public void saveTest(){
        String sql = "insert into jdbcTemplate (id,name,age) values ('990001','lidanhua','39')";
        String sql1 = "insert into jdbcTemplate (id,name,age) values ('990002','liwenting','37')";
        jdbcTemplate.update(sql);
        jdbcTemplate.update(sql1);
    }

    public void queryAllTest(){
        String sql = "select * from jdbcTemplate";
        List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class));
        for(Person person: personList){
            System.out.println(person);
        }
    }

    public void queryTest(){
        String sql = "select * from jdbcTemplate where id=?";
        List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), "990002");
        for(Person person: personList){
            System.out.println(person);
        }
    }

    public void updateTest(){
        String sql = "update jdbcTemplate set name=? where id=?";
        jdbcTemplate.update(sql, "danhua", "990001");
    }

    public void deleteTest(){
        String sql = "delete from jdbcTemplate where id = ?";
        jdbcTemplate.update(sql,"990002");
    }
}
