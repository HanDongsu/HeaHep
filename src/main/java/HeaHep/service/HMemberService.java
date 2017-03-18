package HeaHep.service;

import HeaHep.vo.HMember;

public interface HMemberService {
	void singUpMembers(HMember hMember) throws Exception;
	void changeInfromation(HMember hMember) throws Exception;
	HMember getUserInfo(int memberNo) throws Exception;
}