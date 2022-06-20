# JavaFlare

This Cloudflare API client was purposefully developed for one of my private project. While making this client publicly available.

## Example

```java
class Example {

    public static void main(String[] args) {
        CloudflareAPI api = new CloudflareAPI("email", "token");
        Zone zone = api.createZone("ZONE_ID").orElseThrow();

        CreateAccessRuleRequest accessRuleCreate = CreateAccessRuleRequest.builder().build();

        zone.getAccessRule().create(accessRuleCreate).thenAccept(response -> {
            // Some code
        });
    }
    
}
```

## Notice
```text
Cloudflare, the Cloudflare logo, and Cloudflare Workers are trademarks and/or registered trademarks of Cloudflare, Inc. 
in the United States and other jurisdictions.
```