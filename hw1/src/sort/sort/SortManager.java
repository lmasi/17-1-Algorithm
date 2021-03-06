package sort.sort;

import sort.time.*;

public abstract class SortManager
{
	protected int[] array;
	private int[] sorted_array;

	protected abstract void sort(int[] array);

	private void sort()
	{
		int[] tmp = new int[this.array.length];
		for(int i = 0; i<this.array.length; i++)
			tmp[i] = this.array[i];

		this.sort(tmp);
		sorted_array = tmp;
	}

	public void setArrayForSort(int[] array)
	{
		this.array = array;
	}

	public void printArray()
	{
		if(array == null)
		{
			System.out.println("array is not set");
			return;
		}

		String str = "Array : ";

		for(int i=0; i<array.length; i++)
			str += array[i] + " ";

		System.out.println(str);
	}

	public void printSortedArray()
	{
		if(sorted_array == null)
		{
			System.out.println("array is not set");
			return;
		}

		String str = "Array : ";

		for(int i=0; i<sorted_array.length; i++)
			str += sorted_array[i] + " ";

		System.out.println(str);
	}

	public double getSortTime()
	{
		TimeManager tM = new TimeManager();

		tM.start();
		this.sort();
		tM.end();
		return tM.getRunTime();
	}

	// get average time for given count
	public double getAverageSortTime(int count)
	{
		double time = 0;

		for(int i=0; i<count; i++)
		{
			double tmp = getSortTime();
			time += tmp;

			//System.out.println(i + "th sort time : " + tmp);
		}

		return (time/count);
	}

	// get Shortest time among the sort
	public double getShortestSortTime(int count)
	{
		double time = getSortTime();

		for(int i=1; i<count; i++)
			time = (time < getSortTime() ? time : getSortTime());

		return time;
	}

	// get Longest time among the sort
	public double getLongestSortTime(int count)
	{
		double time = getSortTime();

		for(int i=1; i<count; i++)
			time = (time > getSortTime() ? time : getSortTime());
	
		return time;
	}
}
