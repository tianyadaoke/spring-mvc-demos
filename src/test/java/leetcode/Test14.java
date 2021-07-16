package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Test14 {
    @Test
    void test14(){
        String[] strs = new String[]{"ab", "c"};
        int minLen = strs[0].length();
        int commonLength=0;
        for (int i = 1; i < strs.length; i++) {
            if(minLen>strs[i].length()){
                minLen=strs[i].length();
            }
        }
        Set<String> set = new HashSet();
        for (int i = 0; i < minLen; i++) {
            for (String s:strs){
                set.add(s.substring(0,i+1));
            }

            if(set.size()==i+1){
                commonLength=i+1;
            }

        }
        System.out.println(commonLength);
        System.out.println("结果"+strs[0].substring(0,commonLength));
    }
}
