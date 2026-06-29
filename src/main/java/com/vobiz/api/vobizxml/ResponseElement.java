package com.vobiz.api.vobizxml;

/**
 * {@code <Response>} root container. Use the {@code add*} helpers to build the document;
 * each returns the created child so you can configure attributes and nest further.
 */
public final class ResponseElement extends VobizXmlElement<ResponseElement> {

    public ResponseElement() {
        super("Response");
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

    /** Add a {@code <Gather>} input collector. */
    public GatherElement addGather() {
        return add(new GatherElement());
    }

    /** Plivo-parity alias: emits {@code <Gather>}. */
    public GatherElement addGetDigits() {
        return addGather();
    }

    /** Plivo-parity alias: emits {@code <Gather>}. */
    public GatherElement addGetInput() {
        return addGather();
    }

    /** Add a {@code <Dial>}. */
    public DialElement addDial() {
        return add(new DialElement());
    }

    /** Add a {@code <Dial>} with shorthand number text content. */
    public DialElement addDial(String number) {
        return add(new DialElement(number));
    }

    /** Add a top-level {@code <Record/>}. */
    public RecordElement addRecord() {
        return add(new RecordElement());
    }

    /** Add a {@code <Conference>}. */
    public ConferenceElement addConference() {
        return add(new ConferenceElement());
    }

    /** Add a {@code <Conference>} with a room name. */
    public ConferenceElement addConference(String room) {
        return add(new ConferenceElement(room));
    }

    /** Add a {@code <DTMF>}. */
    public DtmfElement addDtmf() {
        return add(new DtmfElement());
    }

    /** Add a {@code <DTMF>} with digits. */
    public DtmfElement addDtmf(String digits) {
        return add(new DtmfElement(digits));
    }

    /** Add a {@code <Redirect>}. */
    public RedirectElement addRedirect() {
        return add(new RedirectElement());
    }

    /** Add a {@code <Redirect>} with a URL. */
    public RedirectElement addRedirect(String url) {
        return add(new RedirectElement(url));
    }

    /** Add a {@code <Hangup/>}. */
    public HangupElement addHangup() {
        return add(new HangupElement());
    }

    /** Add a {@code <PreAnswer>} early-media block. */
    public PreAnswerElement addPreAnswer() {
        return add(new PreAnswerElement());
    }

    /** Add a {@code <Stream>}. */
    public StreamElement addStream() {
        return add(new StreamElement());
    }

    /** Add a {@code <Stream>} with a wss URL. */
    public StreamElement addStream(String url) {
        return add(new StreamElement(url));
    }
}
