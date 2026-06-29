package com.vobiz.api.vobizxml;

/** {@code <Dial>} bridge the caller to {@code Number}/{@code User} endpoints; may nest {@code Record}. */
public final class DialElement extends VobizXmlElement<DialElement> {

    DialElement() {
        super("Dial");
    }

    DialElement(String number) {
        super("Dial");
        if (number != null) {
            text(number);
        }
    }

    /** Add a {@code <Number>} endpoint. */
    public NumberElement addNumber() {
        return add(new NumberElement());
    }

    /** Add a {@code <Number>} endpoint with a PSTN number. */
    public NumberElement addNumber(String number) {
        return add(new NumberElement(number));
    }

    /** Add a {@code <User>} SIP endpoint. */
    public UserElement addUser() {
        return add(new UserElement());
    }

    /** Add a {@code <User>} SIP endpoint with a SIP URI. */
    public UserElement addUser(String sipUri) {
        return add(new UserElement(sipUri));
    }

    /** Add a nested {@code <Record/>}. */
    public RecordElement addRecord() {
        return add(new RecordElement());
    }
}
