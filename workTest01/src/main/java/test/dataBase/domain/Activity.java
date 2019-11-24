package test.dataBase.domain;

public class Activity {
    private int aId;   // id
    private int uId;           //创建该活动的用户的用户id
    private String aName;  //活动名称
    private String aCreationTime;  //创建时间
    private String aDeadlineTime;   //活动失效时间
    private int aParticipation;  //参与人数
    private String aAbstract;          //活动摘要
    private String aDescription;  // 活动描述
    private String aPicturePath;  //活动图片路径
    private int aStatus;         //活动状态
    private String aNotice;    //活动公告
    private boolean aHaveChild;    //有无子活动
    private int totalScore;        //用户在该项活动中的总计分数

    public Activity() {

    }

    public Activity(int aId, String aName, String aCreationTime, String aDeadlineTime, int aParticipation, String aAbstract, String aDescription, String aPicturePath, int aStatus, String aNotice, boolean aHaveChild) {
        this.aId = aId;
        this.aName = aName;
        this.aCreationTime = aCreationTime;
        this.aDeadlineTime = aDeadlineTime;
        this.aParticipation = aParticipation;
        this.aAbstract = aAbstract;
        this.aDescription = aDescription;
        this.aPicturePath = aPicturePath;
        this.aStatus = aStatus;
        this.aNotice = aNotice;
        this.aHaveChild = aHaveChild;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaCreationTime() {
        return aCreationTime;
    }

    public void setaCreationTime(String aCreationTime) {
        this.aCreationTime = aCreationTime;
    }

    public String getaDeadlineTime() {
        return aDeadlineTime;
    }

    public void setaDeadlineTime(String aDeadlineTime) {
        this.aDeadlineTime = aDeadlineTime;
    }

    public int getaParticipation() {
        return aParticipation;
    }

    public void setaParticipation(int aParticipation) {
        this.aParticipation = aParticipation;
    }

    public String getaAbstract() {
        return aAbstract;
    }

    public void setaAbstract(String aAbstract) {
        this.aAbstract = aAbstract;
    }

    public String getaDescription() {
        return aDescription;
    }

    public void setaDescription(String aDescription) {
        this.aDescription = aDescription;
    }

    public String getaPicturePath() {
        return aPicturePath;
    }

    public void setaPicturePath(String aPicturePath) {
        this.aPicturePath = aPicturePath;
    }

    public int getaStatus() {
        return aStatus;
    }

    public void setaStatus(int aStatus) {
        this.aStatus = aStatus;
    }

    public String getaNotice() {
        return aNotice;
    }

    public void setaNotice(String aNotice) {
        this.aNotice = aNotice;
    }

    public boolean isaHaveChild() {
        return aHaveChild;
    }

    public void setaHaveChild(boolean aHaveChild) {
        this.aHaveChild = aHaveChild;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", aName='" + aName + '\'' +
                ", aCreationTime='" + aCreationTime + '\'' +
                ", aDeadlineTime='" + aDeadlineTime + '\'' +
                ", aParticipation=" + aParticipation +
                ", aAbstract='" + aAbstract + '\'' +
                ", aDescription='" + aDescription + '\'' +
                ", aPicturePath='" + aPicturePath + '\'' +
                ", aStatus=" + aStatus +
                ", aNotice='" + aNotice + '\'' +
                ", aHaveChild=" + aHaveChild +
                ", totalScore=" + totalScore +
                '}';
    }
}
