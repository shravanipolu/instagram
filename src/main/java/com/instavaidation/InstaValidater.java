package com.instavaidation;

	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	
	public class InstaValidater {

		public static boolean isValid(String mobileNumber) {

			Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

			Matcher m = p.matcher(mobileNumber);
			boolean isMatch = m.matches();
			return isMatch;
		}

		public static boolean isValidMail(String mail) {
			// Pattern p =
			// Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

			Matcher m = p.matcher(mail);
			boolean isMatch = m.matches();
			return isMatch;
		}

	
	
}
