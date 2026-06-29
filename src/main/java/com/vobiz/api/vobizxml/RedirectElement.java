package com.vobiz.api.vobizxml;

/** {@code <Redirect>} transfer flow control to a URL (text content). */
public final class RedirectElement extends VobizXmlElement<RedirectElement> {

    RedirectElement() {
        super("Redirect");
    }

    RedirectElement(String url) {
        super("Redirect");
        if (url != null) {
            text(url);
        }
    }
}
