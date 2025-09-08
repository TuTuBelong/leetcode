import java.util.*;

public class Main {
    public static int[] createArr(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int k : arr) {
            map.put(k, k);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int s = arr[i] + arr[j];
                if((s&1)==0){
                    map.put(s/2,s/2);
                }
            }
        }
        int[] a =new int[map.size()];
        List<Integer> list = new ArrayList<>();
        map.forEach((key,value)-> list.add(map.get(key)));
        for(int i= 0;i<map.size();i++){
            a[i]=list.get(i);
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int a = in.nextInt();
        int d = in.nextInt();
        in.close();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = a+i*d;
        }
        int k = 0;
        while(k != arr.length){
            k = arr.length;
            arr = createArr(arr);
        }
        System.out.println(arr.length);
    }
}