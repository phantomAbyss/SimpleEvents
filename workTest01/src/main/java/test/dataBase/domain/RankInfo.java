package test.dataBase.domain;

public class RankInfo {
    private Activity activity;
    private UserInfo user;
    private int totalScore;

    public RankInfo() {
    }

    public RankInfo(Activity activity, UserInfo user, int totalScore) {
        this.activity = activity;
        this.user = user;
        this.totalScore = totalScore;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "RankInfo{" +
                "activity=" + activity +
                ", user=" + user +
                ", totalScore=" + totalScore +
                '}';
    }
}
