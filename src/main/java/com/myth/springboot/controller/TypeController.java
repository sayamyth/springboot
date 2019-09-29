package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Type;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.TypeService;
import com.myth.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;
    @RequestMapping("/typeAdd")
    @ResponseBody
    public Msg typeAdd(String name){
        List<Type> types=typeService.typeSelect(new Type());
        for (Type type:types){
            if (type.getName().equals(name)){
                return Msg.success().add("msg","已存在");
            }
        }
        Type type = new Type(name);
        int i = typeService.typeInsert(type);
        if (i>0){
            return Msg.success().add("msg","增加新权限成功");
        }else{
            return Msg.success().add("msg","增加新权限失败");
        }
    }
    @RequestMapping("/typeList")
    @ResponseBody
    public Msg typeList(){
        List<Type> types = typeService.typeSelect(new Type());
        return Msg.success().add("type",types);
    }
    @RequestMapping("/typeListWithPage")
    @ResponseBody
    public Map typeListWithPage(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());
        List<Type> types = typeService.typeSelect(new Type());
        PageInfo pageInfo = new PageInfo(types,5);
        Map<String,Object> map=new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }

    //权限修改
    @RequestMapping("/typelUpdate")
    @ResponseBody
    public Msg levelUpdate(String id,String name){
        return Msg.success();
    }



    @RequestMapping("/typeDelete")
    @ResponseBody
    public Msg typeDelete(String id){
        Type type = new Type();
        type.setId(Integer.valueOf(id).intValue());
        if (id.equals("1") || id.equals("2") || id.equals("3")){
            return Msg.success().add("msg","系统默认权限，无法删除！");
        }
        int i=typeService.typeDelete(type);
        if (i>0){
            return Msg.success().add("msg","此权限删除成功");
        }else {
            return Msg.success().add("msg","此权限删除错误，联系管理员");
        }
    }
}
