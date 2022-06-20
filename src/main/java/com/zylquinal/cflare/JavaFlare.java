/*
 * This file is part of JavaFlare.
 *
 * JavaFlare is free software: you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * JavaFlare is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with JavaFlare. If not, see
 * <https://www.gnu.org/licenses/>.
 */
package com.zylquinal.cflare;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zylquinal.cflare.data.ResponseCommon;
import com.zylquinal.cflare.zone.Zone;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Getter @Setter
public class JavaFlare {

    public static String api = "https://api.cloudflare.com/client/v4/";

    private final HttpClient httpClient;
    private final Gson gson;
    private final String email;
    private final String token;

    public JavaFlare(String email, String token) {
        this.email = email;
        this.token = token;
        this.gson = new GsonBuilder().disableHtmlEscaping().create();
        this.httpClient = HttpClient.newBuilder().build();
    }

    public Optional<Zone> createZone(String name) {
        return Optional.of(new Zone(this, name));
    }

    public <T, R extends ResponseCommon> CompletableFuture<R> sendRequest(@Nullable T object, String url, String method, Class<R> clazz) {
        return CompletableFuture.supplyAsync(() -> {
            var preRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url));
            HttpRequest request = switch (method) {
                case "GET" -> preRequest.GET().build();
                case "POST" -> preRequest.POST(HttpRequest.BodyPublishers.ofString(gson.toJson(Optional.ofNullable(object).orElseThrow()))).build();
                case "DELETE" -> preRequest.DELETE().build();
            };
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                return gson.fromJson(response.body(), clazz);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
