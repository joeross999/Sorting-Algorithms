package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {
	
	int size;
	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
		size = list.size();
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		for(int i=size/2-1;	i>=0;	i--)	{
			bubbleDown(i,	size-1);
	}	
	for(int i=size-1;		i>=1;	i--)	{	
			list.swap(0,	i);	
			bubbleDown(0,	i-1);	
	}	
		return list;
	}
	
	protected int getLeft(int cur){
		return (2 * cur +1);
	}
	
	protected int getRight(int cur){
		return((2 * cur) + 2);
	}
	
	protected void bubbleDown(int index, int end) {
		// TODO Auto-generated method stub
		int cur  = index;
		while(cur <= end){
			int left = getLeft(cur);
			int right = getRight(cur);
			int max; 
			
			if(left > end){
				if(right > end) break;
				else max = right;
			}
			else if(right > end){
				max = left;
			}
			
			else if(list.compare(left, right, comparator) > 0){
				max = left;
			}
			else max = right; 
			
			if(list.compare(cur, max, comparator) < 0){
				list.swap(cur, max);
				cur = max;
			}
			else break;
		}

	}
	
}
