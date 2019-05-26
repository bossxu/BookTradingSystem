package com.booktrading.demo.Service;


import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.QueryDto;
import com.booktrading.demo.Dto.Userdto;
import com.booktrading.demo.Model.Book;
import com.booktrading.demo.Model.Record;
import com.booktrading.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {

    public String CreateUser(Userdto userdto);

    public List<User> GetAllUser();

    public User GetuserByid(int id);

    public void DeleteUserbyid(int id);

    public boolean Userexists(String username);

    public Map<String,Object> Userlogin(QueryDto queryDto);

    public User UserGetbyUsername(String username);

    public String GetUserAuthoritybyUsername(int userid);

    public String ChangeUserpassword(Userdto userdto);

    public List<Book> GetAllbooksbuy(int userid);

    public List<Record> GetAllrecordasbuy(int userid);

    public List<Record> GetAllrecordassolder(int userid);

}
