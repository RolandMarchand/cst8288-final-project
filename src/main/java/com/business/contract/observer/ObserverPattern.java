
package com.business.contract.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D.Santos
 */
abstract class ObserverPattern {
   
   
   
    
    abstract void addObserver(Subscriber subscriber);

    abstract void removeObserver(Subscriber subscriber);

    abstract void eventAlert(EventUi eventUi);
    

}
