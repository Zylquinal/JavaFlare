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
package com.zylquinal.cflare.data.firewall;

import com.zylquinal.cflare.enumeration.RequestType;
import com.zylquinal.cflare.enumeration.TargetType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateAccessRuleRequest {

    public static final RequestType api = RequestType.ZONE_ACCESSRULE_CREATE;

    private final String mode;
    private final TargetType target;
    private String notes;

}
