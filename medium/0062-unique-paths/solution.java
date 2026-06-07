    }


        int w1=grid(i+1,j,m,n);
        int w2=grid(i,j+1,m,n);

        return w1+w2;
    public int uniquePaths(int m, int n) {  
       int ans= grid(0,0,m,n);
        return ans;
    }
}
