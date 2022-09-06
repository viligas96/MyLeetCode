import java.util.*;
public class LC146LRUCache {
    public int[] key = new int[(int)Math.pow(10, 4) + 1];

    public HashMap<Integer, Integer> map = new HashMap<>();

    public int size = 0;
    public int capacity = 0;
    public int LRU_index = 0;
    public LC146LRUCache(int capacity) {
        if (capacity <= 0)return;
        this.capacity = capacity;
        for (int i = 0; i < (int)Math.pow(10, 4) + 1; i++){
            this.key[i] = -1;
        }
    }

    public int get(int key) {
        //To do: 更新LRU
        if (this.key[key] != -1){
            map.put(key, map.get(key) + 1);
        }
        return this.key[key];
    }

    public void put(int key, int value) {
        if (this.capacity == this.size){
            //To do: 若缓存已满，找到当前LRU
            this.key[this.LRU_index] = -1;
        }
        //To do: 更新LRU
        this.key[key] = value;
    }
    /// Using LinkedHashMap
}