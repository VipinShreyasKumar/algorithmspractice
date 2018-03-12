
/**
 * Created by 212581066 on 3/3/2018.
 */

package coursera.com.course.algorithms1;

import coursera.com.course.algorithms1.union.QuickUnion;
import coursera.com.course.algorithms1.union.QuickUnionWeighted;

public class Algorithms1Framework {


    private static final String TAG = Algorithms1Framework.class.getSimpleName();

    private static int[] unionTestArray = new int[]{0,1,2,3,4,5,6,7,8,9};

    public static void main(String[] args){

        System.out.println(TAG);

        /**
         * QuickUnion algorithm
         */
        QuickUnion qUnion = new QuickUnion(new int[]{0,1,2,3,4,5,6,7,8,9});
        qUnion.run();

        QuickUnionWeighted qWeighted = new QuickUnionWeighted(new int[]{0,1,2,3,4,5,6,7,8,9});
        qWeighted.run();

    }

}
