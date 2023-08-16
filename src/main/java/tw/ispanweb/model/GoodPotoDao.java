package tw.ispanweb.model;



import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class GoodPotoDao {
	
	@PersistenceContext
	private Session session;
	
	public GoodPhoto saveGoodPhoto(GoodPhoto gp) {
		session.save(gp);
		return gp;
	}
	
	public GoodPhoto findGoodPhotoById(Integer id) {
		GoodPhoto gp = session.get(GoodPhoto.class, id);
		return gp;
	}
	
	public List<GoodPhoto> findAll() {
		Query<GoodPhoto> query= session.createQuery("from GoodPhoto",GoodPhoto.class);
		return query.getResultList();
		
	}

}
