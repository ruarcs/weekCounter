
public class CodilityAlternative
{
	public static void main( String[] args )
	{
		CodilityAlternative c = new CodilityAlternative();
		int temp = c.solution(2014, 3, 4, 3);
		assert temp == 7: "Expected 7, got " + temp;
		temp = c.solution(2014, 0, 3, 3);
		assert temp == 16: "Expected 16, got " + temp;
		temp = c.solution(2014, 0, 11, 3);
		assert temp == 51: "Expected 51, got " + temp;
		temp = c.solution(2018, 0, 0, 0);
		assert temp == 4: "Expected 4, got " + temp;
		System.out.println("Done!");
	}
	
	private int dateOfFirstMondayInJanuary( int dayOfWeek )
	{
	    if( dayOfWeek == 0 )
	    {
	    	// First is a Monday.
	        return 1;
	    }
	    int startDay = dayOfWeek;
	    // Count the number of days until the next Monday.
	    while( ++dayOfWeek <= 8 );
	    return dayOfWeek - startDay;
	}
	
	private int solution( int year, int startMonth, int endMonth, int dayOfWeek )
	{
		int[] numDaysInMonths = numDaysInMonthForYear( year );
		int weekCount = 0;
		boolean counting = false;
		int firstMondayInJanuary = dateOfFirstMondayInJanuary( dayOfWeek );
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
