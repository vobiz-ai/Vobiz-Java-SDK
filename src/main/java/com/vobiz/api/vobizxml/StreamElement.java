package com.vobiz.api.vobizxml;

/** {@code <Stream>} fork audio to a WebSocket (wss URL is the text content). */
public final class StreamElement extends VobizXmlElement<StreamElement> {

    StreamElement() {
        super("Stream");
    }

    StreamElement(String url) {
        super("Stream");
        if (url != null) {
            text(url);
        }
    }
}
