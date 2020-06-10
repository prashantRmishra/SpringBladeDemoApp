package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.DeleteRoute;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.example.model.User;
import com.example.service.UserService;


@Path
public class UserController {
    @Inject
    UserService userService;
    List<User> user = new ArrayList<User>();
    @Route(value = "/getUserDetails", method = HttpMethod.GET)
    @JSON
    public List<User> get() {
        userService.getProjectDetail();
        System.out.println("get method went successfull");
        return userService.getProjectDetail();

    }

    @PostRoute("/addUserProj/add")
    @JSON
    public String post(@Param User data) {
        int success=0;
        try {
            success=userService.insert(data);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        System.out.println("Recieved data from post with custId:" + data.getCustId());
        return success > 0 ? "Record Added Successfully!!!" : "Record With the Same Customer ID Already Exist";
    }

    @GetRoute("/users/:uid")
    @JSON
    public List<User> restfulParam(@PathParam String uid) {
        System.out.println("uid of projects: " + uid);
        boolean found = false;
        List<User> list = new ArrayList<User>();
        try {
            list.add(userService.getDetailsOnPid(uid));
            found=!found;
            System.out.println("getDetailsOnPid() was success full"+list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // for (User User : user) {
        //     if (User.getCustId().equals(uid)) {
        //         System.out.println("found");
        //         list.add(User);
        //         found = !found;
        //         return list;
        //     }

        // }
        if (found == false) {
            System.out.println("data not found");

        }
        return list;

    }

    @DeleteRoute("/delete/:id")
    @JSON
    public String delete(@PathParam String id) {
       int success = 0;
       try {
        success=userService.deleteDetailOfId(id);
        System.out.println("deleteDetailOfId() successfull!!");
       } catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("custI from url is:"+id);
        
        // for (User User : user) {
        //    if(User!=null){
        //     if (User.getCustId().equals(id)) {
        //         list.add(User);
        //         user.remove(index);
        //         break;

        //     }
        //    }
        //    index++;
        // }

        return success >0 ? "Record Deleted Successfyully!!":"Record not Found!!";

    }
   
}