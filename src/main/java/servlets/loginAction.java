package servlets;

import entities.User;
import entities.UserDao;
import forms.loginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {

        String resultat = null;
//        String nomUtilisateur = req.getParameter("email");
//        String mdpUtilisateur = req.getParameter("motdepasse");


            resultat = "succes";


        return mapping.findForward(resultat);
    }



}