import sun.awt.X11.XSystemTrayPeer;

public class SegmentTree {

    int ST[];

    SegmentTree(int arr[],int n){

        int x= (int) Math.ceil(  Math.log(n)/Math.log(2)         );

        int st_size=  2* (int)Math.pow(x,2) -1;


        ST=new int[st_size];

        buildSegmentTreeUtil(arr,0,n-1,0);

    }

    public int getSumLtoR(int n,int l,int r){

        if(l<0 ||r>=n ||l>r){
            System.out.println("invalid input  .......");
            return -1;
        }

       return getSumUtil(0,n-1,l,r,0);

    }

    private int getSumUtil(int sl, int sr, int l, int r, int i) {


        //if query overlap segment range then return sum of
        if(l<=sl && r>=sr){
            return ST[i];
        }
        //query outside segment
        if(r<sl || l>sr)
        {
            return 0;
        }
        //overlap segment....
        int mid=getMid(sl,sr);


        return getSumUtil(sl,mid,l,r,2*i+1) +getSumUtil(mid+1,sr,l,r,2*i+2);


    }

    private int buildSegmentTreeUtil(int[] arr, int l, int r, int i) {

        if(l==r){
            ST[i]=arr[r];
            return arr[r];
        }

        int mid=getMid(l,r);

        ST[i]=buildSegmentTreeUtil(arr,l,mid,2*i+1)+ buildSegmentTreeUtil(arr,mid+1,r,2*i+2);

        return ST[i];
    }

    private int getMid(int l, int r) {
            return (l+(r-l)/2);
    }

    public static void main (String args[]){

        int arr[]={1,2,3   ,4,5,6   ,10,11    ,12,13};
        SegmentTree st=new SegmentTree(arr,arr.length);

        System.out.println(arr.length);

        System.out.println(st.getSumLtoR(arr.length,1,1));

        int new_val=30,index=2;
        st.updateVal(arr,arr.length,index,new_val);

        for (int i=0;i<st.ST.length;i++){
            System.out.print(+st.ST[i]+" ");

        }
        for(int i:arr)
        System.out.println(i);



    }

    private void updateVal(int[] arr, int n, int index, int new_val) {

        if(index<0 || index>=n){
            System.out.println("error in input...");
            return;
        }


        int diff=new_val-arr[index];
        arr[index]=new_val;

        updateValueUtil(diff,index,0,n-1,0);

        int curr_node=0;



    }

    private void updateValueUtil(int diff, int index, int sl,int sr,int i) {

        if(index<sl|| index>sr){
            return;
        }

        ST[i]+=diff;

        if(sl<sr) {
            int mid = getMid(sl, sr);
            updateValueUtil(diff, index, sl, mid, 2 * i + 1);
            updateValueUtil(diff, index, mid + 1, sr, 2 * i + 2);
        }

    }


}
