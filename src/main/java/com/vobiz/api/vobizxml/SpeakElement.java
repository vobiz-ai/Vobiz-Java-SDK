package com.vobiz.api.vobizxml;

/** {@code <Speak>} text-to-speech. Use {@link #ssml} to inject raw SSML unescaped. */
public final class SpeakElement extends VobizXmlElement<SpeakElement> {

    SpeakElement() {
        super("Speak");
    }

    SpeakElement(String content) {
        super("Speak");
        if (content != null) {
            text(content);
        }
    }

    /** Inject raw SSML markup as the body, bypassing XML escaping; returns this for chaining. */
    public SpeakElement ssml(String ssml) {
        return setRawContent(ssml);
    }
}
