package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superpoet.domain.Employee;
import com.superpoet.service.EmployeeService;
import com.superpoet.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author Superpoet
* @description 针对表【employee(员工信息)】的数据库操作Service实现
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




