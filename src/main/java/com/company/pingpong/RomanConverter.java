package com.company.pingpong;

import java.util.regex.Pattern;

public class RomanConverter {
	public static int Convert(String s) 
	{
		int sum = 0;
		if (s == null || s.length() == 0)
		{
			throw new RuntimeException("Invalid roman number");
		}
		
		Pattern pattern = Pattern.compile("([a-z\\d])\\1\\1\\1", Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(s).find())
		{
			throw new RuntimeException("Invalid roman number");
		}
		
		s = s.toUpperCase();
		s = s.replaceAll("IV", "IIII");
		s = s.replaceAll("IX", "VIIII");
		s = s.replaceAll("XL", "XXXX");
		s = s.replaceAll("XC", "LXXXX");
		s = s.replaceAll("CD", "CCCC");
		s = s.replaceAll("CM", "DCCCC");

		
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I':
				sum += 1;
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				sum += 10;
				break;
			case 'L':
				sum += 50;
				break;	
			case 'C':
				sum += 100;
				break;		
			case 'D':
				sum += 500;
				break;	
			case 'M':
				sum += 1000;
				break;	
			default:
				throw new RuntimeException("Invalid roman number");
			}

		}
		return sum;
	}
}
