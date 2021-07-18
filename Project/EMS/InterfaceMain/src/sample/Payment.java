package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// For asking payment details from customer
// This class will not store anything, simply ask for details and then display the selected details on the screen
// Its simply cin and cout (ONLY FOR INTERFACE WALE)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Payment
{
    private int method;                 //Credit card (-> enter card no. + enter cvc no)/ bank transfer (company ka account no )/ jazz cash (company ka jazz no)/ easy paisa (easy paisa no of company)
    private String card_no;
    private int cvc;
    private String date_paid;

    public Payment() {
        method = 0;
        card_no = "";
        cvc = 0;
    }

    public Payment(int method, float discount_amount, String discount_details, String date_paid)
    {
        this.method = method;
        this.date_paid = date_paid;
    }

    public int getMethod()
    {
        return method;
    }

    public void setMethod(int method)
    {
        this.method = method;
    }

    public String getDate_paid()
    {
        return date_paid;
    }

    public void setDate_paid(String date_paid)
    {
        this.date_paid = date_paid;
    }

public void inputDetails()                                    //Will input payement details
    {

        Scanner input = new Scanner(System.in);

        //1: Payment methods

        System.out.print("Enter the mode of payment : \n1: Credit/Debit Card\n2: Bank Transfer\n3: Jazz Cash\n4: Easypaisa ");
        this.method = input.nextInt();

        if (method == 1) {
            System.out.println("Enter card details:\n ");
            System.out.println("Enter the number on your card: ");
            this.card_no = input.nextLine();
            System.out.println("Enter the cvc number on back of your card: ");
            this.cvc = input.nextInt();
            System.out.println("Card verified successfully\nYou will receive a notification upon transaction confirmation.\n");
        }
        else if (method == 2)
            System.out.println("Company's Account Number = '090078601'\nTransfer the amount into the above mentioned account.\nYou will receive a notification upon transaction confirmation.\n ");

        else if (method == 3)
            System.out.println("Company's Jazz Cash number is = '090078601'\nTransfer the amount into the above mentioned account.\nYou will receive a notification upon transaction confirmation.\n");

        else if (method == 4)
            System.out.println("Company's Easy Paisa number is = '090078601'\nTransfer the amount into the above mentioned account.\nYou will receive a notification upon transaction confirmation.\n");

        else
            System.out.println("Invalid option selected\n");

        //2: Date Paid
        date_paid = java.time.LocalDate.now().toString();               //Stores current date

    }
}
