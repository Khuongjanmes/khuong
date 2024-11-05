/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assigntment;

import assigntment.Bill;
import java.util.ArrayList;

class BillManager {
    private ArrayList<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill) {
        if (findBillByCode(bill.getCustomerCode()) == null){
        bills.add(bill);
        }
    }

    public Bill findBillByCode(String code) {
        for (Bill bill : bills) {
            if (bill.getCustomerCode().equals(code)) {
                return bill;
            }
        }
        return null;
    }

    public int calculateTotalPaymentByCustomerType(String type) {
        int total = 0;
        for (Bill bill : bills) {
            if (bill.getCustomerType().equals(type)) {
                total += bill.calculatePayment();
            }
        }
        return total;
    }

    public void deleteBillByCode(String code) {
        bills.removeIf(bill -> bill.getCustomerCode().equals(code));
    }

    public Bill findBillWithLargestPayment() {
        Bill maxBill = null;
        int maxPayment = 0;
        for (Bill bill : bills) {
            int payment = bill.calculatePayment();
            if (payment > maxPayment) {
                maxPayment = payment;
                maxBill = bill;
            }
        }
        return maxBill;
    }
}
