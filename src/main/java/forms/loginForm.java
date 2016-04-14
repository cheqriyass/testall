package forms;


import entities.User;
import entities.UserDao;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class loginForm extends ActionForm {
    String nomUtilisateur;
    String mdpUtilisateur;



    public String getMdpUtilisateur() {
        return mdpUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur) {
        this.mdpUtilisateur = mdpUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public ActionErrors validatee(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String mdpUtilisateur = request.getParameter("mdpUtilisateur");




        if (nomUtilisateur==null || nomUtilisateur.isEmpty()) {
            errors.add("nomUtilisateur",new ActionMessage("errors.user.req"));
        }

        if (!nomUtilisateur.isEmpty() && !EmailValidator.getInstance().isValid(nomUtilisateur)) {
            errors.add("nomUtilisateur",new ActionMessage("errors.user.invalide",nomUtilisateur));
        }

        if (mdpUtilisateur==null || mdpUtilisateur.isEmpty()) {
            errors.add("1",new ActionMessage("errors.pass.reqq"));
        }

        if (!nomUtilisateur.isEmpty() && EmailValidator.getInstance().isValid(nomUtilisateur)) {
            UserDao uDao = new UserDao();
            User u = uDao.findUserByEmail(nomUtilisateur);
            System.out.println("u = " + u);
            if (u == null) {
                errors.add("2", new ActionMessage("errors.user.ncorrect"));
            }

            if (u!=null && nomUtilisateur.equals(u.getEmail()) && !mdpUtilisateur.equals(u.getPassword())){
                errors.add("3", new ActionMessage("errors.user.mdpincor"));
            }
        }

        return errors;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.mdpUtilisateur = null;
        this.nomUtilisateur = null;
    }

}
