package com.superpoet.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.superpoet.domain.Employee;
import com.superpoet.service.EmployeeService;
import com.superpoet.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){//注意属性名   接收的对象一般要单独一个类呀 都是Json数据了，不能直接一一对应了

        //1
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));

        //2.
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(lqw);//id有unique索引所以可以用getone


        if(emp==null){
            return  R.error("用户未注册");
        }

        if (!emp.getPassword().equals(password)){
            return R.error("密码错误");
        }

        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);



    }

    //员工退出
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前员工登录的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }



    @PostMapping
    public R<String> add(HttpServletRequest request, @RequestBody/*这个注解把json转为对象封装*/ Employee employee){
        /*用string因为前端只需要返回一个code验证是否成功*/
        log.info("新增员工，员工信息：{}",employee.toString());
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

       /* employee.setCreateTime(LocalDateTime.now());//时间直接从类里获取
        employee.setUpdateTime(LocalDateTime.now());

        employee.setCreateUser((Long) request.getSession().getAttribute("employee"));//需要从session里获取，
        employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));*/

        employeeService.save(employee);

        return R.success("新增员工成功");
    }


    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page page1 = new Page(page,pageSize);

        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();

        lqw.like(!Strings.isEmpty(name),Employee::getName,name);

        lqw.orderByDesc(Employee::getUpdateTime);

        employeeService.page(page1,lqw);

        return R.success(page1);


    }

    /**
     * 更新
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee){
        log.info(employee.toString());
        Long empld =(Long) request.getSession().getAttribute("employee");
        /*employee.setUpdateUser(empld);
        employee.setUpdateTime(LocalDateTime.now());*/
        employeeService.updateById(employee);

        return R.success("员工信息修改成功");

    }

    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable String id){//这个是路径里含着参数，从路径里分割参数

        Employee byId = employeeService.getById(id);
        if(byId!=null){
            return R.success(byId);
        }
        return R.error("没有查询到用户信息");
    }


}
