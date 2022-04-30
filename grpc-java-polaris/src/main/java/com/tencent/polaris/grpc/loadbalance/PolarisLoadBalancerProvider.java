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

package com.tencent.polaris.grpc.loadbalance;

import com.tencent.polaris.client.api.SDKContext;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancer.Helper;
import io.grpc.LoadBalancerProvider;

/**
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public class PolarisLoadBalancerProvider extends LoadBalancerProvider {

    public static final String LOADBALANCER_PROVIDER = "polaris";

    private final SDKContext context;

    private final String rule;

    public PolarisLoadBalancerProvider(SDKContext context, final String rule) {
        this.context = context;
        this.rule = rule;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getPolicyName() {
        return LOADBALANCER_PROVIDER;
    }

    @Override
    public LoadBalancer newLoadBalancer(Helper helper) {
        return new PolarisLoadBalancer(context, rule, helper);
    }
}
