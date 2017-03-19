package HeaHep.dao;

import java.util.Map;

import HeaHep.vo.HMember;

public interface HMemberDao {
  int joinMember(HMember hMember) throws Exception;
  int changeMemberInfo(HMember hMember) throws Exception;
  HMember selectOneByEmailAndPassword(Map<String, Object> paramMap) throws Exception;
  HMember selectOneByMemberNo(int memberNo) throws Exception;
  HMember selectOneByEmail(String memberEmail) throws Exception;
}
