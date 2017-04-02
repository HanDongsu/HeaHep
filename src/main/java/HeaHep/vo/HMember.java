package HeaHep.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

//회원 VO
public class HMember {
  protected int memberNo;
  protected String memberName;
  protected String memberEmail;
  protected String memberNick;
  protected String memberTel;
  protected String memberPWD;
  protected String memberGender;
  protected String memberRank;
  protected int trainerNo;
  protected String trainerName;
  protected Date joinedDate;
  protected String joinedDate2;
  static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  protected Date startDate;  //등록 시작일
  protected Date endDate;    //등록 종료일
  protected Date stopSDate;  //정지 시작일
  protected Date stopEDate;  //정지 종료일
  protected int stopDate;    //정지 총일수
  
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
  public String getMemberNick() {
    return memberNick;
  }
  public void setMemberNick(String memberNick) {
    this.memberNick = memberNick;
  }
  public String getMemberTel() {
    return memberTel;
  }
  public void setMemberTel(String memberTel) {
    this.memberTel = memberTel;
  }
  public String getMemberPWD() {
    return memberPWD;
  }
  public void setMemberPWD(String memberPWD) {
    this.memberPWD = memberPWD;
  }
  public String getMemberGender() {
    return memberGender;
  }
  public void setMemberGender(String memberGender) {
    this.memberGender = memberGender;
  }
  public String getMemberRank() {
    return memberRank;
  }
  public void setMemberRank(String memberRank) {
    this.memberRank = memberRank;
  }
  public int getTrainerNo() {
    return trainerNo;
  }
  public void setTrainerNo(int trainerNo) {
    this.trainerNo = trainerNo;
  }
  public String getTrainerName() {
    return trainerName;
  }
  public void setTrainerName(String trainerName) {
    this.trainerName = trainerName;
  }
  public Date getJoinedDate() {
    return joinedDate;
  }
  public void setJoinedDate(Date joinedDate) {
    this.joinedDate = joinedDate;
    this.joinedDate2 = format.format(joinedDate);
  }
  public String getJoinedDate2() {
    return joinedDate2;
  }
  public void setJoinedDate2(String str) {
    this.joinedDate = Date.valueOf(str);
    this.joinedDate2 = str;
  }
  public static SimpleDateFormat getFormat() {
    return format;
  }
  public static void setFormat(SimpleDateFormat format) {
    HMember.format = format;
  }
  
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Date getStopSDate() {
    return stopSDate;
  }
  public void setStopSDate(Date stopSDate) {
    this.stopSDate = stopSDate;
  }
  public Date getStopEDate() {
    return stopEDate;
  }
  public void setStopEDate(Date stopEDate) {
    this.stopEDate = stopEDate;
  }
  public int getStopDate() {
    return stopDate;
  }
  public void setStopDate(int stopDate) {
    this.stopDate = stopDate;
  }
  
  
  
}
