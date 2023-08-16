package tw.ispanweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispanweb.model.Member;
import tw.ispanweb.model.MemberDao;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao mDao;
	
	public Member checkLogin(String loginUser,String loginPwd) {
		
		//開交易
		
		Member member = mDao.findByNameAndPassword(loginUser, loginPwd);
		//dao2
		//dao3
		//dao4
		
		if(member != null) {
			return member;
		}
		
		//commit
		
		return null;
		
	}

}
