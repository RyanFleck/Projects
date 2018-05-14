public class ListUtil 
{

	public static <E> LinkedList indexOfAll( LinkedList<Integer> list, E obj)
	{
		LinkedList indicies=new LinkedList();
		Iterator i=list.iterator();
		int c=0;
		while(i.hasNext())
		{
			if (i.next().equals(obj))
			{
				indicies.addLast(c);
			}
			c++;
		}
		return (indicies);
	}
}