package coursera.com.course.algorithms1.union;

/**
 * Created by 212581066 on 3/3/2018.
 */

import java.util.Arrays;

/**
 * Theory: To merge two components p and q using the operation Union(p,q)
 * set the id of q's root to the id of p's root
 * id[p] = id[q]
 *
 * Sequence of operations
 union(4,3)
 union(3,8)
 union(6,5)
 union(9,4)
 union(2,1)
 connected(8,9)
 connected(5,4)
 union(5,0)
 union(7,2)
 union(6,1)
 union(7,3)
 */



public class QuickUnion implements Runnable {


    private int[] searchArray ;

    private static final String TAG = QuickUnion.class.getSimpleName();


    /***
     *
     * @param unionArray
     */
    public QuickUnion(int[] unionArray){

        System.out.println(TAG);
        this.searchArray = unionArray;

    }

    /**
     *
     */
    @Override
    public void run() {
        union(4,3);

        union(3,8);
        union(6,5);
        union(9,4);
        union(2,1);


        union(5,0);
        union(7,2);
        union(6,1);
        union(7,3);

        System.out.println(Arrays.toString(this.searchArray));
        System.out.println(connected(8,9));
        System.out.println(connected(5,4));

    }


    private void union(int p , int q)
    {
        //int loc_id_p = id(p);
        int loc_id_q = id(q);
        this.searchArray[p] = loc_id_q;
    }

    private int id(int p)
    {

        while(p != this.searchArray[p])
            p = this.id(this.searchArray[p]);
        return p;
    }

    private boolean connected(int p, int q)
    {
        if(id(p) == id(q))
            return true;
        else
            return false;
    }

}
