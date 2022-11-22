package cydeo.Day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class HamcrestMatchersIntro {
    @DisplayName("Assertions with numbers")
    @Test
    public void simpleTest1(){


       //actual 5+5
        assertThat(5+5,is(10));
        assertThat(5+5,equalTo(10));

        //matchers has 2 overloaded version
        //first that accept actual value
        //second that accept another matchers
        //below examples method is accepting another matchers equal to make it readable
        assertThat(5+5,is(equalTo(10)));


        //number comparison
        //greaterThan();
        //greaterThanOrEqualTo();
        //lessThan();
        //lessThanOrEqualTo();

        assertThat(5+5,is(greaterThan(9)));
    }

    @DisplayName("Assertions with String")
    @Test
    public void test2(){

        String text ="B25 is learning Hamcrest";

        //checking for equality is same as numbers

        assertThat(text,is("B25 is learning Hamcrest"));
        assertThat(text,equalTo("B25 is learning Hamcrest"));
        assertThat(text,is(equalTo("B25 is learning Hamcrest")));

        //check if the text starts with B25
        assertThat(text,startsWith("B25"));

        //now do it in case insensitive manner
        assertThat(text,startsWithIgnoringCase("b25"));

        //endswith
        assertThat(text,endsWith("rest"));

        //check if text contains String learning
        assertThat(text,containsString("learning"));

        //with ignoring case
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str="";
        //check if the above string is blank
        assertThat(str,blankString());

        //check if trimmed str is empty string
        assertThat(str.trim(),emptyString());


    }
@DisplayName("Hamcrest for Collection")
@Test

    public void test3(){

    List<Integer> listOfNumbers= Arrays.asList(1,4,5,6,32,54,66,77,45,23);

    //check size of the list
    assertThat(listOfNumbers,hasSize(10));

    //check if this list hasItem 77
    assertThat(listOfNumbers,hasItem(77));

    //check if this list hasItems 77,45,23
    assertThat(listOfNumbers,hasItems(77,45,23));

    //check if all numbers greater than 0
    assertThat(listOfNumbers,everyItem(greaterThan(0)));
}







}
