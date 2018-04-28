package com.shenshanlaoyuan.repository;

import com.shenshanlaoyuan.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shenshanlaoyuan on 2018/4/27.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    public List<Girl> findByAge(Integer age);
}
