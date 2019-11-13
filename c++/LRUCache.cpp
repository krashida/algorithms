/*Design and implement a data structure for Least Recently Used (LRU) cache. It
should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists
in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );// capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
// same as leetcode M146

#include <algorithm>
#include <iostream>
#include <list>
#include <unordered_map>

template <class K, class V>
class LRUCache {
 public:
  LRUCache(int capacity) : capacity(capacity), pmap(), plist()
  {
  }

  ~LRUCache()
  {
  }

  // O(n), can be O(1) at times, as we push recent items to queue front
  V get(K key)
  {
    auto itr = pmap.find(key);
    if (itr != pmap.end()) {  // page exists
      plist.remove(key);
      plist.push_front(key);
      return itr->second;
    }
    return -1;
  }

  // O(n), can be O(1) at times, as we push recent items to queue front
  void put(K key, V value)
  {
    auto itr = pmap.find(key);
    if (itr != pmap.end()) {
      pmap[key] = value;
      plist.remove(key);
    }
    else {
      if (plist.size() == capacity) {
        pmap.erase(plist.back());
        plist.pop_back();
      }
      pmap[key] = value;
    }
    plist.push_front(key);
  }

  void evict(K key)
  {
    auto itr = pmap.find(key);
    if (itr != pmap.end()) {
      plist.remove(key);
      pmap.erase(key);
    }
  }

  void display() const
  {
    std::for_each(pmap.begin(), pmap.end(), [](const std::pair<K, V> &page) {
      std::cout << "{" << page.first << ": " << page.second << "} ";
    });
    std::cout << std::endl;
  }

 private:
  int capacity;
  std::unordered_map<K, V> pmap;  // map because get on a hash map is O(1)
  std::list<K>
      plist;  // list because insert/delete from front/head on a list is 0(1)
};

int main()
{
  LRUCache<int, int> cache(2);

  cache.put(1, 1);
  cache.put(2, 2);
  cache.display();
  std::cout << "Getting 1: " << cache.get(1) << std::endl;  // returns 1
  cache.put(3, 3);                                          // evicts key 2
  cache.display();
  std::cout << "Getting 2: " << cache.get(2)
            << std::endl;  // returns -1 (not found)
  cache.put(4, 4);         // evicts key 1
  cache.display();
  std::cout << "Getting 1: " << cache.get(1)
            << std::endl;  // returns -1 (not found)
  std::cout << "Getting 3: " << cache.get(3) << std::endl;  // returns 3
  std::cout << "Getting 4: " << cache.get(4) << std::endl;  // returns 4
  cache.display();
  cache.evict(2);
  cache.display();
  cache.put(2, 2);  // evicts key 3
  cache.display();
  cache.evict(4);
  cache.display();
  return 0;
}
