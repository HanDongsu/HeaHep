package HeaHep.dao;

import java.util.Map;

import HeaHep.vo.HMember;

public interface HMemberDao {
  int joinMember(HMember hMember) throws Exception;
  int changeMemberInfo(HMember hMember) throws Exception;
  HMember selectOneByEmailAndPassword(Map<String, Object> paramMap) throws Exception;
}
