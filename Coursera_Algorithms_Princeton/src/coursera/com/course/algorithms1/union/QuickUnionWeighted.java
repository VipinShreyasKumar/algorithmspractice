package coursera.com.course.algorithms1.union;

/**
 * Created by 212581066 on 3/7/2018.
 */

import java.util.Arrays;

/**
 * Objective of this optimization is to ensure that during a Union Operation(p,q)
 * we compute the size of both the trees p and q and attach the smaller tree to the
 * root of the larger tree. This helps in minimizing the average distance of any node
 * from the root. This is called Weighted Quick Union
 *
 * The Algorithm implementation remains the same with an extra array to store the
 * size of the root.
 * During each union operation U(p,q) the size array[p] and size_array[q] values are compared
 * and if size_array[p] > size_array[q] then the size_array[p] is updated with the value
 * size_array[p] = size_array[p] + size_array[q]
 */

public class QuickUnionWeighted implements Runnable {


    private static final String TAG = QuickUnion.class.getSimpleName();

    int [] unionArray ;

    int [] sizeArray;

    public QuickUnionWeighted(int[] loc_inputArray){

        this.unionArray = loc_inputArray;

        //initialize the size array with 0
        this.sizeArray = new int[loc_inputArray.length];
        for(int i= 0 ; i < sizeArray.length ; i++)
        {
            sizeArray[i] = 1;
        }
    }


    @Override
    public void run() {

        System.out.println(Arrays.toString(this.unionArray));
        union(4,3);
        union(3,8);
        union(6,5);
        union(9,4);
        union(2,1);

        union(5,0);
        union(7,2);
        union(6,1);
        union(7,3);
        System.out.println(Arrays.toString(this.unionArray));
        //System.out.println(Arrays.toString(this.sizeArray));

        System.out.println(connected(8,9));
        System.out.println(connected(5,4));

    }

    private void union(int p , int q)
    {
        int loc_id_p = id(p);
        int loc_id_q = id(q);
        int loc_weight_p = weight(loc_id_p);
        int loc_weight_q = weight(loc_id_q);

        if(loc_weight_q >= loc_weight_p)
        {
            //System.out.println(Arrays.toString(this.sizeArray));
            this.sizeArray[loc_id_q] += this.sizeArray[loc_id_p];
            this.unionArray[p] = loc_id_q;
        }
        else{

            //System.out.println(Arrays.toString(this.sizeArray));
            this.sizeArray[loc_id_p] += this.sizeArray[loc_id_q];
            this.unionArray[q] = loc_id_p;
        }

        //this.unionArray[loc_id_p] = this.unionArray[loc_id_q];


    }

    private int id(int p)
    {
        while(p != this.unionArray[p])
            p = this.id(this.unionArray[p]);
        return p;
    }

    private int weight(int p)
    {
        return this.sizeArray[p];
    }

    private boolean connected(int p, int q)
    {
        if(id(p) == id(q))
            return true;
        else
            return false;
    }

}
