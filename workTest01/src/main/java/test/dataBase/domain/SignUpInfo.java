package test.dataBase.domain;

import java.util.List;

public class SignUpInfo {
    private String aName;
    private int aId;
    private int uId;
    private List<String> signUpMessage;

    public SignUpInfo() {
    }

    public SignUpInfo(String aName, int aId, int uId, List<String> signUpMessage) {
        this.aName = aName;
        this.aId = aId;
        this.uId = uId;
        this.signUpMessage = signUpMessage;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
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

    public List<String> getSignUpMessage() {
        return signUpMessage;
    }

    public void setSignUpMessage(List<String> signUpMessage) {
        this.signUpMessage = signUpMessage;
    }

    @Override
    public String toString() {
        return "SignUpInfo{" +
                "aName='" + aName + '\'' +
                ", aId=" + aId +
                ", uId=" + uId +
                ", signUpMessage=" + signUpMessage +
                '}';
    }
}
