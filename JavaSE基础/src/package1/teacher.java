package package1;

/**
 * @author Zhang Yang
 * @description
 * @date 2021/11/10 - 19:51
 */
public class teacher {
    String name;
    String id;
    String major;
    public teacher(String name1,String id1,String m){
        name=name1;
        id=id1;
        major=m;
    }
    public void show()
    {
        System.out.println(id+":"+name+" teach "+major);
    }
}
