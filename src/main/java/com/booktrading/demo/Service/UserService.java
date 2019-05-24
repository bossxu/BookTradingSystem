package com.booktrading.demo.Service;


import com.booktrading.demo.Dao.UserReponsitory;
import com.booktrading.demo.Dto.Userdto;
import com.booktrading.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public Userdto CreateUser(Userdto userdto);

    public List<Userdto> GetAllUser();

    public Userdto GetuserByid(int id);

    public void DeleteUserbyid(int id);

    public boolean Userexists(String username);

    public Userdto Userlogin(Userdto userdto);


}
