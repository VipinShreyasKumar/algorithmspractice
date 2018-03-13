package coursera.com.course.algorithms1.union.problemset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by vipin on 3/13/2018.
 *
 * Social network connectivity. Given a social network containing n members
 * and a log file containing m timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */


public class SocialNetworkConnectivity {


    private static final String TAG = SocialNetworkConnectivity.class.getSimpleName();

    private static final String glob_inputargFName = "C:\\Users\\212581066\\vipin_repo\\algorithmspractice\\Coursera_Algorithms_Princeton\\src\\coursera\\com\\course\\algorithms1\\union\\problemset\\socnetwork_inputfeed.txt";

    private static final int numberofconnections = 10;
    public static void main(String[] args)
    {
        System.out.println(TAG);
        new SocialNetworkConnectivity().getinputs();

    }




    private void getinputs(){

        QuickUnionDS qDs = new QuickUnionDS(numberofconnections);
        try(Stream<String> fStream = Files.lines(Paths.get(glob_inputargFName))){
                fStream.forEach((String sVal) ->qDs.processLine(sVal));
        }
        catch(IOException loc_ioex)
        {
            loc_ioex.printStackTrace();
        }

    }


    @FunctionalInterface
    private interface LineProcessor{

        abstract void processLine(String loc_linearg);
    }

    private class QuickUnionDS implements LineProcessor {

        private final String TAG = QuickUnionDS.class.getSimpleName();


        private int[] connectArray = new int[]{0,1,2,3,4,5,6,7,8,9};
        private int[] sizeArray = new int[]{1,1,1,1,1,1,1,1,1,1};

        private int max_connections ;

        private boolean terminateop = false;

        private String connectTS = "";

        QuickUnionDS(int max_connections){
            this.max_connections = max_connections;
        }


        @Override
        public void processLine(String loc_linearg) {

            //split string with whitespace
            if(!terminateop) {
                if (loc_linearg != null && loc_linearg.length() > 0) {
                    String[] splitArray = loc_linearg.split(" ");
                    int conn01 = Integer.parseInt(splitArray[0]);
                    int conn02 = Integer.parseInt(splitArray[1]);
                    this.connectTS = String.join(splitArray[2], splitArray[3]);
                    //System.out.println(timeStampVal);
                    this.union(conn01, conn02);
                    System.out.println(Arrays.toString(this.connectArray));
                    System.out.println(Arrays.toString(this.sizeArray));

                }
            }
        }


        private int id(int p){
            while(p != connectArray[p])
            {
                p = this.id(connectArray[p]);

            }
            return p;
        }

        private int weight(int p ){
            return this.sizeArray[p];
        }

        private void union(int p, int q){

            int loc_id_p = this.id(p);
            int loc_id_q = this.id(q);

            if(loc_id_p != loc_id_q)
            {
                int loc_weight_p = this.weight(loc_id_p);
                int loc_weight_q = this.weight(loc_id_q);

                if(loc_weight_q >= loc_weight_p)
                {
                    //attach p to q as p is the smaller tree
                    this.sizeArray[loc_id_q] += this.sizeArray[loc_id_p];
                    connectArray[loc_id_p] = loc_id_q;
                    if(this.sizeArray[loc_id_q] == this.max_connections)
                    {
                        System.out.println("Absolute connect completed at "+this.connectTS);
                        this.terminateop = true;
                    }

                }
                else
                {
                    //attach q to p as q is the smaller tree
                    this.sizeArray[loc_id_p] += this.sizeArray[loc_id_q];
                    connectArray[loc_id_q] = loc_id_p;
                    if(this.sizeArray[loc_id_p] == this.max_connections)
                    {
                        System.out.println("Absolute connect completed at "+this.connectTS);
                        this.terminateop = true;
                    }
                }
            }
        }

        private boolean connected(int p , int q)
        {
            return this.id(p) == this.id(q);
        }
    }

}
