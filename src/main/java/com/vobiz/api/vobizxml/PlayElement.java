package com.vobiz.api.vobizxml;

/** {@code <Play>} a remote MP3/WAV URL (text content). */
public final class PlayElement extends VobizXmlElement<PlayElement> {

    PlayElement() {
        super("Play");
    }

    PlayElement(String url) {
        super("Play");
        if (url != null) {
            text(url);
        }
    }
}
