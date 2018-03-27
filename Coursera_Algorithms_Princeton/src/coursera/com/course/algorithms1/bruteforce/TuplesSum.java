package coursera.com.course.algorithms1.bruteforce;

import java.util.Arrays;

/**
 * Created by 212581066 on 3/26/2018.
 */
public class TuplesSum {

    private static final String TAG = TuplesSum.class.getSimpleName();

    private static int[] numArray = new int[]{30,-40,-20,-10,40,0,10,5};

    private final int TUPLE_SUM = 0;

    public static void main(String[] args)
    {
        System.out.println(TAG);
        new TuplesSum().computeTupleSum(numArray);
    }

    private void computeTupleSum(int[] numArray)
    {
        System.out.println(Arrays.toString(numArray));
        int N = numArray.length - 1;
        for(int i=0; i < N; i++)
        {
            for(int j = i+1; j< N ; j++)
            {
                for(int k = j+1 ; k < N ; k++)
                {
                    if(numArray[i]+numArray[j]+numArray[k] == 0)
                    {
                        System.out.println("Combination : "+numArray[i]+" "+numArray[j]+" "+numArray[k]);
                    }
                }
            }
        }

    }
}
