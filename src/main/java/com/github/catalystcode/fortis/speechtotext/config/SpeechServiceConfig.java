package com.github.catalystcode.fortis.speechtotext.config;

import java.util.Locale;

import static com.github.catalystcode.fortis.speechtotext.constants.SpeechServiceConnectionHeaders.*;

public class SpeechServiceConfig {
    private final String subscriptionKey;
    private final Endpoint endpoint;
    private final Format format;
    private final Locale locale;
    private final String host;

    public SpeechServiceConfig(String subscriptionKey, Endpoint endpoint, Format format, Locale locale) {
        this.subscriptionKey = subscriptionKey;
        this.endpoint = endpoint;
        this.format = format;
        this.locale = locale;
        this.host = "wss://speech.platform.bing.com";
    }

    public String getConnectionUrl(String connectionId) {
        return new StringBuilder()
            .append(host)
            .append(endpoint.path)
            .append('?').append(LANGUAGE).append('=').append(locale.toString())
            .append('&').append(FORMAT).append('=').append(format.value)
            .append('&').append(CONNECTION_ID).append('=').append(connectionId)
            .append('&').append(SUBSCRIPTION_KEY).append('=').append(subscriptionKey)
            .toString();
    }
}
