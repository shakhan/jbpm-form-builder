/*
 * Copyright 2011 JBoss Inc 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.formbuilder.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.TextCallback;
import org.jbpm.model.formapi.client.CommonGlobals;
import org.jbpm.model.formapi.client.bus.ui.NotificationEvent;
import org.jbpm.model.formapi.client.bus.ui.NotificationEvent.Level;

import com.google.gwt.event.shared.EventBus;

public abstract class SimpleTextCallback implements TextCallback {

    private final EventBus bus = CommonGlobals.getInstance().getEventBus();
    private final String errorMessage;
    
    public SimpleTextCallback(String onErrorMessage) {
        this.errorMessage = onErrorMessage;
    }
    
    @Override
    public void onFailure(Method method, Throwable exception) {
        bus.fireEvent(new NotificationEvent(Level.ERROR, this.errorMessage, exception));
    }
}
