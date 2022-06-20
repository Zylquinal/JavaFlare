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

import com.zylquinal.cflare.api.IAccessRule;
import com.zylquinal.cflare.data.firewall.CreateAccessRuleRequest;
import com.zylquinal.cflare.data.firewall.CreateAccessRuleResponse;
import com.zylquinal.cflare.data.firewall.DeleteAccessRuleResponse;
import com.zylquinal.cflare.enumeration.RequestType;

import java.util.concurrent.CompletableFuture;

public class AccessRule implements IAccessRule {

    private final Zone zone;

    public AccessRule(Zone zone) {
        this.zone = zone;
    }

    @Override
    public CompletableFuture<CreateAccessRuleResponse> create(CreateAccessRuleRequest create) {
        return zone.getMain().sendRequest(create, zone.compilePath(RequestType.ZONE_ACCESSRULE_CREATE.getPath()),
                RequestType.ZONE_ACCESSRULE_CREATE.getHttpMethod(), CreateAccessRuleResponse.class);
    }

    @Override
    public CompletableFuture<DeleteAccessRuleResponse> delete(String identifier) {
        return zone.getMain().sendRequest(null, zone.compilePath(
                RequestType.ZONE_ACCESSRULE_DELETE.getPath()).replace(":identifier", identifier),
                RequestType.ZONE_ACCESSRULE_CREATE.getHttpMethod(), DeleteAccessRuleResponse.class);
    }

}
