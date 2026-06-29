package com.vobiz.api.vobizxml;

/** {@code <Gather>} collect DTMF/speech input. Nest {@code Speak}/{@code Play} prompts inside. */
public final class GatherElement extends VobizXmlElement<GatherElement> {

    GatherElement() {
        super("Gather");
    }

    /** Add a {@code <Speak>} prompt; returns the created child for further configuration. */
    public SpeakElement addSpeak() {
        return add(new SpeakElement());
    }

    /** Add a {@code <Speak>} prompt with text content. */
    public SpeakElement addSpeak(String content) {
        return add(new SpeakElement(content));
    }

    /** Add a {@code <Play>} prompt. */
    public PlayElement addPlay() {
        return add(new PlayElement());
    }

    /** Add a {@code <Play>} prompt with a URL. */
    public PlayElement addPlay(String url) {
        return add(new PlayElement(url));
    }
}
