public class Optiver {
    static int totalYear(int year) throws Exception {
        int ret = 0;
        for (int i = 1; i < 13; i++){
            ret += DaysInMonth(i, year);
        }
        return ret;
    }

    static int firstHalf(int month, int year, int day) throws Exception{
        int ret = 0;
        for (int i = 1; i < month; i++){
            ret += DaysInMonth(i, year);
        }
        ret += day;
        return ret;
    }

    static int secondHalf(int month, int year, int day) throws Exception{
        int ret = 0;
        for (int i = month; i < 13; i++){
            ret += DaysInMonth(i, year);
        }
        ret -= day;
        return ret;
    }

    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        int ret = 0;
        if (year1 == year2){
            for (int i = month1; i < month2; i++){
                ret += DaysInMonth(i, year1);
            }
            ret -= day1;
            ret += day2;
        } else{
            ret += secondHalf(month1, year1, day1);

            for (int i = year1+1; i < year2; i++){
                ret += totalYear(i);
            }

            ret += firstHalf(month2, year2, day2);
        }
        return ret;
    }

    static int DaysInMonth(int month, int year) throws Exception {
        return 31;
    }
}
