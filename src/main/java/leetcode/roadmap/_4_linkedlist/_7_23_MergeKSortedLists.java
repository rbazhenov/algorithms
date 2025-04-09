package leetcode.roadmap._4_linkedlist;

import java.util.HashMap;
import java.util.Map;

//можно было привести любое количество связ. списков к слиянию только двух.
public class _7_23_MergeKSortedLists {
    public static void main(String[] args) {
//        int[] nums1 = {1, 4, 5};
//        ListNode head1 = ListNode.createHead(nums1);
//
//        int[] nums2 = {1, 3, 4};
//        ListNode head2 = ListNode.createHead(nums2);
//
//        int[] nums3 = {2, 6};
//        ListNode head3 = ListNode.createHead(nums3);
//
//        ListNode[] lists = {head1, head2, head3};
//        ListNode merged = mergeKLists(lists);

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6, 7};
        ListNode node1 = ListNode.createHead(nums1);
        ListNode node2 = ListNode.createHead(nums2);
        ListNode[] lists = {node1, node2};
        ListNode merged = mergeKLists(lists);

        System.out.println(merged);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        MinHeap minHeap = new MinHeap();
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.insert(list.val);
                list = list.next;
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }

        ListNode merged = new ListNode();
        merged.val = minHeap.extract();

        ListNode current = merged;
        while (!minHeap.isEmpty()) {
            int extracted = minHeap.extract();
            current.next = new ListNode(extracted);
            current = current.next;
        }

        return merged;
    }

    static class MinHeap {
        int[] arr;
        int lastIndex;
        Map<Integer, Integer> val2index;
        Map<Integer, Integer> cnt;

        public MinHeap() {
            clear();
        }

        public void clear() {
            arr = new int[10];
            lastIndex = -1;
            val2index = new HashMap<>();
            cnt = new HashMap<>();
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

        private void resize() {
            if (lastIndex < arr.length - 1) {
                return;
            }

            int newLen = arr.length * 2;
            int[] newArr = new int[newLen];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }

        private int siftingUp() {
            int movedItemIndex = lastIndex;
            int parentIndex = (movedItemIndex - 1) / 2;
            while (movedItemIndex != 0 && arr[parentIndex] > arr[movedItemIndex]) {
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
                    boolean needToSwap = child1Index <= lastIndex && arr[movedItemIndex] > arr[child1Index];
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
                    boolean needToSwap = arr[movedItemIndex] > Math.min(arr[child1Index], arr[child2Index]);
                    if (!needToSwap) {
                        break;
                    }

                    int temp = arr[movedItemIndex];
                    if (arr[child1Index] > arr[child2Index]) {
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

        public boolean isEmpty() {
            return lastIndex == -1;
        }
    }
}
