package com.myth.springboot.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Dept;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.Teacher;
import com.myth.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("admin")
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;
    /**
     *院系业务
     */
    @RequestMapping("/deptAdd")
    @ResponseBody
    public Msg deptAdd(String name){
        List<Dept> depts = deptService.deptSelect(new Dept());
        for (Dept dept:depts){
            if (dept.getD_name().equals(name)){
                return Msg.success().add("msg","已有该部们");
            }
        }

        Dept dept1 = new Dept();
        dept1.setD_name(name);
        int i = deptService.classInsert(dept1);
        if (i>0){
            return Msg.success().add("msg","添加成功");
        }else {
            return Msg.success().add("msg","添加失败");
        }


    }
    //得到部门信息
    @RequestMapping("/deptList")
    @ResponseBody
    public Msg deptList(){
        List<Dept> depts = deptService.deptSelect(new Dept());
        return Msg.success().add("dept",depts);
    }

    @RequestMapping("/deptListWithPage")
    @ResponseBody
    public Map deptListWithPage(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,10);
        List<Dept> depts = deptService.deptSelect(new Dept());
        PageInfo pageInfo = new PageInfo(depts,5);
        Map<String,Object> map= new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
    @RequestMapping("/deptGetById")
    @ResponseBody
    public ModelAndView deptGetById(String id){
        ModelAndView mv = new ModelAndView("dept/dept-update");
        Dept dept = new Dept();
        dept.setD_id(Integer.valueOf(id).intValue());
        List<Dept> depts = deptService.deptSelect(dept);
        mv.addObject("dept",depts.get(0));
        return mv;
    }

    @RequestMapping("/deptUpdate")
    @ResponseBody
    public Msg deptUpdate(String id,String name){

        List<Dept> depts = deptService.deptSelect(new Dept());
        for (Dept dept:depts){
            if (dept.getD_name().equals(name)){
                return Msg.success().add("msg","已有该部们");
            }
        }
        System.out.println(id+name);
        Dept dept = new Dept(Integer.valueOf(id).intValue(),name);
        int i = deptService.deptUpdateById(dept);
        if (i>0){
            return Msg.success().add("msg","部门信息修改成功！");
        }else {
            return Msg.fail().add("msg","出错了，老弟！");
        }
    }
    @RequestMapping("/deptDelete")
    @ResponseBody
    public Msg deptDelete(String id){
        Dept dept_id = new Dept(Integer.valueOf(id).intValue());
        Class cla = new Class(id);

        if (classService.classSelect(cla).isEmpty()){
            Teacher teacher = new Teacher();
            teacher.setDept_id(id);
            List<Teacher> teachers = teacherService.teacherSelect(teacher);
            if (teachers.isEmpty()){
                int i = deptService.deptDeleteById(dept_id);
                if (i>0){
                    return Msg.success().add("msg","删除成功,老弟！");
                }else {
                    return Msg.success().add("msg","出错了，无法删除！");
                }
            }else {
                return Msg.success().add("msg","存在教师关联，无法删除！");
            }
        }else {
            return Msg.success().add("msg","存在班级关联，无法删除！");
        }
    }

    @RequestMapping("/deptDeleteMany")
    @ResponseBody
    public Msg deptDeleteMany(String id){
        System.out.println(id);
        String str[] = id.split(",");

        String s="";


        for (int i = 0;i<str.length;i++){
            Dept dept_id = new Dept(Integer.valueOf(str[i]).intValue());
            Class cla = new Class(str[i]);
            List<Class> clas = classService.classSelect(cla);
            if (clas.isEmpty()){
                Teacher teacher = new Teacher();
                teacher.setDept_id(str[i]);
                List<Teacher> teachers = teacherService.teacherSelect(teacher);
                if (teachers.isEmpty()){
                    int j = deptService.deptDeleteById(dept_id);
                    if (j>0){
                        s+=str[i]+"删除部门成功";
                    }
                }else {
                    s+=str[i]+"存在教师关联，删除失败";
                }
            }else {
                s+=str[i]+"存在班级关联，删除失败";
            }
        }
        return Msg.success().add("msg",s);
    }

}
