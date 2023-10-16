package DAY05;

public class ArrayDemo {
    public static void main(String[] args) {
//        int[] arr1 = new int[5];                //整形数组arr1，包含5个元素，每个元素都是int型。默认值  0
//        double[] arr2 = new double[20];         //浮点型数组arr2，包含20个元素，每个元素都是double型。默认值  0.0
//        boolean[] arr3 = new boolean[26];       //布尔型数组arr2，包含26个元素，每个元素都是boolen型。默认值  flase
//        // byte short int long char -------0
//        // float  double-------------------0.0
//        //boolean -------------------------flase
//
//        int[] arr4 = new int[3];
//        int[] arr5 = {1,4,7};
//        int[] arr6 = new int[]{1,4,7};
//        int[] arr7;
//        arr7 = new int[]{1,4,7};


        //访问：   数组名.length 可以获取数组的长度
        //通过标号来访问，从0开始，最大到（数组的长度-1）
//        int[] arr = new int[3];
//        arr[0] = 100;             //arr[0] 是int型 代表 arr中的第一个元素
//        arr[1] = 200;
//        arr[2] = 300;
//        System.out.println("这个数组的长度为："+arr.length);
//        System.out.println(arr[arr.length-1]);

        int[] arr = new int[10];
        for (int i=0; i < arr.length;i++){
            arr[i] = (int) (Math.random()*100);
            System.out.println("第"+i+"个数据为："+arr[i]);
        }




    }
}
