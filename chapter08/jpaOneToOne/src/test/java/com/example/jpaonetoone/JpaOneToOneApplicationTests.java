package com.example.jpaonetoone;

import com.example.jpaonetoone.entity.Card;
import com.example.jpaonetoone.entity.Employee;
import com.example.jpaonetoone.repository.CardRepo;
import com.example.jpaonetoone.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaOneToOneApplicationTests {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CardRepo cardRepo;

    @Test
    void contextLoads() {
        Employee employee = new Employee();
        employee.setName("liwenhao");
        employee.setSex("male");
        Employee employee1 = new Employee();
        employee1.setName("chenyijun");
        employee1.setSex("female");

        Card card = new Card();
        card.setNum(910801);
        employee.setCard(card);
        /**
         * employee和card一起保存
         */
        employeeRepo.save(employee);
        /**
         * employee1单独保存
         */
        employeeRepo.save(employee1);
        Card card1 = new Card();
        card1.setNum(950802);
        /**
         * card1单独保存
         */
        cardRepo.save(card1);

        long id = employee.getId();
        /**
         * employee和card一起删除
         */
        employeeRepo.deleteById(id);

    }

}
