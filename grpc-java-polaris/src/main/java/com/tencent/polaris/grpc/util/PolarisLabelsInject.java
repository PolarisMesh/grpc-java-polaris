/*
 * Tencent is pleased to support the open source community by making Polaris available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.tencent.polaris.grpc.util;

import com.tencent.polaris.api.pojo.RouteArgument;
import com.tencent.polaris.ratelimit.api.rpc.Argument;
import io.grpc.Metadata;

import java.util.Map;
import java.util.Set;

/**
 * PolarisLabelsInject 针对每次流量的用户自定义标签注入
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public interface PolarisLabelsInject {

    /**
     * 注入本次流量的路由标签信息
     *
     * @param arguments {@link Set<RouteArgument>}
     * @return {@link Set<RouteArgument>}
     */
    Set<RouteArgument> modifyRoute(Set<RouteArgument> arguments);

    /**
     * 注入本次流量的限流标签信息
     *
     * @param arguments {@link Set<Argument>}
     * @return {@link Set<Argument>}
     */
    Set<Argument> modifyRateLimit(Set<Argument> arguments);

}
