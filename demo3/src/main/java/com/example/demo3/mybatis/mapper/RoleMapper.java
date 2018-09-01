package com.example.demo3.mybatis.mapper;

import com.example.demo3.mybatis.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lanxinghua
 * @date 2018/09/01 17:43
 * @description
 */

@Mapper
@Repository
public interface RoleMapper {
    @Insert("insert into role(id,describtions,name) values (#{id},#{describtions},#{name})")
    void insert(Role role);

    @Delete("delete from role where id = #{id}")
    void deleteById(@Param("id") String id);

    @Update("update role set name=#{name},describtions=#{describtions} where id=#{id}")
    void update(Role role);

    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id = #{id}")
    Role findById(@Param("id") String id);
}