package nl.dagobank.webapp.controller;

import nl.dagobank.webapp.backingbeans.BankAccountNameForm;
import nl.dagobank.webapp.dao.BankAccountDao;
import nl.dagobank.webapp.domain.Customer;
import nl.dagobank.webapp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes( "user" )
public class OpenPrivateBankAccountController {

@Autowired
    BankAccountService bankAccountService;

    @GetMapping("openPrivateBankAccount")
    public ModelAndView openBankAccountHandler(Model model) {
        ModelAndView modelAndView = new ModelAndView("openPrivateBankAccount");
        Customer user = (Customer) model.getAttribute("user");
        modelAndView.addObject("customerName", user.getFirstName());
        BankAccountNameForm bankAccountNameForm = new BankAccountNameForm();

        int aantalRekeningenVanUser = bankAccountService.getNumberOfBankAccountsOfCustomer(user);
        bankAccountNameForm.setBankAccountName(user.getFirstName() + "'s rekening " + (aantalRekeningenVanUser+1));
        modelAndView.addObject("bankAccountNameForm", bankAccountNameForm);
        return modelAndView;
    }
}





