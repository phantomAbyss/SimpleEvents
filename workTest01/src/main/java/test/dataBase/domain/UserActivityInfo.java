package test.dataBase.domain;

public class UserActivityInfo {
    private int aId;

    private int uId;

    private int totalScore;

    public UserActivityInfo() {
    }

    public UserActivityInfo(int aId, int uId, int totalScore) {
        this.aId = aId;
        this.uId = uId;
        this.totalScore = totalScore;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "UserActivityInfo{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", totalScore=" + totalScore +
                '}';
    }
}
