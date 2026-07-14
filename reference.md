# Reference
## Account
<details><summary><code>client.account.retrieveAccount() -> RetrieveAccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve complete account details including pricing tier and credentials.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.account().retrieveAccount();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.account.getConcurrency(authId) -> GetConcurrencyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the current concurrent call usage and configured limits.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.account().getConcurrency(
    "MA_XXXXXX",
    GetConcurrencyRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Balance
<details><summary><code>client.balance.getBalance(authId, currency) -> GetBalanceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the current account balance for a specific currency.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.balance().getBalance(
    "MA_XXXXXX",
    "INR",
    GetBalanceRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**currency:** `String` — Currency code (e.g. INR, USD)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.balance.listTransactions(authId) -> ListTransactionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve paginated transaction history for the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.balance().listTransactions(
    "MA_XXXXXX",
    ListTransactionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Live Calls
<details><summary><code>client.liveCalls.listQueuedCalls(authId) -> ListQueuedCallsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all queued (pending, not yet connected) calls on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveCalls().listQueuedCalls(
    "MA_XXXXXX",
    ListQueuedCallsRequest
        .builder()
        .status(ListQueuedCallsRequestStatus.LIVE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**status:** `ListQueuedCallsRequestStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveCalls.listLiveCalls(authId) -> ListLiveCallsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all currently active (live) calls on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveCalls().listLiveCalls(
    "MA_XXXXXX",
    ListLiveCallsRequest
        .builder()
        .status(ListLiveCallsRequestStatus.LIVE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**status:** `ListLiveCallsRequestStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveCalls.getLiveCall(authId, callUuid) -> GetLiveCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve details of a specific live or queued call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveCalls().getLiveCall(
    "MA_XXXXXX",
    "cdr_XXXXXXXXXX",
    GetLiveCallRequest
        .builder()
        .status(GetLiveCallRequestStatus.LIVE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `GetLiveCallRequestStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveCalls.hangupCall(authId, callUuid)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Terminate an active call by its UUID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveCalls().hangupCall(
    "MA_XXXXXX",
    "call_uuid",
    HangupCallRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.liveCalls.getQueuedCall(authId, callUuid) -> GetQueuedCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve details of a specific queued (pending) call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.liveCalls().getQueuedCall(
    "MA_XXXXXX",
    "cdr_XXXXXXXXXX",
    GetQueuedCallRequest
        .builder()
        .status(GetQueuedCallRequestStatus.LIVE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `GetQueuedCallRequestStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Calls
<details><summary><code>client.calls.makeCall(authId, request) -> MakeCallResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Initiate an outbound call to a PSTN number or SIP endpoint.
Use `<` to separate multiple destinations (max 1000).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
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
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**from:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**to:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**answerUrl:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**answerMethod:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## CDR
<details><summary><code>client.cdr.listCdrs(authId) -> ListCdrsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all CDRs for your account. Supports filtering by phone numbers,
date range, call direction, duration, and pagination.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cdr().listCdrs(
    "MA_XXXXXX",
    ListCdrsRequest
        .builder()
        .fromNumber("9876543210")
        .toNumber("1234567890")
        .startDate("2026-03-01")
        .endDate("2026-03-17")
        .minDuration(10)
        .sipCallId("dD1qwu5VZ5iK3ed5u3uspjY5RKL")
        .bridgeUuid("4b7ae653-f40d-42f1-b582-6b05dfcd0c0a")
        .hangupCause("NORMAL_CLEARING")
        .hangupDisposition("send_refuse")
        .context("sip-trunking")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**fromNumber:** `Optional<String>` — Filter by the originating phone number (caller).
    
</dd>
</dl>

<dl>
<dd>

**toNumber:** `Optional<String>` — Filter by the destination phone number (callee).
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` — Beginning of the search period (YYYY-MM-DD). Required when using `end_date`.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `Optional<String>` — End of the search period (YYYY-MM-DD). Required when using `start_date`.
    
</dd>
</dl>

<dl>
<dd>

**callDirection:** `Optional<ListCdrsRequestCallDirection>` — Filter by direction.
    
</dd>
</dl>

<dl>
<dd>

**minDuration:** `Optional<Integer>` — Minimum call duration in seconds. Excludes calls shorter than this value.
    
</dd>
</dl>

<dl>
<dd>

**sipCallId:** `Optional<String>` — Filter by the SIP Call-ID of the call (matches the cdr's sip_call_id field).
    
</dd>
</dl>

<dl>
<dd>

**bridgeUuid:** `Optional<String>` — Filter by the UUID of the bridged leg (matches the cdr's bridge_uuid field).
    
</dd>
</dl>

<dl>
<dd>

**hangupCause:** `Optional<String>` — Filter by telephony hangup cause, e.g. NORMAL_CLEARING.
    
</dd>
</dl>

<dl>
<dd>

**hangupDisposition:** `Optional<String>` — Filter by how the leg was released, e.g. send_refuse.
    
</dd>
</dl>

<dl>
<dd>

**context:** `Optional<String>` — Filter by the call context, e.g. sip-trunking.
    
</dd>
</dl>

<dl>
<dd>

**campaignId:** `Optional<String>` — Filter by the campaign identifier associated with the call.
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Free-text search across CDR fields (numbers, IDs, etc.).
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — Page number for paginated results.
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — Number of records per page. Max: 100.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cdr.searchCdrs(authId) -> SearchCdrsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Identical filters to the list endpoint, but the response also includes a
`filter_summary` object describing the active filters applied.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cdr().searchCdrs(
    "MA_XXXXXX",
    SearchCdrsRequest
        .builder()
        .fromNumber("9876543210")
        .toNumber("1234567890")
        .startDate("2026-03-01")
        .endDate("2026-03-17")
        .minDuration(10)
        .sipCallId("dD1qwu5VZ5iK3ed5u3uspjY5RKL")
        .bridgeUuid("4b7ae653-f40d-42f1-b582-6b05dfcd0c0a")
        .hangupCause("NORMAL_CLEARING")
        .hangupDisposition("send_refuse")
        .context("sip-trunking")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**fromNumber:** `Optional<String>` — Filter by the originating phone number (caller).
    
</dd>
</dl>

<dl>
<dd>

**toNumber:** `Optional<String>` — Filter by the destination phone number (callee).
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` — Beginning of the search period (YYYY-MM-DD). Required when using `end_date`.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `Optional<String>` — End of the search period (YYYY-MM-DD). Required when using `start_date`.
    
</dd>
</dl>

<dl>
<dd>

**callDirection:** `Optional<SearchCdrsRequestCallDirection>` — Filter by direction.
    
</dd>
</dl>

<dl>
<dd>

**minDuration:** `Optional<Integer>` — Minimum call duration in seconds. Excludes calls shorter than this value.
    
</dd>
</dl>

<dl>
<dd>

**sipCallId:** `Optional<String>` — Filter by the SIP Call-ID of the call (matches the cdr's sip_call_id field).
    
</dd>
</dl>

<dl>
<dd>

**bridgeUuid:** `Optional<String>` — Filter by the UUID of the bridged leg (matches the cdr's bridge_uuid field).
    
</dd>
</dl>

<dl>
<dd>

**hangupCause:** `Optional<String>` — Filter by telephony hangup cause, e.g. NORMAL_CLEARING.
    
</dd>
</dl>

<dl>
<dd>

**hangupDisposition:** `Optional<String>` — Filter by how the leg was released, e.g. send_refuse.
    
</dd>
</dl>

<dl>
<dd>

**context:** `Optional<String>` — Filter by the call context, e.g. sip-trunking.
    
</dd>
</dl>

<dl>
<dd>

**campaignId:** `Optional<String>` — Filter by the campaign identifier associated with the call.
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Free-text search across CDR fields (numbers, IDs, etc.).
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — Page number for paginated results.
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — Number of records per page. Max: 100.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cdr.listRecentCdrs(authId) -> ListRecentCdrsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the most recent CDRs for your account without requiring a date range.
Default 20 records; use `limit` to retrieve more.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cdr().listRecentCdrs(
    "MA_XXXXXX",
    ListRecentCdrsRequest
        .builder()
        .limit(50)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of recent CDRs to return.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cdr.getCdr(authId, callId) -> GetCdrResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the CDR for a specific completed call using its `call_id`.
Useful when you have a `call_id` from a callback or previous API response.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cdr().getCdr(
    "MA_XXXXXX",
    "abc123-def456-ghi789",
    GetCdrRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callId:** `String` — The unique call ID of the completed call.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sub-Accounts
<details><summary><code>client.subAccounts.listSubaccounts(authId) -> ListSubaccountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all sub-accounts under the master account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccounts().listSubaccounts(
    "MA_XXXXXX",
    ListSubaccountsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccounts.createSubaccount(authId, request) -> CreateSubaccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new sub-account under the master account.

Set `kyc_mode` to control how the sub-account is verified:

- `personal_use` *(default)* — the sub-account inherits the parent's
  KYC; no separate verification is required.
- `customer_use` — the sub-account must complete its own KYC before it
  can place calls. A fresh `customer_use` sub-account is returned with
  `kyc_calls_blocked: true`. `customer_use` **requires** `email`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccounts().createSubaccount(
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
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Human-readable name for the sub-account.
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` — Required when `kyc_mode` is `customer_use`.
    
</dd>
</dl>

<dl>
<dd>

**password:** `Optional<String>` — Login password for the sub-account.
    
</dd>
</dl>

<dl>
<dd>

**kycMode:** `Optional<CreateSubaccountRequestKycMode>` 

`personal_use` inherits parent KYC. `customer_use` requires
the sub-account to complete its own KYC and requires `email`.
    
</dd>
</dl>

<dl>
<dd>

**businessType:** `Optional<CreateSubaccountRequestBusinessType>` — Legal constitution of the customer. Drives which KYC documents are required.
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccounts.retrieveSubaccount(authId, subAuthId) -> RetrieveSubaccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve details of a specific sub-account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccounts().retrieveSubaccount(
    "MA_XXXXXX",
    "SA_XXXXXX",
    RetrieveSubaccountRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**subAuthId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccounts.updateSubaccount(authId, subAuthId, request) -> UpdateSubaccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the name or status of a sub-account, or change its `kyc_mode`.

Promoting an existing sub-account to `customer_use` requires the
sub-account to already have an `email` (otherwise `400`). On any
`kyc_mode` change, `kyc_calls_blocked` is re-derived from the
sub-account's current KYC state.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccounts().updateSubaccount(
    "MA_XXXXXX",
    "sub_auth_id",
    UpdateSubaccountRequest
        .builder()
        .kycMode(UpdateSubaccountRequestKycMode.CUSTOMER_USE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**subAuthId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**enabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**kycMode:** `Optional<UpdateSubaccountRequestKycMode>` — Change the verification mode. Promoting to `customer_use` requires the sub-account to have an `email`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccounts.deleteSubaccount(authId, subAuthId) -> Optional&amp;lt;DeleteSubaccountResponse&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete a sub-account and revoke its credentials.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccounts().deleteSubaccount(
    "MA_XXXXXX",
    "sub_auth_id",
    DeleteSubaccountRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**subAuthId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sub-Account KYC
<details><summary><code>client.subAccountKyc.getSubaccountKycStatus(subAuthId) -> SubAccountKycStatus</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the aggregated KYC state for a `customer_use` sub-account —
which verifications have passed, whether calls are still blocked, and
the business type. The caller must be the parent main account that owns
the sub-account (or an admin).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().getSubaccountKycStatus(
    "SA_XXXXXX",
    GetSubaccountKycStatusRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.verifySubaccountPan(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Runs a real PAN verification (Perfios) for the sub-account. `pan` must
be exactly 10 characters. Persists a `kyc_verifications` row and
recomputes the sub-account's aggregated `kyc_status`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().verifySubaccountPan(
    "SA_XXXXXX",
    VerifySubaccountPanRequest
        .builder()
        .pan("ABCDE1234F")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**pan:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.verifySubaccountGst(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Runs a real GSTIN verification. `gstin` must be a 15-character GSTIN.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().verifySubaccountGst(
    "SA_XXXXXX",
    VerifySubaccountGstRequest
        .builder()
        .gstin("29AAJCN5983D1Z0")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**gstin:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.searchSubaccountCin(subAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Name-based CIN lookup. Returns candidate company matches; pick one and
pass it to [CIN confirm](#operation/confirm-subaccount-cin).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().searchSubaccountCin(
    "SA_XXXXXX",
    SearchSubaccountCinRequest
        .builder()
        .companyName("ACME PRIVATE LIMITED")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.confirmSubaccountCin(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Confirm the CIN selected from the search results.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().confirmSubaccountCin(
    "SA_XXXXXX",
    ConfirmSubaccountCinRequest
        .builder()
        .companyName("ACME PRIVATE LIMITED")
        .selectedCin("U72900KA2024PTC123456")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**selectedCin:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.subaccountDigilockerInitiate(subAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the DigiLocker authorization link and an `access_request_id`.
The customer completes the OAuth flow on the DigiLocker portal, after
which you finalize with
[DigiLocker verify](#operation/subaccount-digilocker-verify).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().subaccountDigilockerInitiate(
    "SA_XXXXXX",
    SubaccountDigilockerInitiateRequest
        .builder()
        .redirectUrl("https://partner.example.com/kyc/callback")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**oauthState:** `Optional<String>` — Opaque value echoed back on the redirect for CSRF protection.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.subaccountDigilockerVerify(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Finalize Aadhaar via DigiLocker after the customer completes OAuth.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().subaccountDigilockerVerify(
    "SA_XXXXXX",
    SubaccountDigilockerVerifyRequest
        .builder()
        .accessRequestId("AR_xxxxxxxx")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**accessRequestId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**linkedNumber:** `Optional<String>` — Optional. Binds the Aadhaar to a specific number (92-series).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKyc.createSubaccountKycSession(subAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a Vobiz-hosted KYC session for the sub-account. With
`flow_type=email` (default) Vobiz emails the customer a signed link
(from `kyc@vobiz.ai`, hosted at `kyc.vobiz.ai`) and `customer_email` is
required. With `flow_type=redirect`, omit `customer_email`, pass a
`redirect_url`, and the `widget_url` is returned directly for an inline
redirect.

This is the sub-account–scoped equivalent of the partner-level
[KYC Sessions](/partner/api/kyc-sessions) endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKyc().createSubaccountKycSession(
    "SA_XXXXXX",
    CreateSubaccountKycSessionRequest
        .builder()
        .accountAuthId("SA_XXXXXX")
        .flowType(CreateSubaccountKycSessionRequestFlowType.EMAIL)
        .customerEmail("customer@example.com")
        .webhookUrl("https://your-app.example.com/kyc/webhook")
        .expiresInDays(30)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**accountAuthId:** `String` — The sub-account's auth_id (typically equal to the path `sub_auth_id`).
    
</dd>
</dl>

<dl>
<dd>

**flowType:** `CreateSubaccountKycSessionRequestFlowType` 
    
</dd>
</dl>

<dl>
<dd>

**customerEmail:** `Optional<String>` — Required when `flow_type` is `email`.
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `Optional<String>` 

Required when `flow_type` is `redirect`. After verification the customer's
browser is sent to this URL.
    
</dd>
</dl>

<dl>
<dd>

**webhookUrl:** `Optional<String>` — HTTPS endpoint VoBiz POSTs the KYC result to. Omit it and no callbacks are sent.
    
</dd>
</dl>

<dl>
<dd>

**expiresInDays:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sub-Account KYC (Test Mode)
<details><summary><code>client.subAccountKycTestMode.mockVerifySubaccountPan(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Mock PAN verification — never hits the provider. Magic `pan` inputs:

| Input | Outcome |
|---|---|
| `TESTSUCCESS0001` | verified |
| `TESTFAIL0001` | failed |
| `TESTERROR0001` | HTTP 500 |
| `TESTPENDING001` | pending (finalize as verified) |
| `TESTPENDING_FAIL` | pending (finalize as failed) |

Persists a real `kyc_verifications` row and recomputes `kyc_status`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockVerifySubaccountPan(
    "SA_XXXXXX",
    MockVerifySubaccountPanRequest
        .builder()
        .pan("TESTSUCCESS0001")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**pan:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockVerifySubaccountGst(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Mock GST verification. Same magic-input matrix as [Mock verify PAN](#operation/mock-verify-subaccount-pan).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockVerifySubaccountGst(
    "SA_XXXXXX",
    MockVerifySubaccountGstRequest
        .builder()
        .gstin("TESTSUCCESS0001GST")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**gstin:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockSearchSubaccountCin(subAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns deterministic fake company matches.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockSearchSubaccountCin(
    "SA_XXXXXX",
    MockSearchSubaccountCinRequest
        .builder()
        .companyName("ACME")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockConfirmSubaccountCin(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Succeeds when `selected_cin` starts with `U72900KA2024PTC123456`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockConfirmSubaccountCin(
    "SA_XXXXXX",
    MockConfirmSubaccountCinRequest
        .builder()
        .companyName("ACME")
        .selectedCin("U72900KA2024PTC123456")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**selectedCin:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockSubaccountDigilockerInitiate(subAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a deterministic `access_request_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockSubaccountDigilockerInitiate(
    "SA_XXXXXX",
    MockSubaccountDigilockerInitiateRequest
        .builder()
        .redirectUrl("https://partner.example.com/kyc/callback")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockSubaccountDigilockerVerify(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

`access_request_id` `MOCK_AR_SUCCESS` → verified; `MOCK_AR_FAIL` → failed.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockSubaccountDigilockerVerify(
    "SA_XXXXXX",
    MockSubaccountDigilockerVerifyRequest
        .builder()
        .accessRequestId(MockSubaccountDigilockerVerifyRequestAccessRequestId.MOCK_AR_SUCCESS)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**accessRequestId:** `MockSubaccountDigilockerVerifyRequestAccessRequestId` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subAccountKycTestMode.mockFinalizePendingKyc(subAuthId, request) -> KycVerificationResult</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Promotes the most recent **pending** mock verification of the given
type to a terminal outcome — this drives the async (`TESTPENDING…`)
path without webhooks. `verification_type` ∈ `pan | aadhaar | gst | cin`;
`outcome` ∈ `verified | failed`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subAccountKycTestMode().mockFinalizePendingKyc(
    "SA_XXXXXX",
    MockFinalizePendingKycRequest
        .builder()
        .verificationType(MockFinalizePendingKycRequestVerificationType.PAN)
        .outcome(MockFinalizePendingKycRequestOutcome.VERIFIED)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subAuthId:** `String` — The sub-account's Auth ID.
    
</dd>
</dl>

<dl>
<dd>

**verificationType:** `MockFinalizePendingKycRequestVerificationType` 
    
</dd>
</dl>

<dl>
<dd>

**outcome:** `MockFinalizePendingKycRequestOutcome` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Phone Numbers
<details><summary><code>client.phoneNumbers.listNumbers(authId) -> ListNumbersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all phone numbers on your account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().listNumbers(
    "MA_XXXXXX",
    ListNumbersRequest
        .builder()
        .search("+919876543210")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — Page number, starting at 1
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` — Number of phone numbers to return per page
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Filter by phone number. Include the country code and URL-encode a leading plus sign.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.unrentNumber(authId, e164)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Release a phone number from your account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().unrentNumber(
    "MA_XXXXXX",
    "919876543210",
    UnrentNumberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**e164:** `String` — Phone number in E.164 format (without the +)
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.listInventoryNumbers(authId) -> ListInventoryNumbersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Browse available phone numbers in inventory that are not assigned to
any account. Only numbers with `status='active'` and `auth_id=NULL`
are returned. These numbers are ready to be purchased.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().listInventoryNumbers(
    "MA_XXXXXX",
    ListInventoryNumbersRequest
        .builder()
        .country("IN")
        .exclude("9180,9192")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**country:** `Optional<String>` — Filter by country code (e.g., "US", "IN").
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Substring match against the E.164 number (e.g., "80" matches "+918065...").
    
</dd>
</dl>

<dl>
<dd>

**exclude:** `Optional<String>` — One or more E.164 prefixes to remove from results. Include the country code (e.g. "9180" for India +91 80-series, "1415" for US +1 415); a leading "+" is optional. Matched against the full E.164 form, so it works for any country. Accepts a comma-separated list ("9180,9192") or repeated params ("exclude=9180&exclude=9192"), and the two forms can be combined. It is ANDed with all other filters, so it takes priority over `search`; duplicates are de-duplicated silently and `total` reflects the filtered result set.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.purchaseFromInventory(authId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Purchase a phone number from inventory and assign it to your account.
Debits your account balance for the setup fee and monthly fee. For
sub-accounts (SA_), the parent master account (MA_) is charged.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().purchaseFromInventory(
    "MA_XXXXXX",
    PurchaseFromInventoryRequest
        .builder()
        .e164("+919876543210")
        .currency("USD")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**e164:** `String` — Phone number to purchase in E.164 format.
    
</dd>
</dl>

<dl>
<dd>

**currency:** `Optional<String>` — Currency for transaction. Defaults to the number's currency or "USD".
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.assignNumberToTrunk(authId, phoneNumber, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Assign a phone number to a specific SIP trunk. Once assigned, all
inbound calls to that phone number will be routed through the
designated trunk. The phone number must be URL-encoded; use `%2B`
instead of `+` (e.g., `%2B912271264217`).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().assignNumberToTrunk(
    "MA_XXXXXX",
    "%2B912271264217",
    AssignNumberToTrunkRequest
        .builder()
        .trunkGroupId("e3e55a78-1234-5678-90ab-cdef12345678")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**phoneNumber:** `String` — The phone number to assign, URL-encoded (use %2B instead of +).
    
</dd>
</dl>

<dl>
<dd>

**trunkGroupId:** `String` — The UUID of the trunk to assign this number to.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.unassignNumberFromTrunk(authId, phoneNumber)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove the assignment between a phone number and a SIP trunk. After
unassignment, the number remains in your account inventory but will
no longer route inbound calls through the previously assigned trunk.
URL-encode the phone number (use `%2B` instead of `+`).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().unassignNumberFromTrunk(
    "MA_XXXXXX",
    "%2B912271264217",
    UnassignNumberFromTrunkRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**phoneNumber:** `String` — The phone number to unassign, URL-encoded (use %2B instead of +).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.getNumberHealth(authId, e164) -> GetNumberHealthResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the health & analytics dashboard for one of your numbers: current
status, spam flag, and call metrics over the selected window (total and
answered calls, answer rate, minutes, average duration) plus a per-period
time series of snapshots.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().getNumberHealth(
    "MA_XXXXXX",
    "%2B919876543210",
    GetNumberHealthRequest
        .builder()
        .days(30)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**e164:** `String` — The number in E.164, URL-encoded (use %2B instead of +).
    
</dd>
</dl>

<dl>
<dd>

**granularity:** `Optional<GetNumberHealthRequestGranularity>` — Snapshot granularity.
    
</dd>
</dl>

<dl>
<dd>

**days:** `Optional<Integer>` — Size of the window (in days) for the summary and snapshots.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.assignDidToSubaccount(authId, e164, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Assign a parent-pool DID to a sub-account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().assignDidToSubaccount(
    "MA_XXXXXX",
    "%2B919876543210",
    AssignDidToSubaccountRequest
        .builder()
        .subAccountId("SA_XXXXXX")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**e164:** `String` — The number in E.164, URL-encoded (use %2B instead of +).
    
</dd>
</dl>

<dl>
<dd>

**subAccountId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.phoneNumbers.unassignDidFromSubaccount(authId, e164)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Move the DID back to the parent pool.

A **15-day cool-off** is enforced: if the DID had a call within the last
15 days, the request is rejected with `409` and a
`did_cool_off_in_effect` error that includes `cool_off_until` and
`cool_off_remaining_seconds`. Never-used DIDs (`last_call_at` is `NULL`)
move back immediately.

Admins can bypass the cool-off with `?force=true` (see below); the
bypass writes a `did_assignment_audit` row and requires an
admin-role account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.phoneNumbers().unassignDidFromSubaccount(
    "MA_XXXXXX",
    "%2B919876543210",
    UnassignDidFromSubaccountRequest
        .builder()
        .force(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**e164:** `String` — The number in E.164, URL-encoded (use %2B instead of +).
    
</dd>
</dl>

<dl>
<dd>

**force:** `Optional<Boolean>` 

Admin-only cool-off bypass. Requires an admin-role account
(enforced at the gateway) and writes a `did_assignment_audit` row.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Trunks
<details><summary><code>client.trunks.listTrunks(authId) -> ListTrunksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all SIP trunks configured on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trunks().listTrunks(
    "MA_XXXXXX",
    ListTrunksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trunks.createTrunk(authId, request) -> CreateTrunkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new SIP trunk for inbound or outbound calling.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trunks().createTrunk(
    "MA_XXXXXX",
    CreateTrunkRequest
        .builder()
        .name("Retell AI SIP")
        .trunkDirection(CreateTrunkRequestTrunkDirection.OUTBOUND)
        .transport(CreateTrunkRequestTransport.UDP)
        .concurrentCallsLimit(50)
        .cpsLimit(15)
        .credentialUuid("b1e2...")
        .ipaclUuid("c3d4...")
        .recording(true)
        .enableTranscription(true)
        .webhookUrl("https://example.com/vobiz/webhook")
        .webhookMethod(CreateTrunkRequestWebhookMethod.POST)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — Trunk name.
    
</dd>
</dl>

<dl>
<dd>

**trunkDirection:** `Optional<CreateTrunkRequestTrunkDirection>` — Direction of the trunk — **`inbound` or `outbound` only** (a trunk is one direction, not both).
    
</dd>
</dl>

<dl>
<dd>

**trunkStatus:** `Optional<CreateTrunkRequestTrunkStatus>` — Trunk status — `enabled` or `disabled` (note: not `active`).
    
</dd>
</dl>

<dl>
<dd>

**secure:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**trunkDomain:** `Optional<String>` — SIP domain. Auto-generated as `{first8ofUUID}.sip.vobiz.ai` if omitted.
    
</dd>
</dl>

<dl>
<dd>

**transport:** `Optional<CreateTrunkRequestTransport>` 
    
</dd>
</dl>

<dl>
<dd>

**inboundDestination:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**concurrentCallsLimit:** `Optional<Integer>` — Stored on the trunk. The **enforced** concurrency limit is account-level (account base + channel subscriptions), not this field.
    
</dd>
</dl>

<dl>
<dd>

**cpsLimit:** `Optional<Integer>` — Stored on the trunk. The **enforced** CPS is account-level, not this field.
    
</dd>
</dl>

<dl>
<dd>

**credentialUuid:** `Optional<String>` — Attach an existing SIP credential (username / password / realm) by UUID.
    
</dd>
</dl>

<dl>
<dd>

**ipaclUuid:** `Optional<String>` — Attach an existing IP access-control list (IP-based auth) by UUID.
    
</dd>
</dl>

<dl>
<dd>

**primaryUriUuid:** `Optional<String>` — Primary origination URI UUID.
    
</dd>
</dl>

<dl>
<dd>

**fallbackUriUuid:** `Optional<String>` — Fallback origination URI UUID.
    
</dd>
</dl>

<dl>
<dd>

**recording:** `Optional<Boolean>` — Enable call recording.
    
</dd>
</dl>

<dl>
<dd>

**enableTranscription:** `Optional<Boolean>` — Auto-transcribe recordings when `recording=true`.
    
</dd>
</dl>

<dl>
<dd>

**piiRedaction:** `Optional<Boolean>` — Redact PII from transcriptions.
    
</dd>
</dl>

<dl>
<dd>

**piiEntityTypes:** `Optional<String>` — Comma-separated list of entity types to redact.
    
</dd>
</dl>

<dl>
<dd>

**webhookUrl:** `Optional<String>` 

Customer webhook for call-admission events (`CallInitiated` / `Hangup`).
Must be a valid **public** http/https URL. SSRF-validated — localhost,
private (RFC1918), and cloud-metadata (`169.254.169.254`) URLs are
rejected with `invalid webhook_url`. See [Trunk Webhooks](/trunks/webhook).
    
</dd>
</dl>

<dl>
<dd>

**webhookMethod:** `Optional<CreateTrunkRequestWebhookMethod>` — HTTP method for the webhook callback.
    
</dd>
</dl>

<dl>
<dd>

**recordingWebhookEnabled:** `Optional<Boolean>` — Fire a `recording.completed` webhook to `webhook_url` after a recording is saved.
    
</dd>
</dl>

<dl>
<dd>

**username:** `Optional<String>` — Deprecated — use `credential_uuid`.
    
</dd>
</dl>

<dl>
<dd>

**password:** `Optional<String>` — Deprecated — use `credential_uuid`.
    
</dd>
</dl>

<dl>
<dd>

**ipWhitelist:** `Optional<List<String>>` — Deprecated — use `ipacl_uuid`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trunks.retrieveTrunk(authId, trunkId) -> RetrieveTrunkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details of a specific SIP trunk.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trunks().retrieveTrunk(
    "MA_XXXXXX",
    "trunk_XXXXXX",
    RetrieveTrunkRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**trunkId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trunks.updateTrunk(authId, trunkId, request) -> UpdateTrunkResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a SIP trunk's name, configuration, or status.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trunks().updateTrunk(
    "MA_XXXXXX",
    "trunk_id",
    UpdateTrunkRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**trunkId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**trunkDirection:** `Optional<UpdateTrunkRequestTrunkDirection>` — Direction of the trunk — `inbound` or `outbound` only.
    
</dd>
</dl>

<dl>
<dd>

**trunkStatus:** `Optional<UpdateTrunkRequestTrunkStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**secure:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**trunkDomain:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**transport:** `Optional<UpdateTrunkRequestTransport>` 
    
</dd>
</dl>

<dl>
<dd>

**inboundDestination:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**concurrentCallsLimit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**cpsLimit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**credentialUuid:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**ipaclUuid:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**primaryUriUuid:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**fallbackUriUuid:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**recording:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**enableTranscription:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**piiRedaction:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**piiEntityTypes:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**webhookUrl:** `Optional<String>` — Customer webhook for call-admission events (`CallInitiated` / `Hangup`). Public http/https URL; SSRF-validated. See [Trunk Webhooks](/trunks/webhook).
    
</dd>
</dl>

<dl>
<dd>

**webhookMethod:** `Optional<UpdateTrunkRequestWebhookMethod>` 
    
</dd>
</dl>

<dl>
<dd>

**recordingWebhookEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.trunks.deleteTrunk(authId, trunkId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete a SIP trunk.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.trunks().deleteTrunk(
    "MA_XXXXXX",
    "trunk_id",
    DeleteTrunkRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**trunkId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Conference
<details><summary><code>client.conference.kickMember(authId, conferenceName, memberId) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove one or more participants from a conference while allowing their XML flow to continue.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().kickMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    KickMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conference.hangupMember(authId, conferenceName, memberId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Terminate one or more active conference member calls. A normal active-member request disconnects the member. If a member was kicked, continued its XML flow, and rejoined with the same numeric member ID, confirm removal through conference exit or call hangup callbacks.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().hangupMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    HangupMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conference.playAudioMember(authId, conferenceName, memberId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Play an audio file to a specific conference member.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().playAudioMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    PlayAudioMemberRequest
        .builder()
        .url("https://example.com/audio.mp3")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — URL of the audio file to play
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conference.stopAudioMember(authId, conferenceName, memberId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop audio playback for a specific conference member.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().stopAudioMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    StopAudioMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conference.deafMember(authId, conferenceName, memberId) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Prevent a conference member from hearing other participants.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().deafMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    DeafMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conference.undeafMember(authId, conferenceName, memberId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Restore a conference member's ability to hear other participants.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conference().undeafMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    UndeafMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## RecordCalls
<details><summary><code>client.recordCalls.startRecording(authId, callUuid, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Begin recording an active call. Set format, enable transcription, and configure a callback URL.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.recordCalls().startRecording(
    "MA_XXXXXX",
    "cdr_XXXXXXXXXX",
    StartRecordingRequest
        .builder()
        .timeLimit(120)
        .fileFormat(StartRecordingRequestFileFormat.MP3)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**timeLimit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**fileFormat:** `Optional<StartRecordingRequestFileFormat>` 
    
</dd>
</dl>

<dl>
<dd>

**transcriptionType:** `Optional<String>` — Set to `auto` to enable transcription
    
</dd>
</dl>

<dl>
<dd>

**callbackUrl:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**recordChannelType:** `Optional<StartRecordingRequestRecordChannelType>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.recordCalls.stopRecording(authId, callUuid)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop an active recording on an in-progress call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.recordCalls().stopRecording(
    "MA_XXXXXX",
    "call_uuid",
    StopRecordingRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## PlayAudio
<details><summary><code>client.playAudio.call(authId, callUuid, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Play an audio file to a live call leg.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.playAudio().call(
    "MA_XXXXXX",
    "call_uuid",
    PlayAudioCallRequest
        .builder()
        .urls("https://example.com/audio.mp3")
        .legs(PlayAudioCallRequestLegs.ALEG)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**urls:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**legs:** `Optional<PlayAudioCallRequestLegs>` 
    
</dd>
</dl>

<dl>
<dd>

**loop:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.playAudio.stopAudioCall(authId, callUuid)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop audio playing on a live call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.playAudio().stopAudioCall(
    "MA_XXXXXX",
    "call_uuid",
    StopAudioCallRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## SpeakText
<details><summary><code>client.speakText.call(authId, callUuid, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Convert text to speech and play it on a live call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.speakText().call(
    "MA_XXXXXX",
    "call_uuid",
    SpeakTextCallRequest
        .builder()
        .text("Hello, your appointment is confirmed for tomorrow at 3 PM.")
        .voice("WOMAN")
        .language("en-US")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**text:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**voice:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**language:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**legs:** `Optional<SpeakTextCallRequestLegs>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.speakText.stopSpeakCall(authId, callUuid)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop ongoing TTS playback on a live call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.speakText().stopSpeakCall(
    "MA_XXXXXX",
    "call_uuid",
    StopSpeakCallRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Dtmf
<details><summary><code>client.dtmf.sendDtmf(authId, callUuid, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Send DTMF (keypad) tones on an active call. Use `w` for 0.5s pause, `W` for 1s pause.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.dtmf().sendDtmf(
    "MA_XXXXXX",
    "call_uuid",
    SendDtmfRequest
        .builder()
        .digits("1234")
        .leg(SendDtmfRequestLeg.ALEG)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**digits:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**leg:** `Optional<SendDtmfRequestLeg>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## AudioStreams
<details><summary><code>client.audioStreams.listStreams(authId, callUuid)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List all audio streams on a live call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.audioStreams().listStreams(
    "MA_XXXXXX",
    "call_uuid",
    ListStreamsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.audioStreams.startStream(authId, callUuid, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Start streaming raw audio from a live call to a WebSocket URL.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.audioStreams().startStream(
    "MA_XXXXXX",
    "call_uuid",
    StartStreamRequest
        .builder()
        .serviceUrl("wss://your-server.com/ws")
        .bidirectional(true)
        .audioTrack(StartStreamRequestAudioTrack.BOTH)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**serviceUrl:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**bidirectional:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**audioTrack:** `Optional<StartStreamRequestAudioTrack>` 
    
</dd>
</dl>

<dl>
<dd>

**audioFormat:** `Optional<StartStreamRequestAudioFormat>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.audioStreams.getStream(authId, callUuid, streamId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details of a specific audio stream.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.audioStreams().getStream(
    "MA_XXXXXX",
    "call_uuid",
    "stream_id",
    GetStreamRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**streamId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.audioStreams.stopStream(authId, callUuid, streamId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop a specific audio stream on a live call.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.audioStreams().stopStream(
    "MA_XXXXXX",
    "call_uuid",
    "stream_id",
    StopStreamRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**callUuid:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**streamId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Conferences
<details><summary><code>client.conferences.listConferences(authId) -> ListConferencesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve conference room names reported by the API. An empty array is inconclusive and can occur while conferences are active. Maintain your own room registry for authoritative discovery, billing, cleanup, and destructive workflows.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferences().listConferences(
    "MA_XXXXXX",
    ListConferencesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conferences.deleteAllConferences(authId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Terminate all active conference rooms.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferences().deleteAllConferences(
    "MA_XXXXXX",
    DeleteAllConferencesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conferences.getConference(authId, conferenceName) -> GetConferenceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a specific conference room. A live conference can currently return a 200 response with an error payload instead of conference details.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferences().getConference(
    "MA_XXXXXX",
    "My Conf Room",
    GetConferenceRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conferences.deleteConference(authId, conferenceName)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Terminate a specific conference room and disconnect all members.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferences().deleteConference(
    "MA_XXXXXX",
    "conference_name",
    DeleteConferenceRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ConferenceMembers
<details><summary><code>client.conferenceMembers.muteMember(authId, conferenceName, memberId) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Prevent a member from speaking. Use `all` as member_id to mute everyone.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferenceMembers().muteMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    MuteMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` — Member ID, comma-separated IDs, or `all`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conferenceMembers.unmuteMember(authId, conferenceName, memberId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Allow a muted member to speak again.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferenceMembers().unmuteMember(
    "MA_XXXXXX",
    "conference_name",
    "member_id",
    UnmuteMemberRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ConferenceRecording
<details><summary><code>client.conferenceRecording.startConferenceRecording(authId, conferenceName, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Queue recording for all audio in a conference room. The response does not include a recording ID or download URL.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferenceRecording().startConferenceRecording(
    "MA_XXXXXX",
    "conference_name",
    StartConferenceRecordingRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fileFormat:** `Optional<StartConferenceRecordingRequestFileFormat>` 
    
</dd>
</dl>

<dl>
<dd>

**callbackUrl:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.conferenceRecording.stopConferenceRecording(authId, conferenceName)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Stop recording a conference room.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.conferenceRecording().stopConferenceRecording(
    "MA_XXXXXX",
    "conference_name",
    StopConferenceRecordingRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**conferenceName:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Recordings
<details><summary><code>client.recordings.listRecordings(authId) -> ListRecordingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all call recordings on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.recordings().listRecordings(
    "MA_XXXXXX",
    ListRecordingsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.recordings.getRecording(authId, recordingId) -> GetRecordingResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details and download URL for a specific recording.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.recordings().getRecording(
    "MA_XXXXXX",
    "rec_XXXXXXXXXX",
    GetRecordingRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**recordingId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.recordings.deleteRecording(authId, recordingId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete a recording from the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.recordings().deleteRecording(
    "MA_XXXXXX",
    "recording_id",
    DeleteRecordingRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**recordingId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Credentials
<details><summary><code>client.credentials.createCredential(authId, request) -> CreateCredentialResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create SIP credentials for trunk authentication.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.credentials().createCredential(
    "MA_XXXXXX",
    CreateCredentialRequest
        .builder()
        .username("myuser")
        .password("securepassword123")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**username:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.credentials.listCredentials(authId) -> ListCredentialsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all SIP credentials on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.credentials().listCredentials(
    "MA_XXXXXX",
    ListCredentialsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.credentials.updateCredential(authId, credentialId, request) -> UpdateCredentialResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update the password for an existing SIP credential.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.credentials().updateCredential(
    "MA_XXXXXX",
    "credential_id",
    UpdateCredentialRequest
        .builder()
        .password("password")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**credentialId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.credentials.deleteCredential(authId, credentialId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an existing SIP credential.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.credentials().deleteCredential(
    "MA_XXXXXX",
    "credential_id",
    DeleteCredentialRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**credentialId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## IpAccessControlList
<details><summary><code>client.ipAccessControlList.createIpAcl(authId, request) -> CreateIpAclResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add an IP access control rule to restrict SIP trunk access.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ipAccessControlList().createIpAcl(
    "MA_XXXXXX",
    CreateIpAclRequest
        .builder()
        .name("Office IP")
        .ipAddress("ip_address")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**ipAddress:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ipAccessControlList.listIpAcls(authId) -> ListIpAclsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all IP access control rules on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ipAccessControlList().listIpAcls(
    "MA_XXXXXX",
    ListIpAclsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ipAccessControlList.updateIpAcl(authId, ipAclId, request) -> UpdateIpAclResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing IP access control rule.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ipAccessControlList().updateIpAcl(
    "MA_XXXXXX",
    "ip_acl_id",
    UpdateIpAclRequest
        .builder()
        .name("name")
        .ipAddress("ip_address")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**ipAclId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**ipAddress:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.ipAccessControlList.deleteIpAcl(authId, ipAclId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Remove an IP access control rule.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.ipAccessControlList().deleteIpAcl(
    "MA_XXXXXX",
    "ip_acl_id",
    DeleteIpAclRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**ipAclId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## OriginationUri
<details><summary><code>client.originationUri.createOriginationUri(authId, request) -> CreateOriginationUriResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Add an inbound SIP endpoint (origination URI) to a trunk.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.originationUri().createOriginationUri(
    "MA_XXXXXX",
    CreateOriginationUriRequest
        .builder()
        .name("Primary SBC")
        .sipUri("sip:sbc.example.com")
        .priority(1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**sipUri:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**priority:** `Integer` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.originationUri.listOriginationUris(authId) -> ListOriginationUrisResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve all origination URIs on the account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.originationUri().listOriginationUris(
    "MA_XXXXXX",
    ListOriginationUrisRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.originationUri.updateOriginationUri(authId, uriId, request) -> UpdateOriginationUriResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing origination URI.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.originationUri().updateOriginationUri(
    "MA_XXXXXX",
    "uri_id",
    UpdateOriginationUriRequest
        .builder()
        .name("name")
        .priority(1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**uriId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**priority:** `Integer` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.originationUri.deleteOriginationUri(authId, uriId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Delete an origination URI from a trunk.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.originationUri().deleteOriginationUri(
    "MA_XXXXXX",
    "uri_id",
    DeleteOriginationUriRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**uriId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Applications
<details><summary><code>client.applications.listApplications(authId) -> ListApplicationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details of all applications created under your Vobiz account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applications().listApplications(
    "MA_XXXXXX",
    ListApplicationsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.applications.createApplication(authId, request) -> CreateApplicationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates an Application with webhook URLs for call handling.
Creating an application is usually a first step, after which you
attach the application to either a number or an endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applications().createApplication(
    "MA_XXXXXX",
    CreateApplicationRequest
        .builder()
        .appName("My Voice Application")
        .answerUrl("https://example.com/answer")
        .answerMethod("POST")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**appName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**answerUrl:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**answerMethod:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.applications.retrieveApplication(authId, appId) -> RetrieveApplicationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get details of a particular application by passing the app_id.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applications().retrieveApplication(
    "MA_XXXXXX",
    "12345678",
    RetrieveApplicationRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**appId:** `String` — Unique identifier for the application
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.applications.updateApplication(authId, appId, request) -> UpdateApplicationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Modify an application using this API. You can update any subset of
fields (partial update). Fields not provided will remain unchanged.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applications().updateApplication(
    "MA_XXXXXX",
    "12345678",
    UpdateApplicationRequest
        .builder()
        .appName("Updated Application Name")
        .defaultNumberApp(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**appId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**appName:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**defaultNumberApp:** `Boolean` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.applications.deleteApplication(authId, appId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete an Application. If the application is associated
with phone numbers, the deletion may be blocked unless those
associations are removed first.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applications().deleteApplication(
    "MA_XXXXXX",
    "12345678",
    DeleteApplicationRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**appId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Endpoints
<details><summary><code>client.endpoints.listEndpoints(authId) -> ListEndpointsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a paginated list of all SIP endpoints in your account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.endpoints().listEndpoints(
    "MA_XXXXXX",
    ListEndpointsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**offset:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**usernameContains:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**usernameExact:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**usernameStartswith:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**aliasContains:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**aliasExact:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**applicationIdExact:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**applicationIdIsnull:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**subAccount:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.endpoints.createEndpoint(authId, request) -> CreateEndpointResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new SIP endpoint that can be used to make and receive calls
through IP phones, softphones, or SIP clients. Each endpoint is
assigned a unique SIP URI and endpoint ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.endpoints().createEndpoint(
    "MA_XXXXXX",
    CreateEndpointRequest
        .builder()
        .username("john_doe")
        .password("SecurePassword123!")
        .alias("John's Desktop Phone")
        .application(12345678)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**username:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**alias:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**application:** `Integer` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.endpoints.retrieveEndpoint(authId, endpointId) -> RetrieveEndpointResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve the details of an existing endpoint. The response includes
all endpoint attributes and, if the endpoint is currently registered
on a SIP client, additional registration details.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.endpoints().retrieveEndpoint(
    "MA_XXXXXX",
    "87654321",
    RetrieveEndpointRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**endpointId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.endpoints.updateEndpoint(authId, endpointId, request) -> String</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update an existing endpoint's configuration. You can change the
password, alias, or attached application. The fields `username`,
`endpoint_id`, `domain`, `allow_same_domain`, `allow_other_domains`,
`allow_phones`, and `allow_apps` are locked after creation.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.endpoints().updateEndpoint(
    "MA_XXXXXX",
    "87654321",
    UpdateEndpointRequest
        .builder()
        .alias("John's Updated Desktop Phone")
        .password("NewSecurePassword456!")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**endpointId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**alias:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.endpoints.deleteEndpoint(authId, endpointId) -> Optional&amp;lt;String&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Permanently delete an endpoint from your Vobiz account. Once deleted,
the SIP URI will no longer be accessible, and any devices registered
with this endpoint will be disconnected.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.endpoints().deleteEndpoint(
    "MA_XXXXXX",
    "87654321",
    DeleteEndpointRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**authId:** `String` — Your account Auth ID
    
</dd>
</dl>

<dl>
<dd>

**endpointId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Partner API
<details><summary><code>client.partnerApi.getPartnerProfile() -> GetPartnerProfileResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the authenticated partner's profile and balance.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().getPartnerProfile();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.getPartnerDashboard() -> GetPartnerDashboardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Aggregated partner metrics - total customers, active accounts, balance
held across the partner ecosystem, MTD revenue, etc.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().getPartnerDashboard();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.listCustomerAccounts() -> ListCustomerAccountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns all customer sub-accounts under your partner account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().listCustomerAccounts(
    ListCustomerAccountsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Substring match on name or email.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.createCustomerAccount(request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new customer sub-account under your partner account. VoBiz
emails the customer their login credentials and (separately) a KYC link
via the kyc-sessions endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().createCustomerAccount(
    CreateCustomerAccountRequest
        .builder()
        .name("John Doe")
        .email("john@example.com")
        .phone("+919876543210")
        .password("SecurePass123!")
        .country("IN")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` — Customer's full name.
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` — Customer's email. KYC link is sent here.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `String` — E.164 format.
    
</dd>
</dl>

<dl>
<dd>

**password:** `String` — Min 8 chars, must include a number and a special character.
    
</dd>
</dl>

<dl>
<dd>

**company:** `Optional<String>` — Legal company or business name.
    
</dd>
</dl>

<dl>
<dd>

**country:** `String` — ISO 2-letter country code.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.partnerTransferBalance(customerAuthId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Atomically debits your partner master balance and credits the customer's
wallet. Both legs are recorded in each account's ledger. Transfers are
**permanent and cannot be reversed.**
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().partnerTransferBalance(
    "MA_ZKITB8Z2",
    PartnerTransferBalanceRequest
        .builder()
        .amount(500.0)
        .currency("INR")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerAuthId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**amount:** `Double` — Positive decimal. Your master balance must be ≥ this amount.
    
</dd>
</dl>

<dl>
<dd>

**currency:** `String` — Must match your partner account currency.
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` — Note for your records. Appears in both ledgers.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.listCustomerTransactions(customerAuthId) -> ListCustomerTransactionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the customer's transaction ledger. Filter by date range or
transaction type. Useful for billing reconciliation.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().listCustomerTransactions(
    "customer_auth_id",
    ListCustomerTransactionsRequest
        .builder()
        .fromDate("2026-03-01")
        .toDate("2026-03-31")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerAuthId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**fromDate:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**toDate:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**transactionType:** `Optional<ListCustomerTransactionsRequestTransactionType>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.listCustomerCdrs(customerAuthId) -> ListCustomerCdrsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Look up any customer's call history. Same filter set as the
customer-side CDR endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().listCustomerCdrs(
    "customer_auth_id",
    ListCustomerCdrsRequest
        .builder()
        .hangupCause("NO_ANSWER")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerAuthId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**callDirection:** `Optional<ListCustomerCdrsRequestCallDirection>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListCustomerCdrsRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**minDuration:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**hangupCause:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.listCustomerNumbers(customerAuthId) -> ListCustomerNumbersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Phone numbers currently assigned to a customer account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().listCustomerNumbers(
    "customer_auth_id",
    ListCustomerNumbersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerAuthId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` — Substring match against the E.164 number.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**perPage:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.listKycSessions() -> ListKycSessionsResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().listKycSessions(
    ListKycSessionsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**status:** `Optional<ListKycSessionsRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**accountAuthId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**size:** `Optional<Integer>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.createKycSession(request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Triggers VoBiz to email a KYC link to the customer. KYC is OTP-based
(PAN + Aadhaar via DigiLocker for individuals, PAN + GSTIN for
companies). No document uploads required.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().createKycSession(
    CreateKycSessionRequest
        .builder()
        .accountAuthId("MA_ZKITB8Z2")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountAuthId:** `String` — Customer's auth_id (from create-customer-account).
    
</dd>
</dl>

<dl>
<dd>

**flowType:** `Optional<CreateKycSessionRequestFlowType>` 

Delivery mode. `email` (default) emails the customer the KYC link.
`redirect` returns a `widget_url` in the response for immediate redirect.
    
</dd>
</dl>

<dl>
<dd>

**customerEmail:** `Optional<String>` — Required when `flow_type` is `email`. Ignored otherwise.
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `Optional<String>` 

Required when `flow_type` is `redirect`. After verification the customer's
browser is sent to this URL with query params `session_id`, `status`, `auth_id`.
    
</dd>
</dl>

<dl>
<dd>

**webhookUrl:** `Optional<String>` — VoBiz POSTs the KYC result here.
    
</dd>
</dl>

<dl>
<dd>

**expiresInDays:** `Optional<Integer>` — Days before the KYC link expires.
    
</dd>
</dl>

<dl>
<dd>

**reminderSchedule:** `Optional<List<CreateKycSessionRequestReminderScheduleItem>>` — Auto reminder emails before expiry. Email flow only.
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Object>>` — Free-form key/value object echoed back on GET and webhooks.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.getKycSession(sessionId)</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().getKycSession(
    "session_id",
    GetKycSessionRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sessionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.revokeKycSession(sessionId, request) -> Object</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Cancels an outstanding KYC session. Customer can no longer use the link.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().revokeKycSession(
    "session_id",
    RevokeKycSessionRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sessionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**reason:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.partnerApi.resendKycSession(sessionId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Re-dispatches the KYC link to the customer. Rate-limited to once per 30 minutes.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.partnerApi().resendKycSession(
    "session_id",
    ResendKycSessionRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sessionId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

