package com.vobiz.api.vobizxml;

/** {@code <Conference>} join a room (room name is the text content). */
public final class ConferenceElement extends VobizXmlElement<ConferenceElement> {

    ConferenceElement() {
        super("Conference");
    }

    ConferenceElement(String room) {
        super("Conference");
        if (room != null) {
            text(room);
        }
    }
}
