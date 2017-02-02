package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		int nElems = list.size();
		int	out,	in;	
		for(out=1;	out<nElems;	out++){	//	dividing	line
				in	=	out;						//	start	shifts	at	out
				while(in>0	&& list.compare(in-1, in, comparator)>0)	{	
					list.swap(in,in-1);	
					in--;		//	element	that’s	no	longer	larger
				}	
		}		
		return list;
	}
}
