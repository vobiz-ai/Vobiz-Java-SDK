# Vobiz Java SDK

The official Java SDK for [Vobiz](https://vobiz.ai) — an AI-first voice and telephony API platform for builders. Use it to make and control calls, manage SIP trunks and phone numbers, run conferences, handle recordings, and more, straight from your Java applications.

## Quick links

- **Documentation:** https://docs.vobiz.ai
- **Dashboard:** https://console.vobiz.ai
- **Full API reference:** [`./reference.md`](./reference.md)

## Installation

The SDK is published to Maven Central under the coordinates `ai.vobiz:vobiz-java`.

**Gradle**

```groovy
implementation 'ai.vobiz:vobiz-java:1.0.0'
```

**Maven**

```xml
<dependency>
    <groupId>ai.vobiz</groupId>
    <artifactId>vobiz-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Authentication

Vobiz authenticates requests with an **Auth ID** and an **Auth Token**, sent as the
`X-Auth-ID` and `X-Auth-Token` headers. You can find both in your
[dashboard](https://console.vobiz.ai). Pass them to the client builder:

```java
import com.vobiz.api.VobizApiClient;

VobizApiClient client = VobizApiClient
    .builder()
    .apiKey("<AUTH_ID>")
    .authToken("<AUTH_TOKEN>")
    .build();
```

> Keep your Auth Token secret. Load credentials from environment variables or a secrets
> manager rather than hard-coding them.

## Quickstart

The example below places an outbound call. Replace the auth credentials, the account
Auth ID (`MA_XXXXXX`), the numbers, and the answer URL with your own values.

```java
package com.example.usage;

import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.calls.requests.MakeCallRequest;

public class Example {
    public static void main(String[] args) {
        VobizApiClient client = VobizApiClient
            .builder()
            .apiKey("<AUTH_ID>")
            .authToken("<AUTH_TOKEN>")
            .build();

        client.calls().makeCall(
            "MA_XXXXXX",
            MakeCallRequest
                .builder()
                .from("14155551234")
                .to("+919876543210")
                .answerUrl("https://example.com/answer")
                .answerMethod("POST")
                .build()
        );
    }
}
```

See [`./reference.md`](./reference.md) for the full list of resources and methods.

## Error handling

When the API returns a non-success status code (4xx or 5xx), the SDK throws a
`VobizApiApiException`:

```java
import com.vobiz.api.core.VobizApiApiException;

try {
    client.calls().makeCall(...);
} catch (VobizApiApiException e) {
    // Inspect the API exception and handle it...
}
```

The SDK also retries retryable requests automatically with exponential backoff, and
defaults to a 60-second timeout. Both are configurable via `maxRetries(...)` and
`timeout(...)` on the client builder — see [`./reference.md`](./reference.md) and the
sections above for details.

## Other SDKs

Vobiz ships official SDKs for several languages:

| Language   | Repository |
| ---------- | ---------- |
| TypeScript | https://github.com/vobiz-ai/Vobiz-Node-SDK |
| Python     | https://github.com/vobiz-ai/Vobiz-Python-SDK |
| Go         | https://github.com/vobiz-ai/Vobiz-Go-SDK |
| Ruby       | https://github.com/vobiz-ai/Vobiz-Ruby-SDK |
| C#         | https://github.com/vobiz-ai/Vobiz-Csharp-sdk |
| PHP        | https://github.com/vobiz-ai/Vobiz-PHP-SDK |

## License

Released under the [MIT License](https://opensource.org/licenses/MIT).
