package tw.ispanweb.model;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@PersistenceContext
	private Session session;
	
	public Member findByNameAndPassword(String loginName,String loginPwd) {
		
		try {
			Member result = session.createQuery("from Member m where m.memberName= :name and m.memberPwd= :pwd",Member.class)
		.setParameter("name", loginName)
		.setParameter("pwd", loginPwd)
		.getSingleResult();
		
		return result;
		}catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
