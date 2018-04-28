package com.shenshanlaoyuan.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.shenshanlaoyuan.repository.GirlRepository;
import com.shenshanlaoyuan.domain.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by shenshanlaoyuan on 2018/4/27.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 获取女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return  girlRepository.findAll();
    }


    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping("/girls")
    public Girl addGirl(@Valid Girl girl , BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        return girlRepository.save(girl);
    }

    /**
     * 获取一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 年龄获取女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 更新女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value  = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }
}
