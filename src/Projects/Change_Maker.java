package Projects;

import java.util.Scanner;

public class Change_Maker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userInput=0;
		String statement="";
		boolean again = true;
		char run ='y';		
		
		run = runProgram(scanner);//Getting and checking if yes 'y' or no 'n' was entered
		if(run == 'y'|| run == 'Y'){
			
			while (again){
				userInput = getChangeAmount(scanner);//Getting amount of change form user
				
				statement = changeMaker(userInput);//Getting change string
				System.out.println(statement);
				
				run = runProgram(scanner);//Getting and checking if yes 'y' or no 'n' was entered
				if(run == 'n'|| run =='N'){
					again = false;
				}
			}
		}								
		scanner.close();		
	}

	public static int getChangeAmount(Scanner scanner) {
		int result=0;
		do{//checking if the amount entered is between 0-100
			System.out.println("Please enter the amount of change you would like: ");
			result = scanner.nextInt();
			if(!(result >0 && result<100)){
				System.out.println("Please enter a number between 1 and 99 ");
			}
		}while(!(result >0 && result<100));
		return result;
	}

	public static char runProgram(Scanner scanner) {
		char result;
		do{//checking if yes 'y' or no 'n' was entered
			System.out.println("Would you like to run the change making program? 'y' for yes, 'n' for no");
			result = scanner.next().charAt(0);
			if(!(result == 'y'|| result == 'Y'||result == 'n'|| result == 'N')){
				System.out.println("Please enter an: 'n' or 'y'. Not a : "+result);
			}
		}while(!(result == 'y'|| result == 'Y'||result == 'n'|| result == 'N'));
		return result;
	}

	public static String changeMaker(int userInput) {
		String result="Change: \n";
		int numQuarters=0;
		int numDimes=0;
		int numNickels=0;
		int numPennies=0;
		
		//Getting the number of Quarters
		numQuarters = userInput/25;
		userInput = userInput%25;
		if(numQuarters != 0){
			if(numQuarters == 1){
				result = result +numQuarters+" Quarter\n";
			}else{
				result = result +numQuarters+" Quarters\n";
			}
		}
		//Getting the number of Dimes
		numDimes = userInput/10;
		userInput = userInput%10;
		if(numDimes != 0){
			if(numDimes == 1){
				result = result +numDimes+" Dime\n";
			}else{
				result = result +numDimes+" Dimes\n";
			}
		}
		//Getting the number of Nickels
		numNickels = userInput/5;
		userInput = userInput%5;
		if(numNickels != 0){
			if(numNickels == 1){
				result = result +numNickels+" Nickel\n";
			}else{
				result = result +numNickels+" Nickels\n";
			}
		}
		//Getting the number of Pennies
		numPennies = userInput;
		if(numPennies != 0){
			if(numPennies == 1){
				result = result +numPennies+" Penny\n";
			}else{
				result = result +numPennies+" Pennies\n";
			}
		}
		return result;
	}
}
