package coursera.com.course.algorithms1.bruteforce;

import java.util.Arrays;

/**
 * Created by 212581066 on 3/26/2018.
 */
public class TupleSumWithBinarySearch {

    private static final String TAG = TupleSumWithBinarySearch.class.getSimpleName();


    private static int[] numArray = new int[]{30,-40,-20,-10,40,0,10,5};

    private final int TUPLE_SUM = 0;


    public static void main(String[] args)
    {
        System.out.println(TAG);
        new TupleSumWithBinarySearch().computeTupleSum(numArray);

    }

    private void computeTupleSum(int[] computeArray)
    {
        System.out.println(computeArray);
        Arrays.sort(numArray);
        int N = computeArray.length;
        for(int i = 0; i < N ; i++ )
        {
            for(int j = i+1; j< N ; j++)
            {
                int valtocheck = TUPLE_SUM - (computeArray[i]+computeArray[j]);
                int bStartIndex = j+1;
                if(bStartIndex < N) {
                    int sIndex = bSearchNum(computeArray, valtocheck, bStartIndex, computeArray.length - 1);
                    if (sIndex != -1) {
                        System.out.println("Combination : " + computeArray[i] + " " + computeArray[j] + " " + computeArray[sIndex]);
                    }
                }

            }
        }
    }

    private int bSearchNum(int[] sArray , int searchVal, int leftI , int rightI)
    {
        {
            if(rightI >= leftI)
            {
                int midVal = leftI + (rightI - leftI)/2;

                if(sArray[midVal] == searchVal)
                {

                    return midVal;
                }
                if(sArray[midVal] > searchVal)
                {

                    return bSearchNum(sArray,searchVal,leftI,midVal-1);
                }

                if(sArray[midVal] < searchVal)
                {

                    return bSearchNum(sArray,searchVal,midVal +1, rightI);
                }
            }
        }

        return -1;
    }

}
