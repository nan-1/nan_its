package service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RpyDao;
import service.RpyService;
import shitilei.PermissionsVo;
import shitilei.YhVo;
@Service("rpyservice")
public class RpyServiceImpl implements RpyService{
	@Autowired
	public RpyDao rpydao;

	@Override
	public List<PermissionsVo> juesequanxian(String yhid) {
		return rpydao.juesequanxian(yhid);
	}

	@Override
	public int jiaruvip(String yhid) {
		// TODO Auto-generated method stub
		return rpydao.jiaruvip(yhid);
	}

}
