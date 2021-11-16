package com.example.jpaonetomany.repository;

import com.example.jpaonetomany.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ManagerRepo extends JpaRepository<Manager, Long> {

    Manager findManagerById(long id);

    /**
     * add by lwh 20211116 这里不添加事务删除时报错如下：
     * No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
     *
     * @param id
     */
    @Transactional
    void deleteManagerById(long id);
}
