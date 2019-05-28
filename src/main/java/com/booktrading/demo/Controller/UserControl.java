package com.booktrading.demo.Controller;


import com.booktrading.demo.Dto.QueryDto;
import com.booktrading.demo.Dto.Userdto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.UserService;
import com.booktrading.demo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
@RestController
@RequestMapping("/api/user")
@EnableAutoConfiguration
public class UserControl {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/regist")
    public String CreatenewUser(@RequestBody Userdto userdto) {
        return userService.CreateUser(userdto);
    }

    @PostMapping("/login")
    public Map<String,Object> LoginCheck(@RequestBody QueryDto queryDto) {
       return userService.Userlogin(queryDto);
    }

    @GetMapping("/authority/{id}")
    public String GetAuthoritybyid(@PathVariable int id) {
        return userService.GetUserAuthoritybyUsername(id);
    }

    @PostMapping("/changepassword")
    public String ChangePassword(@RequestBody Userdto userdto) {
        return userService.ChangeUserpassword(userdto);
    }

    @GetMapping("/all")
    public List<User> GetAllusers() {
        return userService.GetAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteoneUser(@PathVariable int id)
    {
        userService.DeleteUserbyid(id);
        return "{\"state\":\"success\"}";
    }
    @GetMapping("{id}")
    public User GetOneUserdetail(@PathVariable int id)
    {
        return userService.GetuserByid(id);
    }
}
