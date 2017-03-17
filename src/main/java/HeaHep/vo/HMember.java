package HeaHep.vo;

//회원 VO
public class HMember {
  protected int memberNo;
  protected String memberName;
  protected String memberEmail;
  protected int memberTel;
  protected String memberPWD;
  protected boolean memberGender;
  protected String memberRank;
  protected String trainerName;
  
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public String getMemberName() {
    return memberName;
  }
  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }
  public String getMemberEmail() {
    return memberEmail;
  }
  public void setMemberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
  }
  public int getMemberTel() {
    return memberTel;
  }
  public void setMemberTel(int memberTel) {
    this.memberTel = memberTel;
  }
  public String getMemberPWD() {
    return memberPWD;
  }
  public void setMemberPWD(String memberPWD) {
    this.memberPWD = memberPWD;
  }
  public boolean isMemberGender() {
    return memberGender;
  }
  public void setMemberGender(boolean memberGender) {
    this.memberGender = memberGender;
  }
  public String getMemberRank() {
    return memberRank;
  }
  public void setMemberRank(String memberRank) {
    this.memberRank = memberRank;
  }
  public String getTrainerName() {
    return trainerName;
  }
  public void setTrainerName(String trainerName) {
    this.trainerName = trainerName;
  }
}
