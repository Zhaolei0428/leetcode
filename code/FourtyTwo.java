/**
 * Question Trapping Rain Water
 */
public class FourtyTwo {
//    private int water = 0;
//    public int trap(int[] height) {
//        if(height.length <= 2)
//            return 0;
//        int stub = findStub(height, 0, height.length-1);
//        if(stub > 1)
//            leftFind(height, stub-1);
//        if(stub <= height.length-3)
//            rightFind(height, stub+1);
//        return water;
//    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += left_max - height[left];
                ++left;
            }
            else {
                if(height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }

//    public void leftFind(int[] height, int right){
//        int stub = findStub(height, 0, right);
//        int sum = 0;
//        if(stub != right) {
//            for(int i = stub+1; i< right+1; i++)
//                sum += height[stub] - height[i];
//            water += sum;
//        }
//        if(stub>1)
//            leftFind(height, stub-1);
//    }
//
//    public void rightFind(int[] height, int left){
//        int stub = findStub(height, left, height.length-1);
//        int sum = 0;
//        if(stub != left) {
//            for(int i = left; i< stub; i++)
//                sum += height[stub] - height[i];
//            water += sum;
//        }
//        if(stub <= height.length-3)
//            rightFind(height, stub+1);
//    }
//
//    public int findStub(int[] height, int left, int right){
//        int stub = left;
//        for(int i = left +1; i<= right; i++) {
//            if(height[i] > height[stub])
//                stub = i;
//        }
//        return stub;
//    }

    public static void main(String[] args){
        FourtyTwo fourtyTwo = new FourtyTwo();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(fourtyTwo.trap(height));
    }
}
