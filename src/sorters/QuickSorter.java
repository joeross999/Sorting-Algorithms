package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		
		/*
		 * Note: When choosing a pivot, choose the element in the middle of
		 * the sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */
		int nElems = list.size();
		recQuickSort(0,	nElems-1);	

		return list;
	}
	
	public	int	partition(int	low,	int	high)	{
		int pivot = (low+high)/2;
		int	storeIndex	=	low;
		list.swap(pivot, high);
		int	j;	
		for(j=low;	j<=high-1;	j++)	{	
				if(list.compare(j, high, comparator)	<=	0)	{	
						list.swap(j,	storeIndex);	
						storeIndex++;	
				}	
		}	
		list.swap(storeIndex,	high);
		return	storeIndex;	
}
	protected	void	recQuickSort(int	low,	int	high)	{	
		if(low	<	high)	{	
				int	p	=	partition(low,	high);	//	p	is	split	point
				recQuickSort(low,	p-1);	
				recQuickSort(p+1,	high);	
		}	
}	

}