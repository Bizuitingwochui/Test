package apiday02;

import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi";
        String[] data = line.split("[0-9]+");       //按数字拆分（数字会被拆没）
        System.out.println(Arrays.toString(data));        //把data数组转换为字符串

        line = "123.456.778";
        data = line.split("\\.");                   //按 。 拆（。会被拆没）
        System.out.println(Arrays.toString(data));

        //如果一开始就是可拆分项，那么数组的第一个元素就为空字符串
        //如果宽信用两个或者两个以上可拆分项，那么中间也会存在一个空字符串
        //如果末尾有连续多个可拆分项，那么拆除的空字符串会被忽略
        line = ".123.456..788........";
        data = line.split("\\.");
        System.out.println(Arrays.toString(data));
    }
}
