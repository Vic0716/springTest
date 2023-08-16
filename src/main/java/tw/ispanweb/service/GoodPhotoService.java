package tw.ispanweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispanweb.model.GoodPhoto;
import tw.ispanweb.model.GoodPotoDao;

@Service
@Transactional
public class GoodPhotoService {
	
	@Autowired
	private GoodPotoDao gpDao;
	
	public GoodPhoto inserPhoto(GoodPhoto gp) {
		return gpDao.saveGoodPhoto(gp);
	}
	
	public GoodPhoto findPhotoById(Integer id) {
		return gpDao.findGoodPhotoById(id);
	}
	
	public List<GoodPhoto> findAllPhoto(){
		return gpDao.findAll();
	}

}
