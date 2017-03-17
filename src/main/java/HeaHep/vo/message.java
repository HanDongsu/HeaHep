package HeaHep.vo;

//메시지 VO
public class message {
  protected int trainerNo;
  protected String trainerName;
  protected String trainerId;
  protected int trainerTel;
  protected String trainerPWD;
  protected boolean trainerGender;
  protected String depatName;
  protected String trainerPhoto;
  
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
  public String getTrainerId() {
    return trainerId;
  }
  public void setTrainerId(String trainerId) {
    this.trainerId = trainerId;
  }
  public int getTrainerTel() {
    return trainerTel;
  }
  public void setTrainerTel(int trainerTel) {
    this.trainerTel = trainerTel;
  }
  public String getTrainerPWD() {
    return trainerPWD;
  }
  public void setTrainerPWD(String trainerPWD) {
    this.trainerPWD = trainerPWD;
  }
  public boolean isTrainerGender() {
    return trainerGender;
  }
  public void setTrainerGender(boolean trainerGender) {
    this.trainerGender = trainerGender;
  }
  public String getDepatName() {
    return depatName;
  }
  public void setDepatName(String depatName) {
    this.depatName = depatName;
  }
  public String getTrainerPhoto() {
    return trainerPhoto;
  }
  public void setTrainerPhoto(String trainerPhoto) {
    this.trainerPhoto = trainerPhoto;
  }
}
