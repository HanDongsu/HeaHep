package HeaHep.service;

import java.util.Map;

import HeaHep.vo.HMember;

public interface HMemberService {
	void singUpMembers(HMember hMember) throws Exception; // joinMember
	HMember checkedEmail(String memberEmail) throws Exception; // selectOneByEmail
	HMember checkedNick(String memberNick) throws Exception; // selectOneByNick
	HMember getLogon(Map<String, Object> paramMap) throws Exception; // selectOneByEmailAndPassword
	void changeInfromation(HMember hMember) throws Exception;
	HMember getUserInfo(int memberNo) throws Exception;
	
}