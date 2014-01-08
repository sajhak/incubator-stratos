/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.stratos.manager.subscription.tenancy;

import org.apache.stratos.manager.exception.ADCException;
import org.apache.stratos.manager.exception.AlreadySubscribedException;
import org.apache.stratos.manager.exception.NotSubscribedException;
import org.apache.stratos.manager.exception.UnregisteredCartridgeException;
import org.apache.stratos.manager.subscription.CartridgeSubscription;
import org.apache.stratos.cloud.controller.pojo.Properties;

import java.io.Serializable;

public abstract class SubscriptionTenancyBehaviour implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract void createSubscription(CartridgeSubscription cartridgeSubscription)
            throws ADCException, AlreadySubscribedException;

    public abstract void registerSubscription(CartridgeSubscription cartridgeSubscription, Properties properties)
            throws ADCException, UnregisteredCartridgeException;

    public abstract void removeSubscription(CartridgeSubscription cartridgeSubscription)
            throws ADCException, NotSubscribedException;
}