package com.newcoder.community.controller;

import com.newcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author shkstart
 * @creat 2022--05--15 17:07
 */
@Controller
@RequestMapping("/alpha")
//取一个类的访问名
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")  //使方法能被浏览器访问到
    @ResponseBody  //默认返回页面，加注解返回的字符串
    public String sayHello()
    {
        return "Hello SpringBoot";
    }

    @RequestMapping("/data")  //使方法能被浏览器访问到
    @ResponseBody
    public String getData()
    {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response)
    {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements())
        {
            String name = enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+";"+value);
        }
        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (            PrintWriter writer = response.getWriter();
        ){
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get请求
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name="current",required = false,defaultValue = "1") int current,
            @RequestParam(name="limit",required = false,defaultValue = "10")int limit)
    {
        System.out.println(current);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id)
    {
        System.out.println(id);
        return "a student";
    }

    //post
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age)
    {
        System.out.println(name);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","xver");
        modelAndView.addObject("age",30);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model)
    {
        model.addAttribute("name","QD");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    //响应json数据（异步请求）
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp()
    {
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","san");
        emp.put("age",23);
        emp.put("salary",800);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps()
    {
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","san");
        emp.put("age",23);
        emp.put("salary",800);
        list.add(emp);
        return list;
    }

}
