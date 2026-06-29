package com.vobiz.api.vobizxml;

/** {@code <PreAnswer>} early-media block. Nest {@code Speak}/{@code Play}/{@code Wait} inside. */
public final class PreAnswerElement extends VobizXmlElement<PreAnswerElement> {

    PreAnswerElement() {
        super("PreAnswer");
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

    /** Add a {@code <Wait/>} pause. */
    public WaitElement addWait() {
        return add(new WaitElement());
    }
}
