package com.springboot.spring_boot_course.controller;


import com.springboot.spring_boot_course.entity.Employee;
import com.springboot.spring_boot_course.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//используем такую аннотацию
@RestController
@RequestMapping("/api")
public class MyRestController {
    //контроллер работает с интерфейсом
    @Autowired
    private EmployeeService employeeService;
    //метод для получения списка работников
    @GetMapping("employees")
    public List<Employee> showListEmployee(){
        //простое получения списка работников
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }
    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        // получение одного
        Employee employee = employeeService.getEmployee(id);
        //проверка
//        if(employee == null){
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DataBase");
//        }
        return employee;

    }

    //добавление нового работника
    @PostMapping("employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    //изменение существующего работника
    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    //удаление работника
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
           // проверка по наличию такого работника
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);

        return "Employee = " + id + " was deleted";
    }





}
