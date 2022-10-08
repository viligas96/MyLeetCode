public class LC171ExcelSheet {
    public static int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int ret = 0;
        for(int i = 0; i < len; i++){
            ret += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
        }
        return ret;
    }
    public static void main(String... args){
        System.out.println(titleToNumber("ZY"));
    }
}
