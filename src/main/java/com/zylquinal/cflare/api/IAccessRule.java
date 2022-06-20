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
package com.zylquinal.cflare.api;

import com.zylquinal.cflare.data.firewall.CreateAccessRuleRequest;
import com.zylquinal.cflare.data.firewall.CreateAccessRuleResponse;
import com.zylquinal.cflare.data.firewall.DeleteAccessRuleResponse;

import java.util.concurrent.CompletableFuture;

public interface IAccessRule {

    CompletableFuture<CreateAccessRuleResponse> create(CreateAccessRuleRequest create);
    CompletableFuture<DeleteAccessRuleResponse> delete(String identifier);

}
