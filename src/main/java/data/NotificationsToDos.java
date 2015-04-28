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

    List<String> notifications;

    public NotificationsToDos() {
        notifications = new LinkedList<>();
    }

    public NotificationsToDos(EvaNotifications dbEntityObj){
        this();
        if(dbEntityObj!=null){
           notifications.add(dbEntityObj.getNotification1());
           notifications.add(dbEntityObj.getNotification2());
           notifications.add(dbEntityObj.getNotification3());
        } else {
           notifications.add("no notifications available");
           notifications.add("no notifications available");
           notifications.add("no notifications available");
        }
    }

    public List<String> getNotifications() {
        return notifications;
    }    
    
    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

}
