public class LC208Trie {

    public class TrieNode{
        public boolean isEnd;
        public TrieNode[] Child;

        public TrieNode() {
            this.isEnd = false;
            this.Child = new TrieNode[26];
        }
    }

    public TrieNode root;

    public LC208Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++){

            int offset = word.charAt(i) - 'a';

            if (cur.Child[offset] == null){
                TrieNode chi = new TrieNode();
                cur.Child[offset] = chi;
            }
            cur = cur.Child[offset];

            if (i == word.length() - 1){
                cur.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++){
            int offset = word.charAt(i) - 'a';

            if (cur.Child[offset]==null)return false;
            cur = cur.Child[offset];

            if (i == word.length() -1){
                return cur.isEnd;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++){
            int offset = prefix.charAt(i) - 'a';
            if (cur.Child[offset]==null)return false;
            cur = cur.Child[offset];

            if (i == prefix.length() - 1){
                if (cur.isEnd)return true;
                boolean ret = false;
                for (int j = 0; j < 26; j++){
                    ret = ret || cur.Child[j] == null;
                }
            }

        }
        return true;
    }

    public static void main(String... args){
        LC208Trie test = new LC208Trie();
        test.insert("apple");
        System.out.println(test.search("app"));
        System.out.println(test.startsWith("app"));
        test.insert("appl");
        System.out.println(test.search("appl"));
    }
}
