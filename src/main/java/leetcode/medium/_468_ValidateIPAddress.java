package leetcode.medium;

public class _468_ValidateIPAddress {

    public static void main(String[] args) {
//        String queryIP = "172.16.254.1";
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String queryIP = "256.256.256.256";
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//        String queryIP = "0.0.0.0";
        String queryIP = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(queryIP));
    }

    public static String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isValidIPv4(String queryIP) {
        if (queryIP.length() > 3 * 4 + 3) {
            return false;
        }

        int cntDelimiter = 0;
        for (char ch : queryIP.toCharArray()) {
            if (ch == '.') {
                cntDelimiter++;
            }
        }
        if (cntDelimiter != 3) {
            return false;
        }

        String[] split = queryIP.split("\\.");
        if (split.length != 4) {
            return false;
        }

        for (String s : split) {
            if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0') || s.length() > 3) {
                return false;
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
                sb.append(ch);
            }

            if (Integer.parseInt(sb.toString()) > 255) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidIPv6(String queryIP) {
        if (queryIP.length() > 4 * 8 + 7) {
            return false;
        }

        int cntDelimiter = 0;
        for (char ch : queryIP.toCharArray()) {
            if (ch == ':'){
                cntDelimiter++;
            }
        }
        if (cntDelimiter != 7) {
            return false;
        }

        String[] split = queryIP.split(":");
        if (split.length != 8) {
            return false;
        }

        for (String s : split) {
            if (s.isEmpty() || s.length() > 4) {
                return false;
            }

            for (char ch : s.toCharArray()) {
                if (!Character.isLetterOrDigit(ch)) {
                    return false;
                }
                if (Character.isLetter(ch) && Character.toLowerCase(ch) > 'f') {
                    return false;
                }
            }
        }

        return true;
    }
}
