package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.Teacher;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.StudentService;
import com.myth.springboot.service.TeacherService;
import com.myth.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    //增加用户
    @RequestMapping("/userInsert")
    @ResponseBody
    public Msg userInsert(String name,String password,String type){
        String str[] = type.split("-");
        String type_id = str[0];
        User user = new User(name,password,type_id);
        List<User> u = userService.userSelect(new User());
        for (User uu:u){
            if (uu.getU_name().equals(name)){
                return Msg.success().add("msg","此用户名存在！！！");
            }
        }
        int i = userService.userInsert(user);
        if (i>0){
            return Msg.success().add("msg","增加新用户成功");
        }else {
            return Msg.success().add("msg","增加新用户失败");
        }

    }

    //查询user集合
    @RequestMapping("/userSelect")
    @ResponseBody
    public Msg userSelect(){
        List<User> users = userService.userSelect(new User());
        return Msg.success().add("users",users);
    }
    @RequestMapping("/userSelectWithPage")
    @ResponseBody
    public Map userSelectWithPage(String page, String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());

        List<User> users = userService.userSelect(new User());
        PageInfo pageInfo = new PageInfo(users,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }

    @RequestMapping("/userGetById")
    @ResponseBody
    public ModelAndView userGetById(String id){
        User user = new User();

        user.setU_id(Integer.valueOf(id).intValue());
        List<User> u = userService.userSelect(user);
        ModelAndView mv = new ModelAndView("user/user-update");
        mv.addObject("user",u.get(0));
        return mv;
    }

    //修改用户
    @RequestMapping("/userUpdate")
    @ResponseBody
    public Msg userUpdate(String id,String name,String password,String type){
        String str[] = type.split("-");
        String type_id = str[0];
        User user = new User(Integer.valueOf(id).intValue(),name,password,type_id);
//        List<User> u = userService.userSelect(new User());
//        for (User uu:u){
//            if (uu.getU_name().equals(name)){
//                return Msg.success().add("msg","此用户名存在！！！");
//            }
//        }
        int i = userService.userUpdate(user);
        if (i>0){
            return Msg.success().add("msg","修改用户成功");
        }else {
            return Msg.success().add("msg","修改用户失败");
        }
    }

    //删除用户
    @RequestMapping("/userDelete")
    @ResponseBody
    public Msg userDelete(String id,String type_id){
        System.out.println(id+"..."+type_id);
        String msg="";
        User user = new User();
        user.setU_id(Integer.valueOf(id).intValue());

        if (type_id.equals("3")){
            System.out.println("学生身份");
            Student student = new Student();
            student.setUser_id(id);
            List<Student> students = studentService.studentSelect(student);
            System.out.println("---1--");
            //删除用户表，同时关联学生信息表的删除
            if (students.isEmpty()){

                int i = userService.userDelete(user);
                if (i>0){
                    msg="无学生详情，删除成功！！！";
                } else {
                    msg="无学生详情，删除失败！！！";
                }
            }else {
                int j = studentService.studentDeleteByUserId(student);
                if (j>0){
                    int i = userService.userDelete(user);
                    if (i>0){
                        msg="删除成功,同时删除学生详情！！！";
                    } else {
                        msg="学生详情删除，用户删除失败！！！";
                    }
                }else {
                    msg="学生详情删除失败，用户删除失败！！！";
                }
            }
        }

        else if (type_id.equals("2")){
            System.out.println("教师身份");
            Teacher teacher = new Teacher();
           teacher.setUser_id(id);
            List<Teacher> teachers = teacherService.teacherSelect(teacher);
            //删除用户表，同时关联学生信息表的删除
            if (teachers.isEmpty()){

                int i = userService.userDelete(user);
                if (i>0){
                    msg="无教师详情，删除成功！！！";
                } else {
                    msg="无教师详情，删除失败！！！";
                }
            }else {
                int j = teacherService.teacherDeleteByUserId(teacher);
                if (j>0){
                    int i = userService.userDelete(user);
                    if (i>0){
                        msg="删除成功，同时删除教师详情！！！";
                    } else {
                        msg="教师详情删除，用户删除失败！！！";
                    }
                }else {
                    msg="教师详情删除失败，用户删除失败！！！";
                }
            }
        }
        else {
            return Msg.success().add("msg","你无资格删除");
        }
        return Msg.success().add("msg",msg);
    }
    @RequestMapping("/userDeleteMany")
    @ResponseBody
    public Msg userDeleteMany(String id,String type_id){
        System.out.println(id+"..."+type_id);
        String msg="";
        String ids[]=id.split(",");
        String type_ids[]=type_id.split(",");

        for (int i=0;i<ids.length;i++){
            User user = new User();
            user.setU_id(Integer.valueOf(ids[i]).intValue());
            if (type_ids[i].equals("3")){
                System.out.println("学生身份");
                Student student = new Student();
                student.setUser_id(ids[i]);
                List<Student> students = studentService.studentSelect(student);
                System.out.println("---1--");
                //删除用户表，同时关联学生信息表的删除
                if (students.isEmpty()){

                    int i1 = userService.userDelete(user);
                    if (i1>0){
                        msg+=ids[i]+"删除成功！！！";
                    } else {
                        msg+=ids[i]+"删除失败！！！";
                    }
                }else {
                    int j = studentService.studentDeleteByUserId(student);
                    if (j>0){
                        int i2 = userService.userDelete(user);
                        if (i2>0){
                            msg+=ids[i]+"删除成功,同时删除学生详情！！！";
                        } else {
                            msg+=ids[i]+"删除失败！！！";
                        }
                    }else {
                        msg+=ids[i]+"删除失败！！！";
                    }
                }
            }

           else if (type_ids[i].equals("2")){
                System.out.println("教师身份");
                Teacher teacher = new Teacher();
                teacher.setUser_id(ids[i]);
                List<Teacher> teachers = teacherService.teacherSelect(teacher);
                //删除用户表，同时关联学生信息表的删除
                if (teachers.isEmpty()){

                    int i3 = userService.userDelete(user);
                    if (i3>0){
                        msg+=ids[i]+"删除成功！！！";
                    } else {
                        msg+=ids[i]+"删除失败！！！";
                    }
                }else {
                    int j = teacherService.teacherDeleteByUserId(teacher);
                    if (j>0){
                        int i4 = userService.userDelete(user);
                        if (i4>0){
                            msg+=ids[i]+"删除成功，同时删除教师详情！！！";
                        } else {
                            msg+=ids[i]+"删除失败！！！";
                        }
                    }else {
                        msg+=ids[i]+"删除失败！！！";
                    }
                }
            }
           else {
                msg+=ids[i]+"你无资格删除！！！";
            }
        }
        return Msg.success().add("msg",msg);
    }

}
