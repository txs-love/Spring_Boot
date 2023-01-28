package com.example.sherry.mapper;

import com.example.sherry.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/27 15:11
 */
@Mapper  // 表示走是一个mybatis的类;  Dao
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
