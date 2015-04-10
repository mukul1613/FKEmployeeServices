/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mukul.kumar
 */
public final class NotificationsToDos {

    List<String> notifications;

    public NotificationsToDos() {
        this.notifications = getNotifications();
    }

    public List<String> getNotifications() {
        List<String> tempList = new LinkedList<>();
        tempList.add("this is sample notification 1");
        tempList.add("this is sample notification 2");
        tempList.add("this is sample notification 3");
        return tempList;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

}
