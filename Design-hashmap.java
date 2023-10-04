/*
----------------Problem Statement--------------------
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

--------------------Example 1:--------------------

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

--------------------Explanation--------------------
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

--------------------Constraints:--------------------

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.

--------------------Intuition--------------------
We can design a HashMap without using any built-in hash table libraries by using an array. We can use the key as the index of 
the array to store the corresponding value.

--------------------Approach--------------------
The following algorithm describes how to implement a HashMap without using any built-in hash table libraries:

Initialize an array to store the key-value pairs.

To put a (key, value) pair into the HashMap, set the value at the index of the key in the array to the value.
To get the value for a given key, return the value at the index of the key in the array.
To remove a (key, value) pair from the HashMap, set the value at the index of the key in the array to -1.

--------------------Complexity--------------------
Time complexity: O(1)
Space complexity: O(n)
--------------------Code--------------------
*/

class MyHashMap {
    int[] data;
    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    public void put(int key, int val) {
        data[key] = val;
    }
    public int get(int key) {
        return data[key];
    }
    public void remove(int key) {
        data[key] = -1;
    }
}

/*
The data array is used to store the key-value pairs. The put() function sets the value at the index of the key in the array to the value. 
The get() function returns the value at the index of the key in the array. 
The remove() function sets the value at the index of the key in the array to -1.
*/
