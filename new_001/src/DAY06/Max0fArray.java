package DAY06;

import java.util.Arrays;

public class Max0fArray {
    public static void main(String[] args) {
//        int [] arr = new int[10];
//        for (int i=0;i<arr.length;i++){
//            arr [i]=(int) (Math.random()*100);
//            System.out.println(arr[i]);
//        }
//
//        //找最大值
////        int max = (int)(Arrays.stream(arr).max());
////        System.out.println("最大值为："+max);
//
//        int max = arr[0];
//        int min = arr[0];
//        int sum = 0;
//        for (int i=1;i<arr.length;i++){
//            if (arr[i]>max){
//                max = arr[i];
//            }
//            if (arr[i]<min){
//                min = arr[i];
//            }
//            sum += arr[i];
//        }
//        System.out.println("最大值为："+max);
//        System.out.println("最小值为；"+min);
//        System.out.println("总和为："+sum);
//
//
//        //数组的复制
//        int[] a = {10,20,30,40,50};
//        int[] b = new int[6];
//
//        System.arraycopy(a,1,b,0,4);    //灵活性好
        // a:源数组 1：源数组的起始下标 b:目标的胡须 0：目标数组的起始下标 4：要复制的元素个数

//        for (int i=0;i<b.length;i++){
//            System.out.println(b[i]);
//        }
//
//        int[] c = Arrays.copyOf(a,6);           //灵活性差
//        a = Arrays.copyOf(a,a.length+1);        //数组的扩容实际是创建一个更大的新数组
//        for (int i=0;i<c.length;i++){
//            System.out.println(c[i]);
//        }

        int[] arr = new int[10];
        int max =0;
        for (int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*100);
            System.out.println(arr[i]);
            if (arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("最大值为："+max);
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = max;
        for (int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*100);
            System.out.println(arr[i]);
        }


        //排序
        //常见的排序：冒泡排序、快速排序、选择排序、插入排序、希尔排序

        Arrays.sort(arr);       //从小到大排序








    }
}
