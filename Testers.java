package LogicAndDataTypes;
import java.util.*;

public class Testers {
    /**
     * @author Chase P. Miller
     * @version Version 1.0.1
     * @since 1 MARCH 2020
     * @param list list of values
     * @return list of the largest repeating value
     */
    public List<Integer> longestRun(ArrayList<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        int count = 1; // count of repeating values
        int OGCount = 1; // orginal highest count
        int current = 0; // starting index of repeating values
        for(int i = 1; i < list.size() - 1; i++) {
            if(list.get(i).equals(list.get(i-1))) { // if the index has the same value as the previous index
                count++;
            } else {
                if(count > OGCount) { // if this previous group of repeating had more elements
                    current = i - count; // replace the starting index of repeating values with new one
                    OGCount = count; // replace highest count with this one
                }
                count = 1;
            }
        }
        while(OGCount > 0) {
            result.add(list.remove(current));
            OGCount--;
        }
        return result;
    }
}