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
package com.zylquinal.cflare.data.firewall.other;

import com.zylquinal.cflare.data.ResultCommon;
import com.zylquinal.cflare.data.Scope;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateAccessRuleResult extends ResultCommon {

    private String notes;
    private List<String> allowed_modes;
    private String mode;
    private Configuration configuration;
    private Scope scope;

}
