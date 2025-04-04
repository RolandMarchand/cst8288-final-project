/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business.contract.vehicleparts;

/**
 *
 * @author davey
 */
public class BusPartsContract {
    
   String busBrakes;
   String busTires;
   String busAxleBearingA;
   String busAxleBearingB;
   
   public String getBrakes(){
       return busBrakes;
   }
   
    public void setBrakes(String busBrakes){
       this.busBrakes =  busBrakes;
   }
   
   public String getTires(){
       return busTires;
   }
   
      public void setTires(String busTires){
        this.busTires =  busTires;
   }
      
   public String getBusAxleBearingA(){
       return busAxleBearingA;
   }
   
      public void setBusAxleBearingA(String busAxleBearingA){
       this.busAxleBearingA = busAxleBearingA;
   }
   
   public String getBusAxleBearingB(){
       return busAxleBearingB;
   }
   
      public void setBusAxleBearingB (String busAxleBearingB) {
       this.busAxleBearingB = busAxleBearingB;
   }
   
   
}
