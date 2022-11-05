package com.example.mcalc;

public class MortgageModel {
    String t="0";
    String b="0";
    String c="0";
    public MortgageModel(String p, String a, String i){
        this.t=p;
        this.b=a;
        this.c=i;
    }

    public String computePayment(){
        double balance =Double.parseDouble(t);
        final double INTEGER = 1;
        int PER_TIME = 12;
        int NUMBER_OF_YEARS =Integer.parseInt(b) ;
        double d=Double.parseDouble(c);
        final double CONSTANT = 100;
        int NUMBER_OF_YEARS1=NUMBER_OF_YEARS*PER_TIME;
        double divider = (d/ CONSTANT);
        double divider1 = divider / PER_TIME;
        double addition1=INTEGER+divider1;
        double power1=Math.pow(addition1, -NUMBER_OF_YEARS1);
        double additionOfVariables = INTEGER-power1 ;
        double multiple=divider1*balance;
        // double power = Math.pow(additionOfVariables, NUMBER_OF_YEARS);
        double amount = multiple/additionOfVariables;



        String end = String.format("$%,.2f", amount);

        return end;
    }
}
