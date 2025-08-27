package ArunKarthickLearnings;

import JsonFile.DataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadingJsonInput {
    @Test(dataProvider = "getData")
    public void printData(HashMap<Object,Object> input ){
        System.out.println("Name = "+input.get("Name")+" , Age = "+input.get("Age"));

    //public void printData(String name, String age ){
        //System.out.println("Name = " +name+ ", Age = "+age);
    }


    @DataProvider
    public Object[][] getData() throws IOException {

        DataReader dr = new DataReader();
        List<HashMap<String,String>> data = dr.getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//JsonFile//Data.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};

        /*HashMap<Object,Object> map = new HashMap<Object,Object>();
        map.put("Name","Arun");
        map.put("Age","33");
        HashMap<Object,Object> map1 = new HashMap<Object,Object>();
        map1.put("Name","Karunya");
        map1.put("Age","33");
        return new Object[][] {{map},{map1}};*/

        //return new Object[][]{{"Arun","33"}, {"Karunya","33"}};
    }
}
