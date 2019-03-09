package service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.TongjiService;
import shitilei.TongjiVo;
import dao.TongjiDao;
@Service
public class TongjiServiceImpl implements TongjiService{
	@Autowired
	private TongjiDao tongjidao;

	@Override
	public List<TongjiVo> zhucetongji() {
		// TODO Auto-generated method stub
		return tongjidao.zhucetongji();
	}
	
	

}
