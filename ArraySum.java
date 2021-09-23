package SumOf;
public class ArraySum {
    public int sumOfArray(Integer[] array, int size) {
        if (size <= 0) {
            return 0;
        } else {
        	int sum = 0;
            for(int i = 0; i<=size; i++)
        	sum += array[i];
        	return sum;
        }
    }
}