package test.dataBase.domain;

public class RelationInfo {
    private int uId;            //用户uId
    private int caId;           //参与的活动的id
    private int uaRelation;      //用户和活动的关系

    public RelationInfo() {
    }

    public RelationInfo(int uId, int caId, int uaRelation) {
        this.uId = uId;
        this.caId = caId;
        this.uaRelation = uaRelation;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getUaRelation() {
        return uaRelation;
    }

    public void setUaRelation(int uaRelation) {
        this.uaRelation = uaRelation;
    }

    @Override
    public String toString() {
        return "RelationInfo{" +
                "uId=" + uId +
                ", caId=" + caId +
                ", uaRelation=" + uaRelation +
                '}';
    }
}
