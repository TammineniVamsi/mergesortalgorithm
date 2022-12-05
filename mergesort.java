public class mergesortalgo {
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void mergesort(int arr[],int si,int ei){
        //base case 
        if(si>=ei){
            return;
        }
        //work
        int mid=(si+ei)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    //function for merging the sorted parts 
    public static void merge(int arr[],int si,int mid,int ei){
        //create a temp array
        int temp[]=new int[ei-si+1];
        int i=si; //index for left part
        int j=mid+1; //index for right part
        int k=0; //index for temp

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //for left over elements in left
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //for left over right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy all elements for temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }

    }
    public static void main(String args[]){
        int arr[] = { 6, 3, 9, 5, 2, 8,-2 };
        mergesort(arr,0,arr.length-1);
        printarr(arr);
    }
    
}
