package leetcode;

import org.junit.jupiter.api.Test;

public class Test20 {
    @Test
    void isValid(){
        String s = "(([]){})";
        int len=s.length();
        if(s.length()<=1){
            System.out.println(false);
        }
        String s1="()";
        String s2="[]";
        String s3 = "{}";
        for (int i = 0; i <len/2; i++) {
            s=s.replace(s1,"");
            s=s.replace(s2,"");
            s=s.replace(s3,"");
            System.out.println(s);
            if(s.length()==0){
                System.out.println(true);
            }
        }
        System.out.println("false");
    }
}
