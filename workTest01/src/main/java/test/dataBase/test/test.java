package test.dataBase.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import test.dataBase.domain.ChildActivity;

import java.util.List;


public class test {
    public static void main(String[] args) {
        String test = "{\n" +
                "\t\"aName\": \"String\",\n" +
                "\t\"aId\": 12,\n" +
                "\t\"childActivityList\": [{\n" +
                "\t\t\t\"caName\": \"string\",\n" +
                "\t\t\t\"caDayMaxJoin\": 3,\n" +
                "\t\t\t\"caIsAvailable\": true,\n" +
                "\t\t\t\"caDescription\": \"String\",\n" +
                "\t\t\t\"score\": 12\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"caName\": \"string\",\n" +
                "\t\t\t\"caDayMaxJoin\": 5,\n" +
                "\t\t\t\"caIsAvailable\": true,\n" +
                "\t\t\t\"caDescription\": \"String\",\n" +
                "\t\t\t\"score\": 18\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        JSONObject json = JSONObject.parseObject(test);
        String aName = json.getString("aName");
        JSONArray jsonArray = json.getJSONArray("childActivityList");
        List<ChildActivity> childActivities = jsonArray.toJavaList(ChildActivity.class);
        for(ChildActivity childActivity : childActivities){
            System.out.println(childActivity);
        }

        System.out.println(aName);

    }


}
