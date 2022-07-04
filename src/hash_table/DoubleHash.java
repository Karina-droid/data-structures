package hash_table;

public class DoubleHash {
	int TABLE_SIZE, keysPresent;
	TableItem[] hashTable;
	boolean[] deleted;
	
	DoubleHash(int n) { 
		TABLE_SIZE = n;
		deleted = new boolean[TABLE_SIZE]; 
		hashTable = new TableItem[TABLE_SIZE];
	}
	
	int h1(int key) { return key%13; }
	
	int h2(int key) { return key%11+1; }
	
	void add(TableItem item) {
		int x = h1(item.key);
		int y = h2(item.key);
		for(int i=0; i<TABLE_SIZE; i++) {
			if(hashTable[x]==null && deleted[x]==true) {
				hashTable[x] = item;
				deleted[x] = false;
			}else x = (x + y) % TABLE_SIZE;
	}}
	
	TableItem remove(TableItem item) {
		int x = h1(item.key);
		int y = h2(item.key);
		for(int i=0; i<TABLE_SIZE; i++) {
			if(hashTable[x]!=null) {
				if(hashTable[x]==item) {
					deleted[x] = true;
					return hashTable[x];
				}else x = (x + y) % TABLE_SIZE;
			}else return null;
		}return null;
	}
	
	TableItem search(int key) {
		int x = h1(key);
		int y = h2(key);
		for(int i=0; i<TABLE_SIZE; i++) {
			if(hashTable[x]!=null) {
				if(hashTable[x].key==key && deleted[x]==false) {
					return hashTable[x];
				}else x = (x + y) % TABLE_SIZE;
			}else return null;
		}return null;
	}
}
	
	
class TableItem {
	int key;
	
	TableItem(int key) { this.key = key; }
}

