public class arraydemo {
    public static void main(String[] args) {
        int[] numbers ={1,2,3,4,5};
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
            System.out.println("index:"+i);
            System.out.println("占用位元組:"+Integer.BYTES+"bytes");

        }
    }
}
