/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EmployeeDetails;
import dbentity.EvaNews;
import dbentity.EvaNotifications;
import entitycontrollers.ControllerFactory;
import entitycontrollers.EmployeeDetailsJpaController;
import entitycontrollers.EvaNewsJpaController;
import entitycontrollers.EvaNotificationsJpaController;

/**
 *
 * @author mukul.kumar
 */
public class EmployeeDetailsOperations {

    private EmployeeDetailsJpaController mEmployeeDetailsJPAController;
    private EvaNewsJpaController mEvaNewsJpaController;
    private EvaNotificationsJpaController mEvaNotificationsJpaController;

    private EmployeeDetails mEmployeeDetailsDBEntity;
    private EvaNews mEvaNewsDBEntity;
    private EvaNotifications mEvaNotificationsDBEntity;

    public EmployeeDetailsOperations() {}

    
    public EmployeeDetailsOperations(int type){
        this();
        switch(type){
            case 1:
                mEmployeeDetailsJPAController = ControllerFactory.getEmployeeDetailsController();
                break;
            case 2:
                mEvaNewsJpaController = ControllerFactory.getEvaNewsJpaController();
                break;
            case 3:
                mEvaNotificationsJpaController = ControllerFactory.getevaEvaNotificationsJpaController();
                break;
            default :
        }
    }

    public EmployeeDetailsJpaController getmEmployeeDetailsFactory() {
        return mEmployeeDetailsJPAController;
    }

    public void setmEmployeeDetailsFactory(EmployeeDetailsJpaController mEmployeeDetailsFactory) {
        this.mEmployeeDetailsJPAController = mEmployeeDetailsFactory;
    }

    public EvaNews getmEvaNewsDBEntity() {
        return mEvaNewsDBEntity;
    }

    public void setmEvaNewsDBEntity(EvaNews mEvaNewsDBEntity) {
        this.mEvaNewsDBEntity = mEvaNewsDBEntity;
    }

    public EvaNotifications getmEvaNotificationsDBEntity() {
        return mEvaNotificationsDBEntity;
    }

    public void setmEvaNotificationsDBEntity(EvaNotifications mEvaNotificationsDBEntity) {
        this.mEvaNotificationsDBEntity = mEvaNotificationsDBEntity;
    }
    
    
    public EmployeeDetails getmEmployeeDetailsDBEntity() {
        return mEmployeeDetailsDBEntity;
    }

    public EvaNewsJpaController getmEvaNewsJpaController() {
        return mEvaNewsJpaController;
    }

    public EvaNotificationsJpaController getmEvaNotificationsJpaController() {
        return mEvaNotificationsJpaController;
    }

    public void setmEvaNewsJpaController(EvaNewsJpaController mEvaNewsJpaController) {
        this.mEvaNewsJpaController = mEvaNewsJpaController;
    }

    public void setmEvaNotificationsJpaController(EvaNotificationsJpaController mEvaNotificationsJpaController) {
        this.mEvaNotificationsJpaController = mEvaNotificationsJpaController;
    }

    public void setmEmployeeDetailsDBEntity(EmployeeDetails mEmployeeDetailsDBEntity) {
        this.mEmployeeDetailsDBEntity = mEmployeeDetailsDBEntity;
    }

    public void createEmployeeDetailsDBEntity(String mail) {
        mEmployeeDetailsDBEntity = mEmployeeDetailsJPAController.findEmployeeDetails(mail);
    }

    public void createEvaNewsDBEntity(String mail) {
        mEvaNewsDBEntity = mEvaNewsJpaController.findEvaNews(mail);
    }

    public void createEvaNotificationsDBEntity(String mail) {
        mEvaNotificationsDBEntity = mEvaNotificationsJpaController.findEvaNotifications(mail);
    }

}
