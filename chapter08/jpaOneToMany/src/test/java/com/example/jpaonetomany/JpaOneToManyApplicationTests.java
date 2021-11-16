package com.example.jpaonetomany;

import com.example.jpaonetomany.entity.Company;
import com.example.jpaonetomany.entity.Manager;
import com.example.jpaonetomany.repository.CompanyRepo;
import com.example.jpaonetomany.repository.ManagerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpaOneToManyApplicationTests {

    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ManagerRepo managerRepo;

    @Test
    @Rollback(true)
    void contextLoads() {
        add();
        find();
        deleteCompany();
        deleteManager();

    }

    void add() {
        Company company = new Company();
        company.setName("HUAWEI");
        companyRepo.save(company);
        Manager manager = new Manager();
        manager.setName("renzhengfei");
        manager.setCompany(company);
        managerRepo.save(manager);
        manager = new Manager();
        manager.setName("mengwanzhou");
        manager.setCompany(company);
        managerRepo.save(manager);
        manager = new Manager();
        manager.setName("zhu");
        managerRepo.save(manager);
    }

    void find() {
        Company company = companyRepo.findCompanyById(1);
        List<Manager> managerList = company.getManagerList();
        System.out.println(company.getName());
        for (Manager manager : managerList) {
            System.out.println(manager.getName());
        }
    }

    public void deleteCompany() {
        companyRepo.deleteCompanyById(1);
    }

    public void deleteManager() {
        managerRepo.deleteManagerById(3);
    }

}
