package test.dataBase.domain;

import java.util.List;

public class Table {
    //主活动的id
    private int aId;
    private String uName;
    private Activity activity;
    //报名表需要的字段
    private List<FieldInfo> fieldList;
    //大活动包含的子活动
    private List<ChildActivity> childActivityList;

    public Table() {
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Table(int aId, String uName, Activity activity, List<FieldInfo> fieldList, List<ChildActivity> childActivityList) {
        this.aId = aId;
        this.uName = uName;
        this.activity = activity;
        this.fieldList = fieldList;
        this.childActivityList = childActivityList;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public List<FieldInfo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldInfo> fieldList) {
        this.fieldList = fieldList;
    }

    public List<ChildActivity> getChildActivityList() {
        return childActivityList;
    }

    public void setChildActivityList(List<ChildActivity> childActivityList) {
        this.childActivityList = childActivityList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(uName + "\t");
        sb.append(activity + "\t");
        sb.append(aId + "\t");
        if(fieldList != null){
            for(FieldInfo field : fieldList){
                sb.append(field.toString());
            }
        }
        if(childActivityList != null){
            for (ChildActivity activity : childActivityList){
                sb.append(activity.toString());
            }
        }

        return sb.toString();
    }
}
