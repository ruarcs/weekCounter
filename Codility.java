
public class Codility
{
	public static void main( String[] args )
	{
		Codility c = new Codility();
		int temp = c.solution(2014, 3, 4, 2);
		assert temp == 7: "Expected 7, got " + temp;
		temp = c.solution(2014, 0, 3, 2);
		assert temp == 16: "Expected 16, got " + temp;
		temp = c.solution(2014, 0, 11, 2);
		assert temp == 51: "Expected 51, got " + temp;
		System.out.println("Done!");
	}
	
	private int solution( int year, int startMonth, int endMonth, int dayOfWeek )
	{
		int[] numDaysInMonths = numDaysInMonthForYear( year );
		int weekCount = 0;
		boolean counting = false;
		int firstMondayInJanuary = 7 - dayOfWeek + 1;
		int day = firstMondayInJanuary;
		for( int currentMonth = 0; currentMonth < 12; currentMonth++ )
		{
			if( !counting && ( currentMonth == startMonth ) )
			{
				counting = true;
			}
			
			for( ; day <= numDaysInMonths[ currentMonth ]; day += 7 )
			{				
				if( counting )
				{
					weekCount++;
				}
			}
			
			if( counting && ( currentMonth == endMonth ) )
			{
				// It's possible that we have (in jumping by 7)
				// counted a month that's not fully in the end month,
				// so if we have then subtract.
				if( day > numDaysInMonths[ currentMonth ] )
				{
					weekCount--;
				}
				// No point counting any further!!
				break;
			}
			
			// Set day to first monday in next month.
			day = day - numDaysInMonths[ currentMonth ] ;
		}
		return weekCount;
	}
	
	private int[] numDaysInMonthForYear( int year )
	{
		int[] arr = new int[12];
		arr[0] = 31;
		if( year % 4 == 0 )
		{
			arr[1] = 29;
		}
		else
		{
			arr[1] = 28;
		}
		arr[2] = 31;
		arr[3] = 30;
		arr[4] = 31;
		arr[5] = 30;
		arr[6] = 31;
		arr[7] = 31;
		arr[8] = 30;
		arr[9] = 31;
		arr[10] = 30;
		arr[11] = 31;
		return arr;
		
	}
}
