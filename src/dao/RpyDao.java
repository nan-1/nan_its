package dao;

import java.util.List;

import shitilei.PermissionsVo;
import shitilei.YhVo;

public interface RpyDao {
public List<PermissionsVo> juesequanxian(String yhid);
public int jiaruvip(String yhid);
}
