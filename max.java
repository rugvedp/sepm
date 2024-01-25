class Solution {
    int countBits(int num) {
        int count = 0;
        while(num>0){
            if(num%2 == 1) count++;
            num/=2;
        }
        return count;
    }

    int solve(List<Integer> list, int i,int ans) {
        if(i==list.size()) return countBits(ans);

        int take = 0;
        if((list.get(i)&ans) == 0 || ans == 0)
            take = solve(list,i+1,(list.get(i)|ans));
        
        int not = solve(list,i+1,ans);
        return Math.max((take),(not));
    }

    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for(String s: arr) {
            int curr = 0;

            for(char c : s.toCharArray()){
                int temp = 1 << (c - 'a');
                if((curr&temp) > 0) {
                    curr = 0;
                    break;
                } 
                else curr = (curr | temp);
            }
            if (curr != 0) list.add(curr);
        }
        return solve(list,0,0);
    }
}