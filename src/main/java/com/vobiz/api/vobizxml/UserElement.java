package com.vobiz.api.vobizxml;

/** {@code <User>} a SIP endpoint to dial (nested in {@code <Dial>}). */
public final class UserElement extends VobizXmlElement<UserElement> {

    UserElement() {
        super("User");
    }

    UserElement(String sipUri) {
        super("User");
        if (sipUri != null) {
            text(sipUri);
        }
    }
}
