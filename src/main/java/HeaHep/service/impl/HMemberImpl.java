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
	public void changeInfromation(HMember hMember) throws Exception{
	  hMemberDao.changeMemberInfo(hMember);
	}
	public HMember getUserInfo(int memberNo) throws Exception{
		HMember memberInfo = hMemberDao.selectOneByMemberNo(memberNo);
		return memberInfo;
	}
}