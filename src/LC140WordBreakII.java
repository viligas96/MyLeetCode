import java.util.*;
public class LC140WordBreakII {
    static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {

            TrieNode root = new TrieNode();

            // Add Words
            for(String word : wordDict){
                TrieNode node = root;
                char[] arr = word.toCharArray();
                for(int index =0; index < arr.length; index++){

                    TrieNode childNode = node.getChild(arr[index]);
                    if(childNode == null) node.addChild(arr[index]);
                    node = node.getChild(arr[index]);
                    if(index == arr.length-1)   node.markEnd(word);
                }
            }

            char[] arr = s.toCharArray();

            List<List<String>> result = new ArrayList();
            search(root, root, arr, 0, new ArrayList(), result);

            List<String> finalResult = new ArrayList();
            for(List<String> temp : result){
                finalResult.add(String.join(" ", temp));
            }
            return finalResult;

        }



        public boolean search(TrieNode root, TrieNode node, char[] arr, int index, List<String> chain, List<List<String>>result){

            if(index == arr.length){
                if(node.end){
                    chain.add(node.word);
                    result.add(chain);
                }
                return node.end;
            }

            if(node != null && node.childs != null && node.childs.isEmpty() == false){

                TrieNode nextMatchedNode = node.getChild(arr[index]);
                if( nextMatchedNode != null){
                    boolean isPossibleFromEnd = false;
                    if(nextMatchedNode.end){
                        List<String> newChain = new ArrayList(chain);
                        newChain.add(nextMatchedNode.word);
                        isPossibleFromEnd = search(root, root, arr, index+1, newChain, result);
                    }
                    boolean isPossible = search(root,nextMatchedNode, arr, index+1, chain, result);
                    return isPossible || isPossibleFromEnd;
                }
            }
            return false;
        }



        class TrieNode{

            Character value;
            HashMap<Character, TrieNode> childs;
            boolean end;
            String word;

            public TrieNode(){
                this.value = null;
                this.childs = new HashMap<Character, TrieNode>();
            }

            public TrieNode(Character value){
                this.value = value;
                this.childs = new HashMap<Character, TrieNode>();
            }

            public TrieNode getChild(Character c){
                return childs.get(c);
            }

            public void addChild(Character c){
                childs.put(c, new TrieNode(c));
            }

            public void markEnd(String word){
                this.end = true;
                this.word = word;
            }

        }
    }
}
