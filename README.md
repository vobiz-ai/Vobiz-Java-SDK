# Vobiz Java Library

Java client for the Vobiz programmable voice API — place and control calls, manage numbers and SIP trunks, pull CDRs, and build VobizXML call flows from JVM applications.

[![Licence: MIT](https://img.shields.io/badge/licence-MIT-green.svg)](./LICENSE)
[![Java 8+](https://img.shields.io/badge/java-8%2B-orange.svg)](https://adoptium.net/)
[![Docs](https://img.shields.io/badge/docs-docs.vobiz.ai-blue.svg)](https://docs.vobiz.ai)
[![Built with Fern](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=Vobiz%2FJava)

## Overview

This library wraps the Vobiz REST API in typed Java classes. It is generated from
the Vobiz OpenAPI specification with [Fern](https://buildwithfern.com), so every
request type, response type, and endpoint method tracks the published API surface.
The generated source covers 27 resource groups — calls, live calls, CDRs,
recordings, conferences, phone numbers, SIP trunks, applications, endpoints,
sub-accounts, credentials, IP access control lists, and the partner API among them.

Two clients are provided. `VobizApiClient` is synchronous and returns response
objects directly. `AsyncVobizApiClient` mirrors the same surface and returns
`CompletableFuture` values, which suits servlet containers, reactive bridges, and
anything already composing futures.

Alongside the generated client, the package `com.vobiz.api.vobizxml` holds a
hand-written builder for VobizXML — the XML dialect Vobiz fetches from your
`answer_url` to drive a live call. You can therefore both originate a call and
answer its webhook from the same dependency.

Transport is OkHttp; JSON binding is Jackson. Automatic retries with exponential
backoff and configurable timeouts are built in.

## Installation

This library is not yet published to Maven Central, so install it from source.

**Clone and publish to your local Maven repository:**

```bash
git clone https://github.com/vobiz-ai/Vobiz-Java-SDK.git
cd Vobiz-Java-SDK
gradle publishToMavenLocal -PsdkVersion=0.0.1
```

Then depend on it, with `mavenLocal()` in your repositories:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'ai.vobiz:vobiz-java:0.0.1'
}
```

**Or vendor it as a composite build**, which avoids the publish step entirely:

```groovy
// settings.gradle
includeBuild '../Vobiz-Java-SDK'
```

**Or build a jar and drop it on the classpath:**

```bash
gradle build          # jar lands in build/libs/
gradle test           # run the generated tests
```

Requirements: JDK 11 or newer to build (the produced bytecode targets Java 8) and
Gradle. Runtime dependencies — Jackson, OkHttp — are declared in `build.gradle`
and resolved for you.

Coordinates are `ai.vobiz:vobiz-java`, set in `build.gradle`. Once the library is
published to Maven Central, the same coordinates will resolve without the local
publish step.

## Authentication

Every request carries three credentials, all of which the builder requires:

| Header | Builder method | Where to find it |
| --- | --- | --- |
| `Authorization: Bearer <token>` | `.token(...)` | Vobiz console |
| `X-Auth-ID` | `.authId(...)` | Vobiz console |
| `X-Auth-Token` | `.authToken(...)` | Vobiz console |

`VobizApiClientBuilder.build()` throws if any of the three is missing, so there is
no partially authenticated client to debug. `.token(...)` sets the bearer header;
`.authId(...)` and `.authToken(...)` set the two `X-Auth-*` headers.

```java
import core.Environment;

VobizApiClient client = VobizApiClient
    .builder()
    .token(System.getenv("VOBIZ_TOKEN"))
    .authId(System.getenv("VOBIZ_AUTH_ID"))
    .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
    .build();
```

Read credentials from the environment or a secret manager. Do not commit them.

Note that most endpoint methods also take the auth ID as their first argument —
it identifies the account or sub-account the call acts on, and it is separate from
the header used to authenticate the request.

## Quickstart

Place an outbound call. Vobiz dials `to`, and when the leg is answered it fetches
VobizXML from `answerUrl` to decide what happens next.

```java
import core.Environment;
import resources.calls.requests.MakeCallRequest;
import resources.calls.types.MakeCallResponse;

public class MakeCall {
    public static void main(String[] args) {
        String authId = System.getenv("VOBIZ_AUTH_ID");

        VobizApiClient client = VobizApiClient
            .builder()
            .token(System.getenv("VOBIZ_TOKEN"))
            .authId(authId)
            .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
            .build();

        MakeCallResponse response = client.calls().makeCall(
            authId,
            MakeCallRequest
                .builder()
                .from("+15550001111")
                .to("+15550003333")
                .answerUrl("https://example.com/answer")
                .answerMethod("POST")
                .build()
        );

        System.out.println(response.getRequestUuid());
        System.out.println(response.getMessage());
    }
}
```

`MakeCallRequest.builder()` is a staged builder: `from`, `to`, `answerUrl`, and
`answerMethod` must be supplied in that order, and the compiler enforces it, so a
request missing a required field will not compile.

`to` accepts multiple destinations separated by `<` to fan a single request out to
up to 1000 numbers, for example `+15550003333<+15550004444`.

The class above has no `package` declaration. That is deliberate — see
[Troubleshooting](#troubleshooting).

## Common operations

**List live calls and hang one up**

```java
import resources.livecalls.requests.ListLiveCallsRequest;
import resources.livecalls.types.ListLiveCallsResponse;

ListLiveCallsResponse live = client.liveCalls().listLiveCalls(
    authId,
    ListLiveCallsRequest.builder().build()
);

client.liveCalls().hangupCall(authId, "call-uuid-here");
```

**Query call detail records**

```java
import resources.cdr.requests.ListCdrsRequest;
import resources.cdr.types.ListCdrsResponse;

ListCdrsResponse cdrs = client.cdr().listCdrs(
    authId,
    ListCdrsRequest
        .builder()
        .startDate("2026-01-01")
        .endDate("2026-01-31")
        .perPage(100)
        .page(1)
        .build()
);
```

`client.cdr().searchCdrs(...)`, `client.cdr().listRecentCdrs(...)` and
`client.cdr().getCdr(authId, callId)` cover the rest of the CDR surface;
`client.cdr().exportCdrs(...)` returns an `InputStream` for the export download.

**Speak text into a call that is already up**

```java
import resources.speaktext.requests.SpeakTextCallRequest;

client.speakText().call(
    authId,
    "call-uuid-here",
    SpeakTextCallRequest.builder().build()
);

client.speakText().stopSpeakCall(authId, "call-uuid-here");
```

`client.playAudio().call(...)` and `client.playAudio().stopAudioCall(...)` do the
same for audio files.

**List and manage phone numbers**

```java
import resources.phonenumbers.requests.ListNumbersRequest;
import resources.phonenumbers.types.ListNumbersResponse;

ListNumbersResponse numbers = client.phoneNumbers().listNumbers(authId);

client.phoneNumbers().assignNumberToTrunk(authId, "+15550001111", request);
client.phoneNumbers().getNumberHealth(authId, "+15550001111");
```

**Check the account balance**

```java
import resources.balance.types.GetBalanceResponse;

GetBalanceResponse balance = client.balance().getBalance(authId, "USD");
```

**Async variant**

```java
import java.util.concurrent.CompletableFuture;

AsyncVobizApiClient async = AsyncVobizApiClient
    .builder()
    .token(token)
    .authId(authId)
    .authToken(authToken)
    .build();

CompletableFuture<MakeCallResponse> future = async.calls().makeCall(authId, request);
```

The full method-by-method surface is in [`reference.md`](./reference.md).

## VobizXML

`com.vobiz.api.vobizxml` builds the XML documents Vobiz fetches from your
`answer_url`. Start at `ResponseElement`, chain `add*` helpers, and serialise.

```java
import com.vobiz.api.vobizxml.ResponseElement;
import com.vobiz.api.vobizxml.GatherElement;

ResponseElement response = new ResponseElement();

GatherElement gather = response.addGather()
    .attr("action", "https://example.com/menu")
    .attr("inputType", "dtmf")
    .attr("numDigits", 1)
    .attr("executionTimeout", 10);
gather.addSpeak("Press 1 for sales, 2 for support.");

response.addSpeak("We did not receive your input. Goodbye.");
response.addHangup();

String xml = response.toXml(false);   // compact — return this from your webhook
System.out.println(response);         // toString() is pretty-printed
```

Elements available from `ResponseElement`: `addSpeak`, `addPlay`, `addWait`,
`addGather` (aliased as `addGetDigits` and `addGetInput`), `addDial`, `addRecord`,
`addConference`, `addDtmf`, `addRedirect`, `addHangup`, `addPreAnswer`, and
`addStream`. `DialElement` adds `addNumber`, `addUser`, and `addRecord`;
`GatherElement` adds `addSpeak` and `addPlay`.

Attributes are set with the typed `attr(...)` overloads (`String`, `boolean`,
`int`, `long`, `double`, `Object`); element text is set with `text(...)`.
`toXml(true)` pretty-prints, `toXml(false)` emits a single line, and both prefix
the XML declaration.

The VobizXML reference, including every attribute each element accepts, is at
[docs.vobiz.ai](https://docs.vobiz.ai).

## Configuration

All configuration goes through `VobizApiClient.builder()`.

| Option | Method | Default |
| --- | --- | --- |
| Bearer token | `.token(String)` | required |
| Auth ID header | `.authId(String)` | required |
| Auth token header | `.authToken(String)` | required |
| Environment | `.environment(Environment)` | `Environment.PRODUCTION` |
| Custom base URL | `.url(String)` | — |
| Request timeout, seconds | `.timeout(int)` | 60 |
| Retry attempts | `.maxRetries(int)` | 2 |
| HTTP client | `.httpClient(OkHttpClient)` | one is constructed |
| Extra headers | `.addHeader(String, String)` | — |
| Logging | `.logging(LogConfig)` | silent |

`core.Environment` currently defines `Environment.PRODUCTION`, pointing at
`https://api.vobiz.ai`. `Environment.custom(url)` — or the `.url(...)` shorthand —
targets any other host, which is what you want for a local mock or a proxy.

```java
import core.Environment;

VobizApiClient client = VobizApiClient
    .builder()
    .token(token).authId(authId).authToken(authToken)
    .environment(Environment.custom("http://localhost:8080"))
    .timeout(30)
    .maxRetries(3)
    .addHeader("X-Request-Id", "abc-123")
    .build();
```

**Per-request overrides.** Every endpoint method takes an optional trailing
`core.RequestOptions`:

```java
import core.RequestOptions;

client.calls().makeCall(
    authId,
    request,
    RequestOptions.builder().timeout(10).addHeader("X-Request-Header", "value").build()
);
```

**Retries.** Requests are retried with exponential backoff up to `maxRetries`
attempts. The client first honours a `Retry-After` header (seconds or HTTP date),
then `X-RateLimit-Reset` (Unix epoch seconds), and falls back to exponential
backoff. Retried statuses are 408, 429, and all 5XX.

**Custom OkHttp client.** Pass your own instance to reuse a connection pool, add
interceptors, or wire in your own proxy settings:

```java
import okhttp3.OkHttpClient;

OkHttpClient http = new OkHttpClient.Builder().build();

VobizApiClient client = VobizApiClient
    .builder()
    .token(token).authId(authId).authToken(authToken)
    .httpClient(http)
    .build();
```

**Raw responses.** `withRawResponse()` returns a client whose methods yield
`core.VobizApiHttpResponse<T>`, exposing `body()` and `headers()`:

```java
import core.VobizApiHttpResponse;

VobizApiHttpResponse<MakeCallResponse> raw =
    client.calls().withRawResponse().makeCall(authId, request);

System.out.println(raw.body().getRequestUuid());
System.out.println(raw.headers().get("X-RateLimit-Remaining"));
```

## Error handling

The exception hierarchy lives in `core` and `errors`:

- `core.VobizApiException` — base class for everything the SDK throws.
- `core.VobizApiApiException` — extends the base, thrown for any non-2XX
  response. Exposes `statusCode()`, `body()`, and `headers()`.
- `errors.*` — one subclass of `VobizApiApiException` per documented status, so
  you can catch precisely what you care about.

| Class | Status |
| --- | --- |
| `errors.BadRequestError` | 400 |
| `errors.UnauthorizedError` | 401 |
| `errors.ForbiddenError` | 403 |
| `errors.NotFoundError` | 404 |
| `errors.ConflictError` | 409 |
| `errors.UnprocessableEntityError` | 422 |
| `errors.TooManyRequestsError` | 429 |
| `errors.InternalServerError` | 500 |

```java
import core.VobizApiApiException;
import core.VobizApiException;
import errors.TooManyRequestsError;
import errors.UnauthorizedError;

try {
    client.calls().makeCall(authId, request);
} catch (UnauthorizedError e) {
    // credentials rejected — check token, authId, authToken
} catch (TooManyRequestsError e) {
    // rate limited beyond the automatic retries
} catch (VobizApiApiException e) {
    System.err.println(e.statusCode() + " " + e.body());
} catch (VobizApiException e) {
    // transport failure, serialisation failure, or similar
}
```

Because the `errors.*` classes all extend `VobizApiApiException`, order your catch
blocks from most to least specific.

## Pagination

The list endpoints that support paging expose `page` and `perPage` on their
request builders — `ListCdrsRequest`, `ListNumbersRequest`, `ListRecordingsRequest`
and their siblings. Page numbers start at 1, and `perPage` is capped at 100.

```java
int page = 1;
while (true) {
    ListCdrsResponse batch = client.cdr().listCdrs(
        authId,
        ListCdrsRequest.builder().page(page).perPage(100).build()
    );
    // process batch
    page++;
    // stop when the returned page is short or the meta block reports no next page
}
```

There is no auto-paging iterator in this generated client; loop over pages
yourself, as above.

## Troubleshooting

| Symptom | Likely cause | Fix |
| --- | --- | --- |
| `RuntimeException: Please provide token` (or `authId` / `authToken`) at `build()` | The builder requires all three credentials | Supply `.token(...)`, `.authId(...)` and `.authToken(...)` before `.build()` |
| `error: cannot find symbol: class VobizApiClient` when your code is in a named package | The generated `VobizApiClient`, `VobizApiClientBuilder`, `AsyncVobizApiClient` and `AsyncVobizApiClientBuilder` sit in the default package, and Java cannot import a default-package class into a named one | Put the calling class in the default package, or wrap the client in a thin factory class that also lives in the default package and expose that. Adding a generator `package-prefix` is on the roadmap |
| `import com.vobiz.api.VobizApiClient` does not resolve | That package does not exist in this build; `com.vobiz.api.vobizxml` is the only `com.vobiz` package present | Drop the import for the client; keep `com.vobiz.api.vobizxml.*` imports for VobizXML |
| `UnauthorizedError` (401) on every call | Bearer token or `X-Auth-*` pair is wrong, or belongs to a different environment | Re-copy all three values from the Vobiz console; confirm you are pointed at `Environment.PRODUCTION` |
| `NotFoundError` (404) on a call-scoped method | The call UUID has already ended, or the auth ID argument does not own it | Confirm the UUID against `client.liveCalls().listLiveCalls(...)` and pass the auth ID that owns the call |
| `TooManyRequestsError` (429) surfacing despite retries | The burst exceeds what two retries absorb | Raise `.maxRetries(...)`, or space requests out; the client already honours `Retry-After` and `X-RateLimit-Reset` |
| Read timeouts on long polls or exports | 60-second default is short for `exportCdrs` and large listings | Raise `.timeout(...)` on the client, or per request via `RequestOptions.builder().timeout(...)` |
| `NoClassDefFoundError` for a Jackson or OkHttp class | The jar was placed on the classpath without its transitive dependencies | Depend on the Gradle module rather than the bare jar, or add Jackson and OkHttp yourself — versions are in `build.gradle` |
| Webhook returns 500 and the call drops | VobizXML serialised with the declaration on its own line, or the response is not `text/xml` | Return `response.toXml(false)` and set the content type to `text/xml` |

Turn on request logging while debugging by passing a `core.LogConfig` to
`.logging(...)`; the client is silent by default.

## Other Vobiz SDKs

The same API, generated for other languages:

| Language | Repository |
| --- | --- |
| Python | [vobiz-ai/Vobiz-Python-SDK](https://github.com/vobiz-ai/Vobiz-Python-SDK) |
| Node.js / TypeScript | [vobiz-ai/Vobiz-Node-SDK](https://github.com/vobiz-ai/Vobiz-Node-SDK) |
| Go | [vobiz-ai/Vobiz-Go-SDK](https://github.com/vobiz-ai/Vobiz-Go-SDK) |
| Ruby | [vobiz-ai/Vobiz-Ruby-SDK](https://github.com/vobiz-ai/Vobiz-Ruby-SDK) |
| C# / .NET | [vobiz-ai/Vobiz-Csharp-sdk](https://github.com/vobiz-ai/Vobiz-Csharp-sdk) |

## Versioning and stability

The version is set at build time from the `sdkVersion` Gradle property and falls
back to `0.0.1` for local builds. While the library sits below `1.0.0`, treat the
generated surface as evolving: regeneration from an updated OpenAPI specification
can rename types or add required fields.

Pin an exact version in your build rather than a range, and read the commit log
before upgrading. Once the API surface settles and the library is published to
Maven Central, releases will follow semantic versioning, with breaking changes
confined to major versions.

Most of this repository is generated. `src/main/java` is rewritten on every
regeneration. `build.gradle` and `settings.gradle` are hand-authored and are not
overwritten, so dependency and coordinate changes you make there survive.

## Roadmap

Planned improvements to this library. Ideas and pull requests are welcome —
open an issue to discuss anything here.

- [ ] Publish `ai.vobiz:vobiz-java` to Maven Central so the library resolves as an
      ordinary Gradle or Maven dependency, with signed artifacts and a javadoc jar.
- [ ] Set a generator `package-prefix` so the root client lands in
      `ai.vobiz.api` alongside the VobizXML package, and can be imported from any
      package.
- [ ] Ship auto-paging iterables for the list endpoints, so `page`/`perPage`
      loops are not written by hand.
- [ ] Compile-verify the hand-authored dependency versions in `build.gradle`
      against the generated source in CI on every regeneration.
- [ ] Add a runnable `examples/` module — outbound call, IVR webhook, CDR export —
      built against the published artifact.
- [ ] Extend the VobizXML builder with typed attribute setters per element, so
      attribute names are checked at compile time rather than passed as strings.
- [ ] Add webhook signature verification helpers for inbound `answer_url` and
      status-callback requests.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!

See [CONTRIBUTING.md](./CONTRIBUTING.md) for the build, test, and formatting
commands. In short:

```bash
gradle build          # compile
gradle test           # JUnit 5 suite
gradle spotlessApply  # formatting
```

## License

Released under the [MIT License](./LICENSE) © Vobiz.

MIT is permissive: you may use, modify, and redistribute this code, including in
closed-source commercial products, provided the copyright notice and licence text
are retained. There is no warranty. If your organisation needs a different
licensing arrangement, contact [piyush@vobiz.ai](mailto:piyush@vobiz.ai).

## Built by Team Vobiz

[Vobiz](https://vobiz.ai) is a programmable voice and SIP-trunking platform for
voice APIs, SIP trunking, and AI voice agents. This repository is built and
maintained by the Vobiz team.

**Maintainer:** Piyush Sahoo — [piyush@vobiz.ai](mailto:piyush@vobiz.ai) · [LinkedIn](https://www.linkedin.com/in/piyush-s713/)

Questions, or want to talk through an integration? Open an issue on this repo,
or reach out directly at [piyush@vobiz.ai](mailto:piyush@vobiz.ai).

**Useful links:** [Docs](https://docs.vobiz.ai) · [API reference](https://docs.vobiz.ai/api-reference) · [Sign up](https://vobiz.ai)
