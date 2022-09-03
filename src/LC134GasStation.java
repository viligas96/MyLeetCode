public class LC134GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len==1)return gas[0] >= cost[0]?0:-1;
        int ret = -1;


        for (int i = 0; i < len; i++){
            if (travel(i, gas, cost)){
                ret = i;
                break;
            }
        }
        return ret;
    }

    public static boolean travel(int i, int[] gas, int[] cost){
        int curgas = gas[i] - cost[i];
        if (curgas < 0)return false;

        int j = i + 1;
        if (j >= gas.length){
            j -= gas.length;
        }

        while (j != i){
            curgas = curgas + gas[j] - cost[j];
            if (curgas < 0){
                return false;
            }
            j++;
            if (j >= gas.length){
                j -= gas.length;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));

    }
}
