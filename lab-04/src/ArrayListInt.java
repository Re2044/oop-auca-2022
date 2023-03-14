public class ArrayListInt {
    private int[] val = new int[0];
    private int capacity = 0;
    private int size = 0;
    public int size(){return this.size;}
    public int get(int index){return val[index];}
    public void set(int index,int value){val[index]=value;}
    public void add(int value){if(size+1>capacity){ ExtendArray();}size++;val[size-1]=value;}
    public void add(int index,int value){
        if(size+1>capacity){
            size++;
            capacity++;
            int[] semiVal = new int[capacity];
            for(int i = 0;i<size;i++){
                if(i<index)
                    semiVal[i]=val[i];
                else{
                    if(i==index){
                        semiVal[i]=value;
                    }
                    else
                        semiVal[i]=val[i-1];
                }
            }
            val=semiVal;
        }
        else{
            size++;
            int prev = val[index];
            val[index]=value;
            for(int i = index+1;i<size;i++){
                int cur = val[i];
                val[i] = prev;
                prev = cur;
            }

        }
    }
    public void remove(int index){
        size--;
        for(int i = index;i<size;i++){
            val[index]=val[index+1];
        }
    }
    private void ExtendArray(){
        capacity++;
        int[] semiVal = new int[capacity];
        for(int i = 0;i<size;i++){
            semiVal[i]=val[i];
        }
        val=semiVal;
    }
}
