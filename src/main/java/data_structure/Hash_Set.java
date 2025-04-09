package data_structure;

public class Hash_Set {
    public static void main(String[] args) {
        MyHashSetImpl set = new MyHashSetImpl();
        set.add(0);
        set.add(3);
        set.add(87);
        set.add(17);
        set.add(18);
        set.add(19);
        set.add(20);
        System.out.println(set);

        set.remove(3);
        set.remove(17);
        System.out.println(set);
    }


    interface MySet {

        void add(int num);

        boolean contains(int num);

        void remove(int num);

        int size();
    }

    static class MyHashSetImpl implements MySet {
        int capacity;
        int[][] arr;

        public MyHashSetImpl() {
            arr = new int[4][];
        }

        public void add(int num) {
            if (!contains(num)) {
                int hash = hash(num);
                increaseInnerSize(hash);
                arr[hash][arr[hash].length - 1] = num;
                capacity++;
            }

            //заполняемость > x%
            if ((float) capacity / arr.length > 0.49f) {
                increaseArraySize();
            }
        }

        private void increaseInnerSize(int hash) {
            int[] newInner;
            if (arr[hash] == null) {
                newInner = new int[1];
            } else {
                newInner = new int[arr[hash].length + 1];
                System.arraycopy(arr[hash], 0, newInner, 0, arr[hash].length);
            }
            arr[hash] = newInner;
        }

        private void increaseArraySize() {
            int[][] newArr = new int[arr.length * 2][];
            int[][] oldArr = new int[arr.length][];
            System.arraycopy(arr, 0, oldArr, 0, arr.length);
            arr = newArr;

            for (int[] nums : oldArr) {
                if (nums != null) {
                    for (int j = 0; j < nums.length; j++) {
                        int hash = hash(nums[j]);
                        increaseInnerSize(hash);
                        newArr[hash][newArr[hash].length - 1] = nums[j];
                    }
                }
            }
        }

        public boolean contains(int num) {
            return getInnerIndex(num) != -1;
        }

        private int getInnerIndex(int num) {
            int[] nums = arr[hash(num)];
            if (nums != null) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == num) {
                        return i;
                    }
                }
            }

            return -1;
        }

        public void remove(int num) {
            int innerIndex = getInnerIndex(num);
            if (innerIndex != -1) {
                int hash = hash(num);
                arr[hash][innerIndex] = arr[hash][arr[hash].length - 1];
                int[] newInner = new int[arr[hash].length - 1];
                System.arraycopy(arr[hash], 0, newInner, 0, newInner.length);
                arr[hash] = newInner;
            }
        }

        private int hash(int num) {
            return num % arr.length;
        }

        public int size() {
            return capacity;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                builder.append("[").append(i).append("]-[");
                int[] nums = arr[i];
                if (nums == null) {
                    builder.append(" ]  ");
                    continue;
                }
                for (int j = 0; j < nums.length; j++) {
                    builder.append(nums[j]);
                    if (j + 1 != nums.length) {
                        builder.append(", ");
                    }
                }
                builder.append("]  ");

            }
            return builder.toString();
        }
    }
}

