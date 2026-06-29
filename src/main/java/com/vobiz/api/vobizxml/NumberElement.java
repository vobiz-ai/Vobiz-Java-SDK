package com.vobiz.api.vobizxml;

/** {@code <Number>} a PSTN number to dial (nested in {@code <Dial>}). */
public final class NumberElement extends VobizXmlElement<NumberElement> {

    NumberElement() {
        super("Number");
    }

    NumberElement(String number) {
        super("Number");
        if (number != null) {
            text(number);
        }
    }
}
