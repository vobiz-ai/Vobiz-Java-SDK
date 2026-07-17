/*
 * VobizXmlElement - base element + serialization for the Vobiz call-control XML builder.
 *
 * Mirrors the Python `vobizxml` package and the Node `@vobiz/sdk` `vobizxml` namespace
 * (ResponseElement + add* builders + toString()), and emits byte-identical XML. Java has
 * no kwargs, so attributes are set with an ordered, fluent API:
 *
 *     ResponseElement r = new ResponseElement();
 *     r.addGather()
 *         .attr("action", "https://yourapp.com/menu")
 *         .attr("inputType", "dtmf")
 *         .attr("numDigits", 1)
 *         .addSpeak("Press 1 for sales, 2 for support.");
 *     r.addHangup();
 *     System.out.println(r.toString());        // pretty, with XML declaration
 *     String compact = r.toXml(false);         // single line for webhook responses
 *
 * Attribute names are the camelCase VobizXML names directly (inputType, numDigits,
 * executionTimeout, callerId, startConferenceOnEnter, sendDigits, audioTrack, ...).
 */
package com.vobiz.api.vobizxml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A single VobizXML element. Holds an ordered attribute map, optional text content,
 * and child elements. The self-type parameter {@code T} lets {@link #attr} and
 * {@link #text} return the concrete subtype so fluent chains keep their element-specific
 * methods.
 *
 * @param <T> the concrete element type (for fluent self-returning methods)
 */
public abstract class VobizXmlElement<T extends VobizXmlElement<T>> {

    /** XML declaration prepended to every serialized document. */
    public static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /** Indentation unit (4 spaces), matching the xml/*.mdx reference style. */
    static final String INDENT = "    ";

    final String name;
    String content;
    boolean raw; // if true, content is inserted without escaping (e.g. SSML)
    final List<VobizXmlElement<?>> children = new ArrayList<>();
    final Map<String, String> attributes = new LinkedHashMap<>();

    protected VobizXmlElement(String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    private T self() {
        return (T) this;
    }

    // --- Attribute API (ordered, null-skipping) ------------------------------

    /** Set a string attribute. {@code null} is ignored (attribute omitted). */
    public T attr(String key, String value) {
        if (value != null) {
            attributes.put(key, value);
        }
        return self();
    }

    /** Set a boolean attribute, rendered as {@code true}/{@code false}. */
    public T attr(String key, boolean value) {
        attributes.put(key, value ? "true" : "false");
        return self();
    }

    /** Set an integer attribute. */
    public T attr(String key, int value) {
        attributes.put(key, Integer.toString(value));
        return self();
    }

    /** Set a long attribute. */
    public T attr(String key, long value) {
        attributes.put(key, Long.toString(value));
        return self();
    }

    /** Set a double attribute. */
    public T attr(String key, double value) {
        attributes.put(key, Double.toString(value));
        return self();
    }

    /** Set an attribute from any object (Boolean -&gt; true/false, else String.valueOf). {@code null} ignored. */
    public T attr(String key, Object value) {
        if (value == null) {
            return self();
        }
        if (value instanceof Boolean) {
            attributes.put(key, ((Boolean) value) ? "true" : "false");
        } else {
            attributes.put(key, String.valueOf(value));
        }
        return self();
    }

    // --- Text content --------------------------------------------------------

    /** Set the (escaped) text content of this element; returns this for chaining. */
    public T text(String content) {
        this.content = content;
        this.raw = false;
        return self();
    }

    /** Internal: set raw (unescaped) content, e.g. SSML passthrough. */
    T setRawContent(String content) {
        this.content = content;
        this.raw = true;
        return self();
    }

    // --- Child management ----------------------------------------------------

    /** Append a child element and return it (so callers can keep nesting). */
    <C extends VobizXmlElement<?>> C add(C child) {
        children.add(child);
        return child;
    }

    // --- Serialization -------------------------------------------------------

    static String escape(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    static String escapeAttr(String value) {
        return escape(value).replace("\"", "&quot;");
    }

    private String openTag() {
        StringBuilder sb = new StringBuilder(name);
        for (Map.Entry<String, String> e : attributes.entrySet()) {
            sb.append(' ').append(e.getKey()).append("=\"").append(escapeAttr(e.getValue())).append('"');
        }
        return sb.toString();
    }

    String render(int level, boolean pretty) {
        String pad = pretty ? INDENT.repeat(level) : "";
        String openTag = openTag();

        // Empty element -> self-closing
        if (children.isEmpty() && content == null) {
            return pad + "<" + openTag + "/>";
        }
        // Text-content element -> single line
        if (children.isEmpty()) {
            String body = raw ? content : escape(content);
            return pad + "<" + openTag + ">" + body + "</" + name + ">";
        }
        // Container element -> children indented (content, if any, is ignored)
        StringBuilder sb = new StringBuilder();
        sb.append(pad).append("<").append(openTag).append(">");
        if (pretty) {
            for (VobizXmlElement<?> c : children) {
                sb.append("\n").append(c.render(level + 1, pretty));
            }
            sb.append("\n").append(pad);
        } else {
            for (VobizXmlElement<?> c : children) {
                sb.append(c.render(level + 1, pretty));
            }
        }
        sb.append("</").append(name).append(">");
        return sb.toString();
    }

    /** Serialize to a VobizXML document string (with the XML declaration). */
    public String toXml(boolean pretty) {
        return XML_DECLARATION + (pretty ? "\n" : "") + render(0, pretty);
    }

    /** Pretty-printed VobizXML document (with the XML declaration). */
    @Override
    public String toString() {
        return toXml(true);
    }
}
