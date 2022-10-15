public class LC191NumOfBit {
    public int hammingWeight(int n) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            if ((n & 1)== 1)ret++;
            n = n >> 1;
        }

        return ret;
    }
}
