
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
		Day currentDay = Day.valueOf( dayOfWeek );
		int weekCount = 0;
		boolean counting = false;
		for( int currentMonth = 0; currentMonth < 12; currentMonth++ )
		{
			for( int day = 0; day < numDaysInMonths[ currentMonth ]; day++ )
			{
				currentDay = Day.nextDay( currentDay );
				
				if( !counting )
				{
					if( currentMonth == startMonth )
					{
						counting = true;
					}
				}
				else
				{
					if( currentMonth == ( endMonth + 1 ) )
					{
						// Using this logic we've counted one week
						// too far! Subtract one.
						weekCount--;
						// No point counting any further!!
						// Return the count.
						return weekCount;
					}
					else if ( currentDay == Day.Monday )
					{
						// If it's Monday count another week.
						weekCount++;
					}
				}
			}
		}
		if( counting )
		{
			// If we give December as the final month then we can spill
			// over into next year. If we're still counting then make sure
			// we take a week back off.
			weekCount--;
		}
		return weekCount;
	}
	
	private enum Day
	{
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday,
		INVALID;
		
		static Day valueOf( int day)
		{
			switch( day )
			{
				case 0: return Monday;
				case 1: return Tuesday;
				case 2: return Wednesday;
				case 3: return Thursday;
				case 4: return Friday;
				case 5: return Saturday;
				case 6: return Sunday;
				default: return INVALID;
			}
		}
		
		static Day nextDay( Day currentDay )
		{
			if( currentDay == Day.Sunday )
			{
				return Day.Monday;
			}
			else
			{
				return Day.values()[ currentDay.ordinal() + 1 ];
			}
		}
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
