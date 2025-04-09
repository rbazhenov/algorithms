package yandex.course_2.lesson_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _19_Heap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        MyHeap myHeap = new MyHeap();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int operation = Integer.parseInt(split[0]);
            if (operation == 0) {
                Integer val = Integer.parseInt(split[1]);
                myHeap.insert(val);
            } else if (operation == 1) {
                System.out.println(myHeap.extract());
            }
        }
    }

    //first is the biggest
    static class MyHeap {
        int[] arr;
        int lastIndex;
        Map<Integer, Integer> val2index;
        Map<Integer, Integer> cnt;

        public MyHeap() {
            clear();
        }

        public void insert(int k) {
            if (val2index.containsKey(k)) {
                cnt.put(k, cnt.get(k) + 1);
            } else {
                resize();
                arr[++lastIndex] = k;
                val2index.put(k, lastIndex);
                cnt.put(k, 1);
                siftingUp();
            }
        }

        public int extract() {
            int first = arr[0];
            if (cnt.get(first) > 1) {
                cnt.put(first, cnt.get(first) - 1);
            } else {
                siftingDown();
                if (lastIndex == -1) {
                    clear();
                }
                cnt.remove(first);
                val2index.remove(first);
            }

            return first;
        }

        private void clear() {
            arr = new int[1];
            lastIndex = -1;
            val2index = new HashMap<>();
            cnt = new HashMap<>();
        }

        private void resize() {
            if (lastIndex < arr.length - 1) {
                return;
            }

            int newLen = arr.length * 2;
            int[] newArr = new int[newLen];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }

        //check heap properties
        //push new to the top
        private int siftingUp() {
            int movedItemIndex = lastIndex;
            int parentIndex = (movedItemIndex - 1) / 2;
            while (movedItemIndex != 0 && arr[parentIndex] < arr[movedItemIndex]) {
                int temp = arr[movedItemIndex];

                val2index.put(arr[parentIndex], movedItemIndex);
                arr[movedItemIndex] = arr[parentIndex];

                val2index.put(temp, parentIndex);
                arr[parentIndex] = temp;

                movedItemIndex = parentIndex;
                parentIndex = (movedItemIndex - 1) / 2;
            }

            return movedItemIndex;
        }

        private void siftingDown() {
            arr[0] = arr[lastIndex--];
            int movedItemIndex = 0;
            int child1Index = 1;
            int child2Index = 2;

            //has only one child
            while (movedItemIndex < lastIndex) {
                if (child2Index > lastIndex) {
                    boolean needToSwap = arr[movedItemIndex] < arr[child1Index];
                    if (!needToSwap) {
                        break;
                    }

                    int temp = arr[movedItemIndex];
                    val2index.put(arr[child1Index], movedItemIndex);
                    arr[movedItemIndex] = arr[child1Index];

                    val2index.put(temp, child1Index);
                    arr[child1Index] = temp;

                    movedItemIndex = child1Index;
                } else {
                    boolean needToSwap = arr[movedItemIndex] < Math.max(arr[child1Index], arr[child2Index]);
                    if (!needToSwap) {
                        break;
                    }

                    int temp = arr[movedItemIndex];
                    if (arr[child1Index] < arr[child2Index]) {
                        val2index.put(arr[child2Index], movedItemIndex);
                        arr[movedItemIndex] = arr[child2Index];
                        val2index.put(temp, child2Index);
                        arr[child2Index] = temp;
                        movedItemIndex = child2Index;
                    } else {
                        val2index.put(arr[child1Index], movedItemIndex);
                        arr[movedItemIndex] = arr[child1Index];

                        val2index.put(temp, child1Index);
                        arr[child1Index] = temp;

                        movedItemIndex = child1Index;
                    }

                    child1Index = 2 * movedItemIndex + 1;
                    child2Index = 2 * movedItemIndex + 2;
                }
            }
        }
    }
}
