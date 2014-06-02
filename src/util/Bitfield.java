package util;

import java.util.Arrays;

public final class Bitfield {
    long[] field;
    int size;
    
    //Bits are stored in right to left order, 63-0.
    
    public Bitfield(int size){
       this.size = size;
       if (size < 1)
           throw new IllegalArgumentException("Not allowed to be size less than 1.");
       
        field = new long[size / Long.SIZE];
    }
    
    public Bitfield(Bitfield b, int newSize){
        this.size = newSize;
       if (size < b.size)
           throw new IllegalArgumentException("Not allowed to be smaller than the orignal size.");
       
       field = Arrays.copyOf(field, newSize);
    }
    
    public boolean get(int i){
        if (i < 0 || i > size)
            throw new IndexOutOfBoundsException();
        
        int index = i / Long.SIZE;
        int offset = i % Long.SIZE;
        return field[index] >>> offset == 1;
    }
    
    public void set(int i, boolean b){
        if (i < 0 || i > size)
           throw new IndexOutOfBoundsException();
        
        int index = i / Long.SIZE;
        int offset = i % Long.SIZE;
        long v = b ? 1 : 0;
                
        field[index] |= ( v << offset);
    }
    
    public long[] array(){
        return Arrays.copyOf(field,field.length);
    }
}
