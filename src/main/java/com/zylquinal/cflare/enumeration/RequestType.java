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

import com.zylquinal.cflare.data.ResponseCommon;
import com.zylquinal.cflare.data.firewall.CreateAccessRuleResponse;
import com.zylquinal.cflare.data.firewall.DeleteAccessRuleResponse;
import lombok.Getter;

@Getter
public enum RequestType {

    ZONE_ACCESSRULE_CREATE("zones/:zone_id/firewall/access_rules/rules", CreateAccessRuleResponse.class, "POST"),
    ZONE_ACCESSRULE_DELETE("zones/:zone_id/firewall/access_rules/rules/:identifier",DeleteAccessRuleResponse.class, "DELETE");

    private final String path;
    private final Class<? extends ResponseCommon> responseClass;
    private final String httpMethod;

    RequestType(String path, Class<? extends ResponseCommon> responseClass, String httpMethod) {
        this.path = path;
        this.responseClass = responseClass;
        this.httpMethod = httpMethod;
    }

}
