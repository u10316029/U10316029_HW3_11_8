/*U10316029
 * 郭政慶
 */
import java.util.Date;
import java.util.ArrayList;
public class TestAccount{
	/**main method*/
	public static void main(String[]args){
		Account acc = new Account(); //New a object "acc" 
		Transaction tra = new Transaction(); //New a object "tra"
		acc = tra; //Send tra's value to object acc
		/**Display the String when deposit $30*/
		System.out.print(tra.toString());
		acc.deposit(30);
		System.out.print(acc.transaction.get(0).getDes()+"\n");
		
		/**Display the String when deposit $40*/
		System.out.print(tra.toString());
		acc.deposit(40);
		System.out.print(acc.transaction.get(1).getDes()+"\n");
		
		/**Display the String when deposit $50*/
		System.out.print(tra.toString());
		acc.deposit(50);
		System.out.print(acc.transaction.get(2).getDes()+"\n");
		
		/**Display the String when withdraw $2*/
		System.out.print(tra.toString());
		acc.withdraw(2);
		System.out.print(acc.transaction.get(3).getDes()+"\n");
		
		/**Display the String when withdraw $4*/
		System.out.print(tra.toString());
		acc.withdraw(4);
		System.out.print(acc.transaction.get(4).getDes()+"\n");
		
		/**Display the String when withdraw $5*/
		System.out.print(tra.toString());
		acc.withdraw(5);
		System.out.print(acc.transaction.get(5).getDes()+"\n");
	}
}
class Account{
	private int id ; 
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated = new Date(); //Create a Date
	private String name;
	private double amount;
	ArrayList<Transaction> transaction = new ArrayList<Transaction>(); //Create a arraylist to store the transaction for the accounts
	Account(){} //Create a no-arg constructor
	Account(String name,int id,double balance){ //Create a account with specific name , id , balance
		this.name = name;
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0.015;
	}
	public int getid(){
		return id;
	}
	public  double getbalance(){
		return balance;
	}
	public  double getannualInterestRate(){
		return annualInterestRate;
	}
	public String getName(){
		return name;
	}
	public String getdateCreated(){ //Return the current time
		return dateCreated.toString();
	}
	public double getMonthlyInterestRate(){ //Return the monthly interest rate
		return annualInterestRate/1200;
	}
	public double getMonthlyInterest(){ //Return the monthly interest 
		return balance * getMonthlyInterestRate();
	}
	public void withdraw(double money){ //Store the transaction when withdraw money
		amount = money;
		balance = getbalance()- money;
		transaction.add(new Transaction('W', amount,getbalance(),toString()));
	}	
	public void deposit(double money){ //Store the transaction when deposit money
		amount = money;
		balance= getbalance() + money;
		transaction.add(new Transaction('D', amount,getbalance(),toString()));
	}
	public void setBalance(double balance){ //Set the new balance
		this.balance = balance;
	}
	public void setAnnualInterestRate(double annualInterestRate ){ //Set the new annual interest rate
		this.annualInterestRate = annualInterestRate;
	}
	@Override
	public String toString(){
			return "The owner of the account is " + getName() + "\nThe balance of the account is " + getbalance() + "\nAnnual rate is "+ getannualInterestRate()*100+"%";
	}
}
class Transaction extends Account{
	char type;
	double amount;
	String des;
	Transaction(){ //Invoke superclass's constructor with specific name , id , balance
		super("George",1122,1000);
	}
	Transaction(char type,double amount,double balance,String des){ //Construct a constructor with the specific type,amount,balance,description
		this.type = type;
		this.amount = amount;
		setBalance(balance);
		this.des = des;
	}
	public char getType1(){
		return 'W';
	}
	public char getType2(){
		return 'D';
	}
	public double getAmount(){
		return amount;
	}
	public String getDes(){ //Display the String when withdraw or deposit
		switch (type){
		case'W':
			return "\nThe date of the transaction is "+getdateCreated()+"\nThe type of the transaction is "+ getType1()+"\nThe transaction amount is "+getAmount()+"\nThe balance after transaction is "+getbalance()+"\n";
		case'D':
			return "\nThe date of the transaction is "+getdateCreated()+"\nThe type of the transaction is "+ getType2()+"\nThe transaction amount is "+getAmount()+"\nThe balance after transaction is "+getbalance()+"\n";
		default:
			return null;
		}
	}
}
