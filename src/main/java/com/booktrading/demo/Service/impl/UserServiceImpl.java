package com.booktrading.demo.Service.impl;

import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.QueryDto;
import com.booktrading.demo.Dto.Userdto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.User;
import com.booktrading.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public String CreateUser(Userdto userdto) {
        User presion = new User(userdto);
        if (Userexists(userdto.getUsername()))
        {
           return "{\"state\":\"error\",\"message\":\"用户已存在\"}";
        }
        userReponsitory.save(presion);
        return  "{\"state\":\"success\"}";

    }

    @Override
    public List<User> GetAllUser() {
        List<User> userList = new ArrayList<>();
        Iterator<User> it = userReponsitory.findAll().iterator();
        while (it.hasNext())
        {
            userList.add(it.next());
        }
        return userList;
    }

    @Override
    public User GetuserByid(int id) {
        User persion = userReponsitory.findById(id).get();
        return persion;
    }

    @Override
    public void DeleteUserbyid(int id) {
        if(userReponsitory.existsById(id))
            userReponsitory.deleteById(id);
    }

    @Override
    public boolean Userexists(String username) {
        return userReponsitory.existsByUsername(username);
    }

    @Override
    public Map<String,Object> Userlogin(QueryDto queryDto) {
        Map<String,Object> response = new HashMap<>();
        if(!Userexists(queryDto.getUsername()))
        {
            response.put("state","error");
            response.put("response","用户名不存在");
            return response;
        }
        if(UserGetbyUsername(queryDto.getUsername()).getPassword().equals(queryDto.getPassword()))
        {
            response.put("state","success");
            response.put("response",UserGetbyUsername(queryDto.getUsername()));
            return response;
        }
        response.put("state","error");
        response.put("reponse","密码错误");
        return response;
    }

    @Override
    public User UserGetbyUsername(String username) {
        return userReponsitory.findByUsername(username);
    }

    @Override
    public String GetUserAuthoritybyUsername(int userid) {
        return userReponsitory.findById(userid).get().getAuthority();
    }

    @Override
    public String ChangeUserpassword(Userdto userdto) {
        User a = userReponsitory.findById(userdto.getUserid()).get();
        a.setPassword(userdto.getPassword());
        userReponsitory.save(a);
        return "{\"state\":\"success\"}";
    }

    @Override
    public List<Book> GetAllbooksbuy(int userid) {
        return userReponsitory.findById(userid).get().getBookList();
    }

    @Override
    public List<Record> GetAllrecordasbuy(int userid){
        return userReponsitory.findById(userid).get().getRecordList();
    }

    @Override
    public List<Record> GetAllrecordassolder(int userid) {
        return userReponsitory.findById(userid).get().getRecordAssolderList();
    }
}
