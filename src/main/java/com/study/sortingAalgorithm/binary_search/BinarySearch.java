package main.java.com.study.sortingAalgorithm.binary_search;

/**
 * @author: whb
 * @date: 2020/3/3 14:05
 * @description: 二分查找算法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 6, 6, 6, 6, 6, 8, 9};

        System.out.println("----------general-----------");

        System.out.println(normalBinarySearch(arr, 3));//1
        System.out.println(normalBinarySearch2(arr, 3));//1
        System.out.println(normalBinarySearch2(arr, 6));//5


        System.out.println("-----------first------------");

        //第一个 =  的
        System.out.println(firstEqual(arr, 6));//3

        //第一个　>= 的
        System.out.println(firstLargeEqual(arr, 5));//3
        System.out.println(firstLargeEqual(arr, 6));//3

        //第一个 > 的
        System.out.println(firstLarge(arr, 6));//9

        System.out.println("------------last------------");

        //最后一个 =  的
        System.out.println(lastEqual(arr, 6));//8

        // 最后一个 <= 的
        System.out.println(lastSmallEqual(arr, 7));//8
        System.out.println(lastSmallEqual(arr, 6));//8

        //最后一个 < 的
        System.out.println(lastSmall(arr, 6));//2
    }

    /**
     * 最基本的二分查找算法
     * 范围在[L,R]闭区间中，L = 0、R = arr.length - 1；
     * 注意循环条件为 L <= R ，而不是L < R；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int normalBinarySearch(int[] arr, int key) {
        //在[L,R]范围内寻找key
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] > key) {
                // key 在 [L,mid-1]内
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 最基本的二分查找算法二
     * 范围在[L,R)的左闭右开区间中
     * 此时的循环条件是L < R ，因为R本来是一个不可到达的地方，定义为了开区间，所以R是一个不会考虑的数，所以循环条件是L < R；
     * 同理，当arr[mid] > key的时候，不是R = mid - 1，因为定义的是开区间，所以R = mid ，因为不会考虑arr[mid]这个数；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int normalBinarySearch2(int[] arr, int key) {
        //注意这里R = arr.length 所以在[L,R)开区间中找
        int left = 0, right = arr.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] > key) {
                // 在[L,mid)中找
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
    /*********************************************************************************************************************************/

    /**
     * 找第一个=key的，不存在返回-1
     * 数组中可能有重复的key，要找的是第一个key的位置；
     * <p>
     * 和普通二分查找法不同的是在R = mid - 1前的判断条件不是arr[mid] > key，而是arr[mid] >= key，为什么呢？
     * <p>
     * 其实直观上理解，我们要找的是第一个，那去左边找的时候不仅仅arr[mid] > key就去左边找，等于也要去找，因为我要最左边的等于的；
     * <p>
     * 最后要判断L是否越界(L 有可能等于arr.length)，而且最后arr[L]是否等于要找的key；
     * <p>
     * 如果arr[L]不等于key，说明没有这个元素，返回-1；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int firstEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (arr[middle] >= key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left < arr.length && arr[middle] == key) {
            return left;
        }
        return -1;
    }

    /**
     * 查找第一个>=key的
     * 这个和上面那个寻找第一个等于key的唯一的区别就是:
     * <p>
     * 最后不需要判断( L < arr.length && arr[L] == key)，因为如果不存在key的话，返回第一个> key的元素即可；
     * <p>
     * 注意这里没有判断越界(L < arr.length )，因为如果整个数组都比key要小，就会返回arr.length的大小；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int firstLargeEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] >= key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 查找第一个>key的
     * 这个和上两个的不同在于:
     * <p>
     * if(arr[mid] >= key) 改成了 if(arr[mid] > key)，因为我们不是要寻找 = key的；
     * <p>
     * 看似和普通二分法很像，但是在循环中没有判断if(arr[mid] == key)就返回mid(因为要寻找的不是等于key的)，而是在最后返回了L ；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int firstLarge(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] > key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 第一个...的总结
     * 上面写了三个第一个.....的程序，可以发现一些共同点 ，也可以总结一下它们微妙的区别:
     * <p>
     * 最后返回的都是L；
     * <p>
     * 如果是寻找第一个等于key的，是if( arr[mid] >= key) R = mid - 1，且最后要判断L 的合法以及是否存在key；
     * <p>
     * 如果是寻找第一个大于等于key的，也是if(arr[mid] >= key) R = mid - 1，但是最后直接返回L；
     * <p>
     * 如果是寻找第一个大于key的，则判断条件是if(arr[mid] > key) R = mid - 1，最后返回L ；
     */

    /**
     * 最后一个=key的，不存在返回-1
     * 和寻找第一个 = key的很类似，不过是方向的不同而已:
     * <p>
     * 数组中有可能有重复的key，要查找的是最后一个 = key的位置，不存在返回-1；
     * <p>
     * 为了更加的直观的理解，和寻找第一个...的形成对比，这里是当arr[mid] <= key的时候，要去右边查找(L = mid + 1)，同样是直观的理解，因为是要去找到最后一个 = key的，所以不仅仅是arr[mid] < key要去左边寻找，等于key的时候也要去左边寻找；
     * <p>
     * 和第一个....不同的是，返回的都是R；
     * <p>
     * 同时也要判断R的下标的合法性，以及最后的arr[R]是否等于key，如果不等于就返回-1；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int lastEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] <= key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (right >= 0 && arr[right] == key) {
            return right;
        }
        return -1;
    }

    /**
     * 最后一个<=key的
     * 这个和上面那个寻找最后一个等于key的唯一的区别就是:
     * <p>
     * 最后不需要判断 (R >= 0 && arr[R] == key)，因为如果不存在key的话，返回最后一个 < key的元素即可；
     * <p>
     * 注意这里没有判断越界(R >= 0 )，因为如果整个数组都比key要大，数组最左边的更左边一个(也就是-1)；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int lastSmallEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] <= key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    /**
     * 最后一个<key 的
     * 这个和上面两个不同的是:
     * <p>
     * 和上面的程序唯一不同的就是arr[mid] <= key改成了 arr[mid] < key，因为要寻找的不是 = key的；
     * <p>
     * 注意这三个最后一个的都是先对L的操作L = mid + 1，然后在else 中进行对R的操作；
     *
     * @param arr
     * @param key
     * @return
     */
    public static int lastSmall(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    /**
     * 最后一个...的总结
     * 上面三个都是求最后一个.....的，也进行一下总结:
     *
     * 最后返回的都是R；
     *
     * 第一个if判断条件(不管是arr[mid] <= key还是arr[mid] < key) ，都是L的操作，也就是去右边寻找；
     *
     * 如果是寻找最后一个 等于 key的， if(arr[mid] <= key) L = mid + 1; 不过最后要判断R的合法性以及是否存在key；
     *
     * 如果是寻找最后一个 小于等于 key的，也是if(arr[mid] <= key) L = mid + 1；不过最后直接返回R；
     *
     * 如果是寻找最后一个 小于 key的，则判断条件是 if(arr[mid] < key) L = mid + 1 ，最后返回R；
     */
}
