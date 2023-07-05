package Java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(2,1,4,3,5));

        AgeCustomerComparator ageCustomerComparator = new AgeCustomerComparator();

        integerList.sort(ageCustomerComparator);
        System.out.println(integerList);


    }

}


class AgeCustomerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer integer, Integer t1) {
        if(integer > t1)
            return 1;
        else if (integer < t1)
                return -1;
        return 0;
    }
}
