package com.example.demo3.mybatis;

import com.example.demo3.mybatis.entity.Role;
import com.example.demo3.mybatis.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author lanxinghua
 * @date 2018/09/01 17:55
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@MapperScan(basePackages = {"com.example.demo3"})
public class MybatisTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void insert(){
        Role role = new Role();
        role.setId(UUID.randomUUID().toString().replace("-","").substring(0,18));
        role.setName("4231");
        role.setDescribtions("748567328");
        roleMapper.insert(role);
    }

    @Test
    public void deleteById(){
        roleMapper.deleteById("9458609bedd245f292");
    }

    @Test
    public void update(){
        Role role = new Role();
        role.setId("9458609bedd245f292");
        role.setName("554352");
        role.setDescribtions("54235");
        roleMapper.update(role);
    }


    @Test
    public void findAll(){
        List<Role> all = roleMapper.findAll();
        System.out.println(all.size());
    }

    @Test
    public void findById(){
        Role byId = roleMapper.findById("0c6e3b90d6b54befaf");
        System.out.println(byId);
    }
}