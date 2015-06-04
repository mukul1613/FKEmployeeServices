/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbentity.EvaNotifications;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mukul.kumar
 */
public final class NotificationsToDos {

    //List<String> notifications;
    String notification1 = null;
    String notification2 = null;
    String notification3 = null;
    public NotificationsToDos() {
       // notifications = new LinkedList<>();
    }

    public NotificationsToDos(EvaNotifications dbEntityObj){
        this();
        if(dbEntityObj!=null){
           notification1 = dbEntityObj.getNotification1();
           notification2 = dbEntityObj.getNotification2();
           notification3 = dbEntityObj.getNotification2();
        } else {
           notification1 ="no notifications available";
           notification2 ="no notifications available";
           notification3 ="no notifications available";
        }
    }

    public String getNotification1() {
        return notification1;
    }

    public void setNotification1(String notification1) {
        this.notification1 = notification1;
    }

    public String getNotification2() {
        return notification2;
    }

    public void setNotification2(String notification2) {
        this.notification2 = notification2;
    }

    public String getNotification3() {
        return notification3;
    }

    public void setNotification3(String notification3) {
        this.notification3 = notification3;
    }

    

}
