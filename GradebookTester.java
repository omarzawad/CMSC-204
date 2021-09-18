package Junit_fun;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//GRADEBOOK TESTER CLASS************************************************************
public class GradebookTester 
{
        GradeBook num1, num2;

        //SET UP METHOD******************************************************************
        @Before
        public void setUp() throws Exception 
        {
                num1 = new GradeBook(5);
                num1.addScore(95);
                num1.addScore(88);
                num1.addScore(92);
                num1.addScore(43);

                num2 = new GradeBook(5);
                num2.addScore(96);
                num2.addScore(90);
                num2.addScore(75);
                num2.addScore(65);
        }

        //TEAR DOWN METHOD***************************************************************
        @After
        public void tearDown() throws Exception 
        {
                num1 = num2 = null;
        }

        //ADD SCORE TEST METHOD**********************************************************
        @Test
        public void addScoreTest() 
        {
                assertTrue(num1.toString().equals("95.0 88.0 92.0 43.0 "));
                assertEquals(4, num1.getScoreSize(), 0.01);
                assertTrue(num2.toString().equals("96.0 90.0 75.0 65.0 "));
                assertEquals(4, num2.getScoreSize(), 0.001);
        }

        //SUM TEST METHOD*****************************************************************
        @Test
        public void sumTest() 
        {
                assertEquals(318, num1.sum(), 0.001);
                assertEquals(326, num2.sum(), 0.001);
        }

        //MINIMUM TEST METHOD**************************************************************
        @Test
        public void minimumTest() 
        {
                assertEquals(43, num1.minimum(), 0.001);
                assertEquals(65, num2.minimum(), 0.001);        
        }

        //FINAL SCORE TEST METHOD***********************************************************
        @Test
        public void finalScoreTest()
        {
                assertEquals(275, num1.finalScore(), 0.001);
                assertEquals(261, num2.finalScore(), 0.001);    
        }

}