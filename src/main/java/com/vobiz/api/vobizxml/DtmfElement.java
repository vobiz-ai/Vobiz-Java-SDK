package com.vobiz.api.vobizxml;

/** {@code <DTMF>} send digits on a live call (digits are the text content). */
public final class DtmfElement extends VobizXmlElement<DtmfElement> {

    DtmfElement() {
        super("DTMF");
    }

    DtmfElement(String digits) {
        super("DTMF");
        if (digits != null) {
            text(digits);
        }
    }
}
