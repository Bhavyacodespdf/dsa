class Solution {
    class Pair{
        int dis;
        int ind;

        Pair(int d,int i){
            dis=d;
            ind=i;
        }
    }

    public int distance(int d1,int x){
        int a=Math.abs(d1-x);
        return a;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.dis!=b.dis) return b.dis-a.dis;
                else return b.ind-a.ind;
            }
        );

        for(int i=0;i<arr.length;i++){
            int x1=arr[i];
            int x2=distance(x1,x);
            pq.add(new Pair(x2,i));
            if(pq.size()>k) pq.poll();
        }

        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<k;i++){
            ans.add(arr[pq.poll().ind]);
        }

        Collections.sort(ans);

        return ans;

    }
}