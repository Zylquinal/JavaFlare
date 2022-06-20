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
package com.zylquinal.cflare.zone;

import com.zylquinal.cflare.JavaFlare;
import lombok.Getter;

@Getter
public class Zone {

    private final JavaFlare main;
    private final String id;

    private final AccessRule accessRule;

    public Zone(JavaFlare main, String id) {
        this.main = main;
        this.id = id;
        this.accessRule = new AccessRule(this);
    }

    protected String compilePath(String path) {
        return path.replaceAll("(:zone_id|:zone_identifier)", id);
    }

}
