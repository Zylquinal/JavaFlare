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
package com.zylquinal.cflare.enumeration;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public enum TargetType {

    @SerializedName("ip")
    IP("ip"),

    @SerializedName("ip6")
    IP6("ip6"),

    @SerializedName("ip_range")
    IP_RANGE("ip_range"),

    @SerializedName("asn")
    ASN("asn"),

    @SerializedName("country")
    COUNTRY("country");

    private final String value;

    TargetType(String value) {
        this.value = value;
    }

}
