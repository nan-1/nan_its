package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import shitilei.Yh;
@Repository("yhdao")
public interface YhDao {
Yh getYhbyname(String name);
Yh getYhbyid(String id);
List<Yh> getYhall(Yh yh);
int zhuce(Yh yh);
int shanchuByname(String name);
int updateYh(Yh yh);
//int zhuce(@Param("name")String name,@Param("pwd")String pwd,@Param("zjhm")String zjhm);
}
