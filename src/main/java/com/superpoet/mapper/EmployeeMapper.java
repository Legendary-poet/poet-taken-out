package com.superpoet.mapper;

import com.superpoet.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Superpoet
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @Entity com.superpoet.domain.Employee
*/

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}




