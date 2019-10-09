package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.service.ClassService;
import com.myth.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;

    /**
     * 班级业务
     */
    /*
        得到所有class信息
     */
    @RequestMapping("/classListWithPage")
    @ResponseBody
    public Map<String, Object> classListWithPage(String page, String limit) {
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        List<Class> cla = classService.classSelect(new Class());
        PageInfo pageInfo = new PageInfo(cla, 5);

        Map<String, Object> map = new HashMap<>();
        map.put("data", pageInfo);
        return map;
    }

    @RequestMapping("/classList")
    @ResponseBody
    public Msg classList() {

        List<Class> cla = classService.classSelect(new Class());

        return Msg.success().add("cla", cla);
    }
    @RequestMapping("/classListByName")
    @ResponseBody
    public Msg classListByName(String class_name) {
        Class c = new Class();
        c.setC_name(class_name);
        List<Class> cla = classService.classSelect(c);

        return Msg.success().add("cla", cla.get(0));
    }

    @RequestMapping("/classGetById")
    @ResponseBody
    public ModelAndView classGetById(String id) {
        ModelAndView mv = new ModelAndView("class/class-update");
        Integer c_id = Integer.valueOf(id).intValue();
        Class cla = new Class();
        cla.setC_id(c_id);
        List<Class> cl = classService.classSelect(cla);
        mv.addObject("cla", cl.get(0));
        return mv;
    }

    @RequestMapping("/classAdd")
    @ResponseBody
    public Msg classAdd(String batch_id,String name,String dept_id) {

        Class cla = new Class(name,dept_id,batch_id);
        List<Class> cl = classService.classSelect(new Class());
        for (Class c : cl) {
            if (c.getC_name().equals(name)) {
                return Msg.success().add("msg", "添加班级信息失败，班级重复了！！！");
            }
        }
        int i = classService.classInsert(cla);
        if (i > 0) {
            return Msg.success().add("msg", "添加班级信息成功");
        } else {
            return Msg.success().add("msg", "添加学生信息失败，不知道怎么了！！！");
        }
    }

    @RequestMapping("/classUpdate")
    @ResponseBody
    public Msg classUpdate(String batch_id,String id, String name,String dept_id) {

        List<Class> cl = classService.classSelect(new Class());

        for (Class c : cl) {
            if (c.getC_name().equals(name)) {
                   if (c.getDept_id().equals(dept_id)){
                       return Msg.success().add("msg", "存在此信息,修改失败！");
                   }
            }
        }
        System.out.println(id + "......" + name);
        Integer c_id = Integer.valueOf(id).intValue();
        String c_name = name;
        Class cla = new Class(c_id, c_name,dept_id,batch_id);

        int i = classService.classUpdateById(cla);
        if (i > 0) {
            return Msg.success().add("msg", "修改成功,老弟！");
        } else {
            return Msg.success().add("msg", "出错了，老弟！");
        }
    }

    @RequestMapping("/classDelete")
    @ResponseBody
    public Msg classDelete(String id) {
        System.out.println(id);
        Integer c_id = Integer.valueOf(id).intValue();
        Class cla = new Class(c_id);
        Student s = new Student();
        s.setClass_id(id);
//        List<Student> students = studentService.studentSelect(student);
        List<Student> students = studentService.studentSelect(s);
        if (students.isEmpty()) {
            int i = classService.classDeleteById(cla);
            if (i > 0) {
                return Msg.success().add("msg", "删除成功,老弟！");
            } else {
                return Msg.success().add("msg", "出错了，老弟！");
            }
        } else {
            return Msg.success().add("msg", "存在学生关联，删不了,老弟！");
        }

    }

    @RequestMapping("/classDeleteMany")
    @ResponseBody
    public Msg classDeleteMany(String id) {
        System.out.println(id);
        String str[] = id.split(",");

        String s="";
        for (int i = 0; str.length > i; i++){
            System.out.println(str[i]);
        }
        for (int i = 0; str.length > i; i++) {
            Integer c_id = Integer.valueOf(str[i]).intValue();
            Class cla = new Class(c_id);
            Student ss = new Student();
            ss.setClass_id(str[i]);
            List<Student> students = studentService.studentSelect(ss);
            if (students.isEmpty()) {
                int j = classService.classDeleteById(cla);
                if (j > 0) {

                        s+=str[i]+"删除成功";
                }
            } else {
                s+=str[i]+"存在学生关联失败";
            }
        }
        return Msg.success().add("msg",s);
    }
}
