package com.play.intellij.lombok.tests;

import com.play.intellij.lombok.Customer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testValidCustomer() {
        Customer.Builder subject = Customer.builder();
        Customer.Builder customer = Customer.builder();
        customer.id(100);
        customer.name("bob");
        Assert.assertNotNull("Customer not built", customer.build());
    }

    @Test
    public void testInvalidCustomer() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("name is null");
        Customer.Builder customer = Customer.builder();
        customer.id(100);
        Assert.assertNull("Customer shouldn't built", customer.build());
    }
}


