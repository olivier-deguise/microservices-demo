package com.org.myapp.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    @Test
    void testRegisterCustomer(){
        //given
        int a = 1;
        int b = 1;
        int c = 0;

        //when
        c = a +b;
        //then
        assertThat(c).isEqualTo(a+b);

    }
}
