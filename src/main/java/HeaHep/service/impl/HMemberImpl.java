package HeaHep.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HeaHep.dao.HMemberDao;
import HeaHep.service.HMemberService;
import HeaHep.vo.HMember;

@Service
public class HMemberImpl implements HMemberService {
	@Autowired HMemberDao hMemberDao;
	public void singUpMembers(HMember hMember) throws Exception {
	  hMemberDao.joinMember(hMember);
	}
}