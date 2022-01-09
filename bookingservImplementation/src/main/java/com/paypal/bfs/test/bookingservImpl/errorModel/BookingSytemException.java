package com.paypal.bfs.test.bookingservImpl.errorModel;

public class BookingSytemException extends Exception{
    private Errors errors;

    public BookingSytemException(String s,Errors errors)
    {
        super(s);
        this.errors= errors;
    }

    public Errors getErrors()
    {
        return errors;
    }
}
