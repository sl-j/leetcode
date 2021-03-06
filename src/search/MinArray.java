package search;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinArray {
    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3,1}));
    }
    public static int minArray(int[] numbers) {
        if (numbers.length == 1){
            return numbers[0];
        }
        int left = 0,right = numbers.length - 1;
        int mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
           if(numbers[mid] < numbers[right]){//mid小于right的值时，证明mid到right是有序的,最小值在mid和mid的左边，因为mid小于right
                right = mid;
           }else if(numbers[mid] > numbers[right]){//mid大于right时，证明left到right是有序的，最小值在右边，且mid一定不为最小值
               left = mid + 1;
           }else {//mid等于right，让right--(针对重复元素)
               right--;
           }
        }
        return numbers[right];
    }
}
