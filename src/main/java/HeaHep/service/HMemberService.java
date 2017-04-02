package HeaHep.service;

import java.util.Map;

import HeaHep.vo.HMember;
import HeaHep.vo.HTrainer;

public interface HMemberService {
	void singUpMembers(HMember hMember) throws Exception;  // joinMember
	HMember getLogon(Map<String, Object> paramMap) throws Exception;  // selectOneByEmailAndPassword
	void changeInfromation(HMember hMember) throws Exception;  // changeMemberInfo
	HMember getUserInfo(String memberEmail) throws Exception;  // selectOneByMemberEmail
	HMember checkedEmail(String memberEmail) throws Exception;  // selectOneByEmail
	HMember checkedNick(String memberNick) throws Exception;  // selectOneByNick
	void changeRank(HMember hMember) throws Exception;  // changeMemberRank
	void signUpTrainers(HTrainer hTranier) throws Exception;  // joinTrainer
	HTrainer getTrainerInfo(int trainerNo) throws Exception;  // selectOneByTrainerNo
	
}