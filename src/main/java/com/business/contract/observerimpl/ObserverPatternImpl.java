
package com.business.contract.observerimpl;

import com.business.contract.observer.EventUi;
import com.business.contract.observer.ObserverPattern;
import com.business.contract.observer.Subscriber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D.Santos
 */
public class ObserverPatternImpl extends ObserverPattern {
   
   
   private List<Subscriber> subscriberList = new ArrayList<>();
    
    public void addObserver(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

    public void removeObserver(Subscriber subscriber) {
        this.subscriberList.remove(subscriber);
    }

    public void eventAlert(EventUi eventUi) {
        for (Subscriber i : subscriberList) {
            i.update(eventUi);
        }
    }

}
