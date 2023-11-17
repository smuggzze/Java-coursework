
public class IterStuff {

    public static void main(String[] args){

        int [] nums = {3 ,5 ,7 ,9 ,10};
        int count = 0;

        for (int item = 0; item < nums.length; item ++){
            count += nums[item];

        }
        System.out.println(count);
    }



}
