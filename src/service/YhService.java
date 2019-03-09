package service;

import java.util.List;

import shitilei.Yh;

public interface YhService {
public Yh getYhbyname(String name);
public Yh getYhbyid(String id);
List<Yh> getYhall(Yh yh);
public int zhuce(Yh yh);
int shanchuByname(String name);
int updateYh(Yh yh);
}
