package HeaHep.dao;

import java.util.Map;

import HeaHep.vo.HMember;
import HeaHep.vo.HTrainer;

public interface HMemberDao {
  int joinMember(HMember hMember) throws Exception; //회원가입
  HMember selectOneByEmail(String memberEmail) throws Exception; //이메일 중복체크
  HMember selectOneByNick(String memberNick) throws Exception; //닉네임 중복체크
  HMember selectOneByEmailAndPassword(Map<String, Object> paramMap) throws Exception; //로그인
  int changeMemberInfo(HMember hMember) throws Exception; //회원정보 수정 
  HMember selectOneByMemberEmail(int memberNo) throws Exception; //회원 정보
  int changeMeberRank(HMember hMember) throws Exception; // 랭크 변경
  int joinTrainer (HTrainer hTrainer) throws Exception; //트레이너 등록
}
