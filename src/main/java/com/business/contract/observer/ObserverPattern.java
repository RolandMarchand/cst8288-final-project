
package com.business.contract.observer;

import java.util.ArrayList;
import java.util.List;
import com.business.contract.observer.EventUi;
import com.business.contract.observer.SubscriberList;

/**
 *
 * @author D.Santos
 */
public class ObserverPattern {
   
   
   private List<SubscriberList> subscriberList = new ArrayList<>();
    
    public void addObserver(SubscriberList subscriber) {
        this.subscriberList.add(subscriber);
    }

    public void removeObserver(SubscriberList subscriber) {
        this.subscriberList.remove(subscriber);
    }
/*
    public void eventAlert(EventUi eventUi) {
        for (SubscriberList subscriberList : subscriberLists) {
            subscriberList.update(eventUi);
        }
    }
*/
}
