package service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.YhDao;
import service.YhService;
import shitilei.Yh;

@Service("yhservice")
public class YhServiceImpl implements YhService {
	@Resource(name = "yhdao")
	private YhDao yhdao;

	@Override
	public Yh getYhbyname(String name) {
		return this.yhdao.getYhbyname(name);
	}

	@Override
	public Yh getYhbyid(String id) {
		return this.yhdao.getYhbyid(id);
	}

	@Override
	public int zhuce(Yh yh) {
		return this.yhdao.zhuce(yh);
	}

	// @Override
	// public Yh zhuce(Yh yh){
	// return yhdao.zhuce(yh);
	// }
	@Override
	public List<Yh> getYhall(Yh yh) {
		// TODO Auto-generated method stub
		return yhdao.getYhall(yh);
	}

	@Override
	public int shanchuByname(String name) {
		// TODO Auto-generated method stub
		return yhdao.shanchuByname(name);
	}

	@Override
	public int updateYh(Yh yh) {
		return this.yhdao.updateYh(yh);
	}
}
