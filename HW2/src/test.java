/**
 * Created by Joon on 2016-02-02.
 */
public class test {
    public static int innerBytes(int num) {
        //num = 0x13DE8F9A;
        System.out.println((num >> 8) & 0xFFFF);
        System.out.println((num & 0x00FFFF00) >> 8);
        System.out.println(0xDE8F);
        return (num >> 8) & 0xFFFF;
    }
    public static void main(String[] args) {
        innerBytes(0x13DE8F9A);

    }
}