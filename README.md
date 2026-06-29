# Vobiz Java SDK

The official Java SDK for [Vobiz](https://vobiz.ai), an AI-first voice and telephony API platform for builders. Integrate powerful voice capabilities into your Java applications to make and control calls, manage SIP trunks, provision phone numbers, handle conferences, and manage call recordings.

## Quick Links

- **Documentation:** [docs.vobiz.ai](https://docs.vobiz.ai)
- **Dashboard:** [console.vobiz.ai](https://console.vobiz.ai)
- **Full API Reference:** [`./reference.md`](./reference.md)

## Features

- **Call Management:** Initiate outbound calls, retrieve call detail records (CDRs), and hang up active calls.
- **SIP Trunking:** Configure and manage SIP trunks, credentials, and IP access control lists.
- **Phone Numbers:** List inventory, purchase numbers, and assign them to trunks or sub-accounts.
- **Conferences:** Create rooms, manage members (mute, deafen, kick), and record conferences.
- **Recordings & Audio:** Start/stop call recordings, play audio/TTS, and stream raw audio via WebSockets.
- **Partner API:** Manage customer sub-accounts, transfer balances, and handle KYC sessions.

## Requirements

- Java 8 or higher.
- A build tool such as Gradle or Maven.

## Installation

The SDK is published to Maven Central under the coordinates `ai.vobiz:vobiz-java`.

### Gradle
```groovy
implementation 'ai.vobiz:vobiz-java:1.0.0'
```

### Maven
```xml
<dependency>
    <groupId>ai.vobiz</groupId>
    <artifactId>vobiz-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Authentication

Vobiz authenticates requests using your **Auth ID** and **Auth Token**. These credentials are sent as `X-Auth-ID` and `X-Auth-Token` HTTP headers with every API request. You can find these in your [Vobiz Dashboard](https://console.vobiz.ai).

To initialize the `VobizApiClient`, pass your Auth ID to `.apiKey()` and your Auth Token to `.authToken()`:

```java
import com.vobiz.api.VobizApiClient;

// It is highly recommended to load credentials from environment variables
String authId = System.getenv("VOBIZ_AUTH_ID");
String authToken = System.getenv("VOBIZ_AUTH_TOKEN");

VobizApiClient client = VobizApiClient
    .builder()
    .apiKey(authId)
    .authToken(authToken)
    .build();
```

## Quickstart

The following example demonstrates how to make an outbound call. Replace placeholder values like `MA_XXXXXX` and phone numbers with your actual credentials and desired call parameters.

```java
package com.example.usage;

import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.calls.requests.MakeCallRequest;

public class Example {
    public static void main(String[] args) {
        String authId = System.getenv("VOBIZ_AUTH_ID");
        String authToken = System.getenv("VOBIZ_AUTH_TOKEN");

        VobizApiClient client = VobizApiClient
            .builder()
            .apiKey(authId)
            .authToken(authToken)
            .build();

        try {
            // Replace "MA_XXXXXX" with your actual account Auth ID
            client.calls().makeCall(
                "MA_XXXXXX",
                MakeCallRequest
                    .builder()
                    .from("14155551234") // Your Vobiz-enabled phone number or SIP URI
                    .to("+919876543210") // Destination phone number in E.164 format
                    .answerUrl("https://example.com/answer") // Webhook URL for call events
                    .answerMethod("POST")
                    .build()
            );
            System.out.println("Call initiated successfully!");
        } catch (Exception e) {
            System.err.println("Failed to make call: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

## Common Operations

### List Call Recordings
Retrieve a paginated list of call recordings on your account.

```java
import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.recordings.requests.ListRecordingsRequest;
import com.vobiz.api.resources.recordings.types.ListRecordingsResponse;

public class ListRecordingsExample {
    public static void main(String[] args) {
        VobizApiClient client = VobizApiClient.builder()
            .apiKey(System.getenv("VOBIZ_AUTH_ID"))
            .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
            .build();

        try {
            ListRecordingsResponse recordings = client.recordings().listRecordings(
                "MA_XXXXXX",
                ListRecordingsRequest
                    .builder()
                    .limit(10)
                    .offset(0)
                    .build()
            );
            
            recordings.getData().forEach(recording -> {
                System.out.println("Recording ID: " + recording.getRecordingId());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Purchase a Phone Number from Inventory
Browse and purchase available phone numbers from the Vobiz global inventory.

```java
import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.phonenumbers.requests.PurchaseFromInventoryRequest;

public class PurchaseNumberExample {
    public static void main(String[] args) {
        VobizApiClient client = VobizApiClient.builder()
            .apiKey(System.getenv("VOBIZ_AUTH_ID"))
            .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
            .build();

        try {
            Object purchaseResult = client.phoneNumbers().purchaseFromInventory(
                "MA_XXXXXX",
                PurchaseFromInventoryRequest
                    .builder()
                    .e164("+919876543210")
                    .currency("USD")
                    .build()
            );
            System.out.println("Number purchased successfully: " + purchaseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Create a Sub-Account (Partner Flow)
Create and configure a customer sub-account under your master account.

```java
import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.subaccounts.requests.CreateSubaccountRequest;
import com.vobiz.api.resources.subaccounts.requests.CreateSubaccountRequestKycMode;
import com.vobiz.api.resources.subaccounts.requests.CreateSubaccountRequestBusinessType;
import com.vobiz.api.resources.subaccounts.types.CreateSubaccountResponse;

public class CreateSubaccountExample {
    public static void main(String[] args) {
        VobizApiClient client = VobizApiClient.builder()
            .apiKey(System.getenv("VOBIZ_AUTH_ID"))
            .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
            .build();

        try {
            CreateSubaccountResponse subAccount = client.subAccounts().createSubaccount(
                "MA_XXXXXX",
                CreateSubaccountRequest
                    .builder()
                    .name("Customer Co")
                    .email("customer@example.com")
                    .password("Customer@12345")
                    .kycMode(CreateSubaccountRequestKycMode.CUSTOMER_USE)
                    .businessType(CreateSubaccountRequestBusinessType.PRIVATE_LIMITED)
                    .build()
            );
            System.out.println("Sub-account created with ID: " + subAccount.getAuthId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Stream Raw Call Audio to WebSockets
Start streaming real-time call audio from an active call leg to your WebSocket server.

```java
import com.vobiz.api.VobizApiClient;
import com.vobiz.api.resources.audiostreams.requests.StartStreamRequest;
import com.vobiz.api.resources.audiostreams.requests.StartStreamRequestAudioTrack;

public class AudioStreamExample {
    public static void main(String[] args) {
        VobizApiClient client = VobizApiClient.builder()
            .apiKey(System.getenv("VOBIZ_AUTH_ID"))
            .authToken(System.getenv("VOBIZ_AUTH_TOKEN"))
            .build();

        try {
            Object streamResult = client.audioStreams().startStream(
                "MA_XXXXXX",
                "call_uuid_here",
                StartStreamRequest
                    .builder()
                    .serviceUrl("wss://your-server.com/ws")
                    .bidirectional(true)
                    .audioTrack(StartStreamRequestAudioTrack.BOTH)
                    .build()
            );
            System.out.println("Audio stream started: " + streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Configuration

The SDK client is instantiated using the builder pattern. Authentication credentials are required for initialization:

```java
VobizApiClient client = VobizApiClient.builder()
    .apiKey("YOUR_AUTH_ID")
    .authToken("YOUR_AUTH_TOKEN")
    .build();
```

## Error Handling

The SDK throws standard Java `Exception`s (or specific runtime exceptions depending on the underlying HTTP client) when an API request fails. This can happen due to invalid credentials, malformed requests, or server errors. Always wrap your API calls in `try-catch` blocks to handle these gracefully.

```java
try {
    client.calls().makeCall("MA_XXXXXX", request);
} catch (Exception e) {
    System.err.println("API Error: " + e.getMessage());
    // Perform fallback logic or logging here
}
```

## Pagination

Endpoints that return lists of resources (such as `listCdrs`, `listNumbers`, `listRecordings`, and `listTransactions`) support pagination. Depending on the endpoint, you can control the page size and offset using `.limit()` and `.offset()`, or `.page()` and `.perPage()` in the respective request builder.

```java
ListRecordingsResponse recordings = client.recordings().listRecordings(
    "MA_XXXXXX",
    ListRecordingsRequest
        .builder()
        .limit(20)
        .offset(40)
        .build()
);
```

## Other Vobiz SDKs

Vobiz provides official SDKs for several popular programming languages:

| Language | Repository |
| :--- | :--- |
| Node.js / TypeScript | [Vobiz-Node-SDK](https://github.com/vobiz-ai/Vobiz-Node-SDK) |
| Python | [Vobiz-Python-SDK](https://github.com/vobiz-ai/Vobiz-Python-SDK) |
| Go | [Vobiz-Go-SDK](https://github.com/vobiz-ai/Vobiz-Go-SDK) |
| Ruby | [Vobiz-Ruby-SDK](https://github.com/vobiz-ai/Vobiz-Ruby-SDK) |
| C# / .NET | [Vobiz-Csharp-sdk](https://github.com/vobiz-ai/Vobiz-Csharp-sdk) |
| PHP | [Vobiz-PHP-SDK](https://github.com/vobiz-ai/Vobiz-PHP-SDK) |

## Support

If you encounter any issues or have questions, please check the [Vobiz Documentation](https://docs.vobiz.ai) or reach out via the support widget in your [Vobiz Dashboard](https://console.vobiz.ai).

## License

This SDK is distributed under the MIT License.
