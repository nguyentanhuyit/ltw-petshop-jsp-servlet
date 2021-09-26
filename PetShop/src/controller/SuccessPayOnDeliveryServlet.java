package controller;

import DAO.BankDAO;
import DAO.BillDAO;
import bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "pay-onDelivery", urlPatterns = "/pay-onDelivery")

public class SuccessPayOnDeliveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bank_id = (String) request.getAttribute("bank_id");
        String owner_name = request.getParameter("owner_name");
        String email = request.getParameter("email");
        String bank_code = request.getParameter("bank_code");

        System.out.println(bank_id);

//        boolean checkBankCart = bankDAO.checkExistBankCart(owner_name, bank_id, bank_code);
//        if (checkBankCart == true) {

        BankCart bankCart = new BankDAO().getBankCart(bank_id);


        HttpSession session = request.getSession();
        Cart cart = Cart.getCart(session);
        Account account = (Account) session.getAttribute("account");
        if (bankCart.getOwner_name().toLowerCase().equals(owner_name.toLowerCase()) && bankCart.getBank_code().equals(bank_code)) {

            BankDAO bankDAO = new BankDAO();
            bankDAO.deduction(cart.total()*0.1,owner_name,bank_id,bank_code);
            bankDAO.addmoney(cart.total()*0.1);

            int account_id = account.getAccount_id();
            Bill bill = new Bill();
            bill.setPayment(true);
            long total_price = cart.total();
            bill.setBill_status("Đang giao hàng");
            String address = account.getAddress().getAddress_detail()+", " + account.getAddress().getDistrict()+", " + account.getAddress().getProvince();
            int deposit = 0;
            bill.setTotal_price((int) total_price);
            bill.setAddress(address);
            bill.setDeposit(deposit);

            BillDAO billEntity = new BillDAO();
            try {
                boolean check = billEntity.addBill(account_id, bill);
                if (check = true) {
                    for (Pet pet : cart.getDt()) {
                        BillDetail billDetail = new BillDetail();
                        billDetail.setBill_id(bill.getBill_id());
                        billDetail.setPet_id(pet.getId());
                        billDetail.setQuantity(pet.getQuantity());

                        billEntity.addBillDetail(billDetail);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("pay","Số tiền cần phải thanh toán khi nhận hàng"+ cart.total());
            request.getRequestDispatcher("user/congratulation.jsp").forward(request, response);
        } else {
            request.setAttribute("noExist", "Thẻ tín dụng nhập sai giá trị");
            request.getRequestDispatcher("user/pay-onDelivery.jsp").forward(request, response);
        }
    }
}
