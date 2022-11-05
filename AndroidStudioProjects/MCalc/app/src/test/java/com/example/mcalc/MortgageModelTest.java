package com.example.mcalc;

import org.junit.Test;

import static org.junit.Assert.*;


import java.lang.reflect.Field;
import java.util.*;

import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;



import org.junit.FixMethodOrder;
import org.junit.Rule;;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MortgageModelTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Test
    public void ComputePaymentTest() {
        String p,a,i;
         p="700000";a="25" ;i="2.75";
         MortgageModel c=new MortgageModel(p,a,i)  ;
         String actual=c.computePayment();
         String expect= "$3,229.18";

        String error = String.format(
                "\nTest ComputePaymentTest fail for ( %s ). Returned ( %s ), but correct is ( %s )\n", actual, actual,
                expect);
        assertEquals(actual,expect);

    }
@Test
    public void ComputePaymentTest1() {
        String p,a,i;
        p="300000";a="20" ;i="4.5";
        MortgageModel c=new MortgageModel(p,a,i)  ;
        String actual=c.computePayment();
        String expect= "$1,897.95";

        String error = String.format(
                "\nTest ComputePaymentTest fail for ( %s ). Returned ( %s ), but correct is ( %s )\n", actual, actual,
                expect);
        assertEquals(actual,expect);

    }
}