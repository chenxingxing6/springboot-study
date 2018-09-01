//package com.example.demo3.jpa;
//
//import com.alibaba.fastjson.JSON;
//import com.example.demo3.jpa.dao.RoleDao;
//import com.example.demo3.jpa.entity.Role;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class jpaTest {
//    @Resource
//    private RoleDao roleDao;
//
//    @Test
//    public void testInsert() {
//        Role role = new Role();
//        role.setName("cxx");
//        role.setDesc("desc");
//        Role save = roleDao.save(role);
//        System.out.println(JSON.toJSONString(save));
//    }
//
//    @Test
//    public void testUpdate(){
//        Role role = new Role();
//        role.setId(1);
//        role.setName("cxx");
//        role.setDesc("desc");
//        roleDao.save(role);
//    }
//
//    @Test
//    public void testDelete(){
//        roleDao.deleteById(1);
//    }
//
//    @Test
//    public void testSelect(){
//        Role role = new Role();
//        role.setName("cxx");
//        List<Role> all = roleDao.findAll(Example.of(role),new Sort(new Sort.Order(Sort.Direction.ASC,"id")));
//    }
//}
