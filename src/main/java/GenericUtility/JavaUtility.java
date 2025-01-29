package GenericUtility;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * This class contains Java specific Reusable Methods
 * 
 * @author Sudarshan
 *
 */
public class JavaUtility {
	/**
	 * This method is used
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(10000);
	}

	public int getRandomNumbers() {
		return new Random().nextInt(10_000_000);
	}

	/**
	 * This method is used to get system date and Time in IST format
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString().toString().replace(":", "-");
	}

	public char generateRandomCharacter() {
		return (char) ('a' + new Random().nextInt(26));
	}

	/**
	 * This method is used to get system Date in YYYY-MM-DD format
	 * 
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split("")[5];
		String DD = dateAndTime.split("")[2];
		int MM = date.getMonth() + 1;
		String finalFormat = date.getTime() + "-" + YYYY + "-" + MM + "-" + DD;
		return finalFormat;

	}

	/*
	 * 12122023
	 */
	public String currentDateFormattedYYMMDD() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	public String currentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	}

	/**
	 * This method used get the current date and time Sat Jun 17 21:37:57 IST 2023
	 * 
	 */
	public Date getTheCurrentDateAndTime() {
		return new Date();
	}

	/*
	 * Sat Jun 17 21:37:57 IST 2023
	 */
	public Date currentDate_dd_m_y() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return date;
	}

	public String removeFirstCharctersAndLastCharters(String str, int lastNum, int firstNum) {
		String t = str.substring(0, str.length() - lastNum);
		String result = t.substring(firstNum);
		return result;
	}

	public String removeLast_n_NumberOfCharacters(String str, int n) {
		String lastRemoved = str.substring(0, str.length() - 4);
		return lastRemoved;
	}

	public String removeFirst_n_NumberOfCharacters(String str, int n) {
		String firstRemoved = str.substring(n);
		return firstRemoved;
	}

	public String generatingNumber() {
		int min = 1;
		int max = 100;
		int count = 10;
		Set<Integer> bednumberh = new HashSet();
		Random random = new Random();
		while (bednumberh.size() < count) {
			bednumberh.add(random.nextInt((max - min) + 1) + min);
		}
		return bednumberh.toString();
	}

	/*
	 * MM
	 */
	public String generateCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * DD
	 */
	public String generateCurrentMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * YYYY
	 */
	public String generateCurrentYear() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removedSpecialCharctersAndRemovedSpaces(String str, int length) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		lastRemoved = lastRemoved.replaceAll("\\s+", "");
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(String str, int length) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		lastRemoved = lastRemoved.replaceAll("\\s+", "");
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result rrRE
	 */
	public String removeSpecialCharactersAndNumbers_RemoveLastCharacters(String str, int length) {
		str = str.replaceAll("[^a-zA-Z]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removeSpecialCharacters_And_Speces(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		return str = str.replaceAll("\\s+", "");
	}

	/*
	 * current month
	 * 
	 */
	public String currentMonth() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
	}

	public String generateTwoDaysBackDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -2);
		return new SimpleDateFormat("d").format(calendar.getTime());
	}

	public List<String> getTextFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	@Test
	public String current_Time_Hours_Min() {
		LocalTime currentTime = LocalTime.now();
		LocalTime futureTime = currentTime.plusMinutes(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
		String formattedFutureTime = futureTime.format(formatter);
		return formattedFutureTime;
	}

	public String generateRandomEmail() {
		String domain = "example.com";
		String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int emailLength = 10;
		StringBuilder email = new StringBuilder();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < emailLength; i++) {
			int randomIndex = random.nextInt(allowedChars.length());
			char randomChar = allowedChars.charAt(randomIndex);
			email.append(randomChar);
		}

		email.append('@').append(domain);
		return email.toString();
	}

	public static String generateTenDaysAgoDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate tenDaysAgo = currentDate.minusDays(10);
		String dayOfMonth = dtf.format(tenDaysAgo);
		return dayOfMonth;
	}

	public String generate_RandomNumbers() {
		Set<Integer> generatedNumbers = new HashSet<>();
		Random random = new Random();

		int minValue = 1;
		int maxValue = 10000000;
		while (true) {
			int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
			if (!generatedNumbers.contains(randomNumber)) {
				generatedNumbers.add(randomNumber);
				String bednumberh = String.valueOf(randomNumber);
				return bednumberh;
			}
		}
	}

	public static String generateTwoDaysAgoDate_ddmmyyyy() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		Date twoDaysAgo = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(twoDaysAgo);
		return formattedDate;
	}

	public static String generateTwoDaysFutureDate_ddmmyyyy() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, +2);
		Date twoDaysAgo = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(twoDaysAgo);
		return formattedDate;
	}

	public String currentDateFormateYYMMDD() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	/*
	 * 20230925
	 * 
	 */
	public String currentDate_yyyymmdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		String formattedDate = sdf.format(currentDate);
		return formattedDate;
	}

	public String remove_All_ExceptNumbers(String input, int value) {
		String result = input.replaceAll("[^0-9]", "");
		return result;
	}

	public String generateRandomMobileNumber() {
		Random rand = new Random();

		StringBuilder mobileNumber = new StringBuilder("0");
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(rand.nextInt(10));
		}

		return mobileNumber.toString();
	}

	public String generateRandomAadhaarNumber() {
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		return aadhaar;
	}

	public String remove_Characters_And_FirstCharcatersRemove(String str, int n) {
		String regex = "[a-zA-Z]";
		String result = str.replaceAll(regex, "");
		String firstRemoved = result.substring(n);
		return firstRemoved;
	}

	public String getTheName_RemoveTheSpaces(String input) {
		Pattern pattern = Pattern.compile("([A-Za-z ]+)");
		String nameWithoutSpaces = "";
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String nameWithSpaces = matcher.group(1);
			nameWithoutSpaces = nameWithSpaces.replaceAll(" ", "");
		} else {

		}
		return nameWithoutSpaces;
	}

	public String generateCurrentDate_DDMMYYYY() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public String currentDateAnd_TimeMinSeconds() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public String currentDate_Dd_Mm_Yyyy() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	/*
	 * 29-09-2023 08:24
	 */
	public String curretDateAndTime_DDMMYYY_H_M() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	public String remove_SpecialCharacters_And_Numbers_Speces(String inputString, int length) {
		inputString = inputString.replaceAll("[^a-zA-Z\\s]+", "");
		String lastRemoved = inputString.substring(0, inputString.length() - length);
		return lastRemoved;
	}

	/*
	 * 30-Sep-2023
	 * 
	 */
	public String generateCurrentTime_HHMM() {
		LocalTime currentTime = LocalTime.now();
		LocalTime increasedTime = currentTime.plusMinutes(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedTime = increasedTime.format(formatter);
		return formattedTime;
	}

	public String generateCurrentDate_dd_Month_yy() {
		Date date = new Date(1230768000000L);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = dateFormat.format(date);
		System.out.println("Formatted Date: " + formattedDate);
		return formattedDate;
	}

	public String removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(String inputString, int length) {
		String cleanedString = inputString.replaceAll("[^a-zA-Z]", "");
		String result = cleanedString.substring(length);
		return result;
	}

	public String removeFirstCharctersAndLastCharters_WithSpecialCharacters(String str, int lastNum, int firstNum) {
		String string = str.replaceAll("[^a-zA-Z]", "");
		String result = string.substring(2);
		String string1 = result.substring(0, result.length() - 2);
		return string1;
	}

	public String removeSpecialCharactersAndFirstCharacters(String input, int n) {
		String stringWithoutSpecialChars = input.replaceAll("[^a-zA-Z0-9]", " ");
		String first = stringWithoutSpecialChars.substring(n);
		return first;
	}

	/*
	 * 04Oct2023
	 */
	public String generate_CurrentDate_dd_Month_Yy() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH);
		String formattedDate = currentDate.format(customFormatter);
		return formattedDate;
	}

	public String generateCurrentDateAndMinus_dd(int days) {
		LocalDate currentDate = LocalDate.now();
		LocalDate newDate = currentDate.minusDays(days);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
		String formattedDate = newDate.format(formatter);
		return formattedDate;
	}

	public String generateMonthInWords() {
		Month currentMonth = Month.values()[java.time.LocalDate.now().getMonthValue() - 1];
		String currentMonthName = currentMonth.getDisplayName(java.time.format.TextStyle.FULL, Locale.US);
		return currentMonthName;
	}

	public String generateDateForDatePicker_MinusDate(int day) {
		LocalDate currentDate = LocalDate.now();
		LocalDate newDate = currentDate.minusDays(day);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
		String formattedDate = newDate.format(formatter);
		return formattedDate;
	}

	public String generateDate_minusDate_ddMMyyyy(int minusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.minus(minusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generateDate_PlusDate_ddMMyyyy(int plusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.plus(plusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generateDate_minusDate_dd_MM_yyyy(int minusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.minus(minusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generateCurrentDate_DDMMYYYY_WithoutSpecialCharacter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public static String generatePhoneNumber_Random() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public static String generateAadharNumber_Random() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	private static String[] first_Names = { "AARYA", "ADITHI", "AKHIL", "ANANYA", "ANIRUDH", "ANUSHA", "ARAVIND",
			"BHAGYA", "CHAITANYA", "DEVIKA", "DHANUSH", "DIVYA", "EKANSH", "GANESH", "GAYATHRI", "HARI", "ISHITA",
			"JANANI", "KARTHIK", "KRITHIKA", "MITHUN", "NANDINI", "NAREN", "NITHYA", "Joe", "PADMA", "PRAVIN", "PREETI",
			"RAJESH", "RAJANI", "RITHVIK", "SAKSHI", "SAMUEL", "SANJANA", "SHANKAR", "SHREYA", "SIDDARTH", "SINDHU",
			"SUMIT", "SWATHI", "TANVI", "TARUN", "TRISHA", "UDAY", "UDITA", "VASU", "VARSHA", "VIDYUTH", "VIJAY",
			"VISHAKHA", "YOGI", "YAMINI", "ZARA", "AISHWARYA", "AMAR", "AMRITA", "ALAGAPPAN", "ANAND", "AKSHARA",
			"ARJUN", "ARATI", "ASHWIN", "AARADHYA", "ANIRBAN", "ABHIGNA", "ASHOK", "BALA", "BHARATHI", "CHANDRA",
			"CHINMAY", "DEEPTI", "DINESH", "GAURI", "GIRISH", "HARINI", "ISHAN", "JANHVI", "JAGADEESH", "KAVYA",
			"KIRAN", "LAKSHMI", "MADHAV", "MEENAKSHI", "MUKUND", "NANDHINI", "NIRMALA", "OMKARA", "PADMAPRIYA",
			"PRADEEP", "PRAKRITI", "RAHUL", "RUKMINI", "RAGHAV", "SANDHYA", "SANTHOSH", "SHRUTHI", "SUSHANT", "SWARNA",
			"TARAK", "TANUSHREE", "UDAYAN", "VANDANA", "VINEETH" };

	private static String[] middle_Names = { "RAJAN", "NAIR", "NAIK", "NAMBOODIRI", "RAO", "REDDY", "MENON", "PILLAI",
			"KURUP", "KUMARAN", "SHETTY", "SHARMA", "SHET", "SHENOY", "PRABHU", "PADMANABHAN", "NAMBIAR", "MOHAN",
			"MISHRA", "MEHTA", "VENKATESH", "VENKATARAMAN", "VENUGOPAL", "KRISHNAN", "KRISHNAKUMAR", "KRISHNAMURTHY",
			"ANAND", "ANANTH", "BALAN", "BALASUBRAMANIAN", "BALAKRISHNAN", "SURESH", "RAJESH", "RAMESH", "NAGESH",
			"NARENDRA", "NARAYANAN", "SUDHAKAR", "SUBRAMANIAN", "SUNDAR", "SUNDARAM", "SUNIL", "MURALI", "MURTHY",
			"VENUGOPAL", "VIJAY", "VIKRAM", "RAGHAVAN", "RAMAN", "RAMANAN", "RAVI", "RAJU", "RAMESH", "RAGHU", "RAJAN",
			"RAO", "RAJAGOPAL", "RADHAKRISHNAN", "RADHAKRISHNA", "RADHAKRISHNAMURTHY", "DASARI", "DASARATHY",
			"DASGUPTA", "DASH", "DAS", "DASTIDAR", "DATTA", "DATTATREYA", "DEVARAKONDA", "DEVAREDDY", "DEY",
			"DHAIRYASHIL", "DHAL", "DHAMI", "DHEERAJ", "DHIRAJ", "DHIRENDRA", "DHRUV", "DHULIPALA", "DILIP",
			"DINAKARAN", "DINESH", "DINODIA", "DODDA", "DOGRA", "DORAIRAJ", "DUA", "DUBASH", "DUBEY", "DUGGAL" };

	private static String[] last_Names = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P",
			"R", "S", "T", "U", "V", "W", "Y" };

	public static String generateRandomFirstName() {
		Random random = new Random();
		String firstName = first_Names[random.nextInt(first_Names.length)];
		return firstName;
	}

	public static String generateRandomMiddleName() {
		Random random = new Random();
		String middle = middle_Names[random.nextInt(middle_Names.length)];
		return middle;
	}

	public static String generateRandomLastName() {
		Random random = new Random();
		String last = last_Names[random.nextInt(last_Names.length)];
		return last;
	}

	private static final String[] streets = { "Main Street", "Market Street", "MG Road", "Station Road", "Park Avenue",
			"Gandhi Nagar", "Shivaji Nagar", "Jubilee Hills", "MG Road", "Civil Lines" };
	private static final String[] colonies = { "Green Colony", "Rose Gardens", "Silver Residency", "Golden Enclave",
			"Palm Meadows", "Maple Heights", "Sapphire Gardens", "Emerald Towers", "Diamond Plaza",
			"Pearl Residences" };

	public static String generateRandomAddress() {
		Random random = new Random();
		String street = streets[random.nextInt(streets.length)];
		String colony = colonies[random.nextInt(colonies.length)];
		int buildingNumber = 1 + random.nextInt(100);
		return String.format("Street: %s, Colony: %s, Building: %d", street, colony, buildingNumber);
	}

	public static String generateRandomAge() {
		Random random = new Random();
		int maxAmount = 100;
		int randomAmount = random.nextInt(maxAmount);
		String amount = Integer.toString(randomAmount);
		return amount;
	}

	public String generateRandomNumberBelow_100() {
		Random random = new Random();
		int randomNumber = random.nextInt(96) + 5;
		String randomNumber2 = String.valueOf(randomNumber);
		return randomNumber2;
	}

}
