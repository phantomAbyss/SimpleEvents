package test.dataBase.domain;

public class ChildActivity {
    private int caId;    //子活动id
    private int aId;     //父活动id
    private String caName;  //子活动名称
    private int caDayMaxJoin;  //当天最大加入次数
    private boolean caIsAvailable;  // 活动状态
    private String caDescription;    //对子活动的描述
    private int score;              //积分数

    public ChildActivity() {
    }

    public ChildActivity(int caId, int aId, String caName, int caDayMaxJoin, boolean caIsAvailable, String caDescription, int score) {
        this.caId = caId;
        this.aId = aId;
        this.caName = caName;
        this.caDayMaxJoin = caDayMaxJoin;
        this.caIsAvailable = caIsAvailable;
        this.caDescription = caDescription;
        this.score = score;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    public int getCaDayMaxJoin() {
        return caDayMaxJoin;
    }

    public void setCaDayMaxJoin(int caDayMaxJoin) {
        this.caDayMaxJoin = caDayMaxJoin;
    }

    public boolean isCaIsAvailable() {
        return caIsAvailable;
    }

    public void setCaIsAvailable(boolean caIsAvailable) {
        this.caIsAvailable = caIsAvailable;
    }

    public String getCaDescription() {
        return caDescription;
    }

    public void setCaDescription(String caDescription) {
        this.caDescription = caDescription;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ChildActivity{" +
                "caId=" + caId +
                ", aId=" + aId +
                ", caName='" + caName + '\'' +
                ", caDayMaxJoin=" + caDayMaxJoin +
                ", caIsAvailable=" + caIsAvailable +
                ", caDescription='" + caDescription + '\'' +
                ", score=" + score +
                '}';
    }
}
