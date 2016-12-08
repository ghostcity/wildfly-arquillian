/*
 * Copyright 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.testenricher.msc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.jboss.msc.service.ServiceTarget;

/**
 * A thread local {@link ServiceTarget} association
 *
 * @author thomas.diesler@jboss.com
 * @author Stuart Douglas
 * @since 18-Nov-2010
 */
public final class ServiceTargetAssociation {

    private static ConcurrentMap<String, ServiceTarget> association = new ConcurrentHashMap<>();

    public static ServiceTarget getServiceTarget(final String className) {
        return association.get(className);
    }

    public static void setServiceTarget(final String className, ServiceTarget type) {
        association.put(className, type);
    }

    public static void clearServiceTarget(final String className) {
        association.remove(className);
    }
}
