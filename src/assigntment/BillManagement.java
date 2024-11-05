/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assigntment;


import assigntment.Bill;
import assigntment.Bill;
import assigntment.BillManager;
import assigntment.BillManager;
import java.util.Scanner;

public class BillManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillManager manager = new BillManager();
        
        while (true) {
            System.out.println("Choose a function:");
            System.out.println("1. Add a bill");
            System.out.println("2. Find a bill by customer code");
            System.out.println("3. Calculate total payment by customer type");
            System.out.println("4. Delete a bill by customer code");
            System.out.println("5. Find the bill with the largest payment");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter customer code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter customer type (NN, SX, KD, or other): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter old electricity meter index: ");
                    int oldIndex = scanner.nextInt();
                    System.out.print("Enter new electricity meter index: ");
                    int newIndex = scanner.nextInt();

                    Bill bill = new Bill(code, type, oldIndex, newIndex);
                    manager.addBill(bill);
                    System.out.println("Bill added successfully.");
                    break;
                
                case 2:
                    System.out.print("Enter the customer code to find: ");
                    String searchCode = scanner.nextLine();
                    Bill foundBill = manager.findBillByCode(searchCode);
                    if (foundBill != null) {
                        System.out.println("Bill found:");
                        System.out.println("Customer Code: " + foundBill.getCustomerCode());
                        System.out.println("Customer Type: " + foundBill.getCustomerType());
                        System.out.println("Old Index: " + foundBill.getOldIndex());
                        System.out.println("New Index: " + foundBill.getNewIndex());
                        System.out.println("Payment Due: " + foundBill.calculatePayment() + " VND");
                    } else {
                        System.out.println("No bill found with the entered customer code.");
                    }
                    break;
                
                case 3:
                    System.out.print("Enter customer type to calculate total payment: ");
                    String customerType = scanner.nextLine();
                    int totalPayment = manager.calculateTotalPaymentByCustomerType(customerType);
                    System.out.println("Total payment for customer type " + customerType + ": " + totalPayment + " VND");
                    break;
                
                case 4:
                    System.out.print("Enter customer code to delete: ");
                    String deleteCode = scanner.nextLine();
                    manager.deleteBillByCode(deleteCode);
                    System.out.println("Bill deleted (if existed) for customer code: " + deleteCode);
                    break;
                
                case 5:
                    Bill largestBill = manager.findBillWithLargestPayment();
                    if (largestBill != null) {
                        System.out.println("Bill with the largest payment:");
                        System.out.println("Customer Code: " + largestBill.getCustomerCode());
                        System.out.println("Customer Type: " + largestBill.getCustomerType());
                        System.out.println("Old Index: " + largestBill.getOldIndex());
                        System.out.println("New Index: " + largestBill.getNewIndex());
                        System.out.println("Payment Due: " + largestBill.calculatePayment() + " VND");
                    } else {
                        System.out.println("No bills available.");
                    }
                    break;
                
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}