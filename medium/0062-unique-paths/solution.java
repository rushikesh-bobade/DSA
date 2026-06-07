            return 1;
        if(i==m-1||j==n-1){
        
    public int grid(int i,int j,int m,int n){
        }else if(i==m||j==n){
            return 0;
        }

        int w1=grid(i+1,j,m,n);
        int w2=grid(i,j+1,m,n);

        return w1+w2;
    }

    public int uniquePaths(int m, int n) {  
       int ans= grid(0,0,m,n);
