package dao.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import shitilei.Yh;
import dao.YhDao;

public class YhDaoImpl  {
	//通过构造函数注入
//	public YhDaoImpl(SqlSessionFactory sqlSessionFactory){
//		this.setSqlSessionFactory(sqlSessionFactory);
//	}
	private SqlSessionFactory sqlSessionFactory;
	public Yh getYhbyname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Yh zhuce(String name, String pwd, String zjhm) {
		// TODO Auto-generated method stub
		return null;
	}
}