package nl.dagobank.webapp.controller;

import nl.dagobank.webapp.backingbeans.BankAccountNameForm;
import nl.dagobank.webapp.dao.BankAccountDao;
import nl.dagobank.webapp.domain.Customer;
import nl.dagobank.webapp.domain.PrivateAccount;
import nl.dagobank.webapp.service.IbanGenerator;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;


@Controller
@SessionAttributes( "user" )
public class OpenPrivateBankAccountSuccessController {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Autowired
    IbanGenerator ibanGenerator;



    @PostMapping("/openAndSaveBankAccount")
    public ModelAndView openBankAccountSuccessHandler(@ModelAttribute BankAccountNameForm bankAccountNameForm, Model model, PrivateAccount privateAccount) {
        ModelAndView modelAndView = new ModelAndView("openPrivateBankAccountSuccess");
        Customer user = (Customer) model.getAttribute("user");

        privateAccount.setAccountHolder(user);
        privateAccount.setAccountName(bankAccountNameForm.getBankAccountName());
        privateAccount.setBalance(new BigDecimal("25"));
        Iban iban = ibanGenerator.createIban();
        privateAccount.setIban(iban.toString());
        bankAccountDao.save(privateAccount);

        modelAndView.addObject("message", "De volgende rekening is aangemaak:");
        modelAndView.addObject("bankaccount", privateAccount.toString());
        return modelAndView;
    }


}