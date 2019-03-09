package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shitilei.PermissionsVo;
import shitilei.YhVo;
import dao.RpyDao;

public interface RpyService {	
	public List<PermissionsVo> juesequanxian(String yhid);
	public int jiaruvip(String yhid);

}
