package HeaHep.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HeaHep.dao.HMemberDao;
import HeaHep.service.HMemberService;
import HeaHep.vo.HMember;
import HeaHep.vo.HTrainer;

@Service
public class HMemberImpl implements HMemberService {
	@Autowired HMemberDao hMemberDao;
	// joinMember 회원가입
	public void singUpMembers(HMember hMember) throws Exception {
	  hMemberDao.joinMember(hMember);
	}
	// selectOneByEmailAndPassword 로그인
	public HMember getLogon(Map<String, Object> paramMap) throws Exception{
		return hMemberDao.selectOneByEmailAndPassword(paramMap);
	}
	// changeMemberInfo 회원정보 변경 
	public void changeInfromation(HMember hMember) throws Exception{
		hMemberDao.changeMemberInfo(hMember);
	}
	// selectOneByMemberEmail 회원정보 보기
	public HMember getUserInfo(String memberEmail) throws Exception{
		return hMemberDao.selectOneByMemberEmail(memberEmail);
	}
	// selectOneByEmail 이메일 중복체크
	public HMember checkedEmail(String memberEmail) throws Exception {
		return hMemberDao.selectOneByEmail(memberEmail);
	}
	// selectOneByNick 닉네임 중복체크
	public HMember checkedNick(String memberNick) throws Exception {
    return hMemberDao.selectOneByNick(memberNick);
  }
	// changeMemberRank 회원 랭크 변경
	public void changeRank(HMember hMember) throws Exception {
		hMemberDao.changeMeberRank(hMember);
	}
	// joinTrainer 트레이너 등록
	public void signUpTrainers(HTrainer hTrainer) throws Exception {
		hMemberDao.joinTrainer(hTrainer);
	}
	// selectOneByTrainerNo 트레이너 정보 보기
	public HTrainer getTrainerInfo(int trainerNo) throws Exception {
		return hMemberDao.selectOneByTrainerNo(trainerNo);
	}
}