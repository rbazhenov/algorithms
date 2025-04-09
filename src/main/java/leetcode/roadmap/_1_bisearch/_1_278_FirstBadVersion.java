package leetcode.roadmap._1_bisearch;

public class _1_278_FirstBadVersion {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (VersionControl.isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    static class VersionControl {
        static int ver = 3;

        static boolean isBadVersion(int version) {
            return ver < version;
        }
    }
}
