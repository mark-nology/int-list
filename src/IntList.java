public class IntList {
    private int contents[];
    private int size;

    public IntList(int size) {
        contents = new int[size];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int value) {
        contents[size] = value;
        size++;
    }

    public int[] getContents() {
        return contents;
    }

    public int getAt(int index) throws Exception {
        if (index < 0)
            throw new Exception("negative index: " + index);
        if (index >= size) {
            String message;
            if (size == 0)
                message = "for empty IntList";
            else
                message = "for " + size + " element array";
            throw new Exception("index " + index + " out of bounds " + message);
        }
        return contents[index];
    }
}
