package blocks;

import java.sql.SQLOutput;

public class Block {
    double x;
    double y;
    double z;
    double Hardness;
    String id;
    Block(double x, double y, double z, double Hardness, String id){
        this.x = x;
        this.y = y;
        this.z = z;
        this.Hardness = Hardness;
        this.id = "amoguscraft:" + id;
    }
    void printName(){
        System.out.println(id);
    }
}
