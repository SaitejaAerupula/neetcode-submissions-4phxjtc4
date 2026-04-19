class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        List<Integer>[] buc = new List[nums.length + 1];
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(buc[freq]== null){
                buc[freq]= new ArrayList<>();
            }
            buc[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i  = buc.length - 1;i>= 0 && res.size() < k;i--){
            if(buc[i]!=null){
                res.addAll(buc[i]);
            }
        }
        int [] ans = new int[k];
        for(int i = 0;i< k; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
