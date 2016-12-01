// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashIntSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;

    // Constructs an empty set.
    public HashIntSet() {
        elementData = new HashEntry[10];
        size = 0;
    }

    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }

            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry(value, elementData[bucket]);
            size++;
        }
    }

    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }

    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data == value) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry current = elementData[bucket];
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }

                // if the element is found, remove it
                if (current.next != null && current.next.data == value) {
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }

    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }


    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
        return Math.abs(value) % elementData.length;
    }

    private double loadFactor() {
        return (double) size / elementData.length;
    }

    // Resizes the hash table to twice its former size.
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry current = oldElementData[i];
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }

    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
        public int data;
        public HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }
    }

    //exercise. 1
    public void addAll(HashIntSet hashIntSet) {
        HashEntry[] set = hashIntSet.elementData;
        for (HashEntry hashEntry : hashIntSet.elementData) {
            if(hashEntry != null) {
                this.add(hashEntry.data);
            }
        }
    }

    //exercise. 2
    public boolean containsAll(HashIntSet hashIntSet) {
        for (HashEntry hashEntry : hashIntSet.elementData) {
            if (hashEntry != null && !this.contains(hashEntry.data)) {
                return false;
            }
        }
        return true;
    }

    //exercise. 3
    public boolean equals(HashIntSet hashIntSet) {

        if (hashIntSet.size != this.size) {
            return false;
        }

        for (HashEntry hashEntry : hashIntSet.elementData) {
            if(hashEntry != null && !this.contains(hashEntry.data)) {
                return false;
            }
        }
        return true;
    }

    //exercise. 4

    public void removeAll(HashIntSet hashIntSet) {
        for (HashEntry hashEntry : hashIntSet.elementData) {
           if(hashEntry != null) {
            this.remove(hashEntry.data);
           }
        }
    }

    //exercise. 5

    public void retainAll(HashIntSet hashIntSet) {
        HashIntSet temp = new HashIntSet();
        for (HashEntry hashEntry : hashIntSet.elementData) {
            if(hashEntry != null && this.contains(hashEntry.data)) {
                temp.add(hashEntry.data);
            }
        }
        this.clear();
        this.addAll(temp);
    }

    //exercise. 6
    public HashEntry[] toArray() {
        HashEntry[] hashEntries;
        int count = 0;
        for (HashEntry hashEntry : this.elementData) {
            if (hashEntry != null) {
                count++;
            }
        }

        hashEntries = new HashEntry[count];

        int cc = 0;
        for (int i = 0; i < this.elementData.length; i++) {
            if (this.elementData[i] != null) {
                hashEntries[cc] = this.elementData[i];
                cc ++;
            }
        }
        return hashEntries;
    }

    //exercise. 7
    public String toString() {
        String result = "[";
        for (HashEntry hashEntry : toArray()) {
            result += hashEntry.data + ", ";
        }
        return result.substring(0, result.lastIndexOf(",")) + "]";
    }

}