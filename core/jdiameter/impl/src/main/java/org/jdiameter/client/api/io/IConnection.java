/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.client.api.io;

import org.jdiameter.api.OverloadException;
import org.jdiameter.api.Wrapper;
import org.jdiameter.client.api.IMessage;

import java.io.IOException;
import java.net.InetAddress;

/**
 * A Connection  with a remote host.
 * 
 * @author erick.svenson@yahoo.com
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface IConnection extends Wrapper {

    /**
     * Return created time
     * @return created time
     */
    public long getCreatedTime();
    
    /**
     * Return identifier of connection. For example:
     *  "[remote_host_name]:[remote_port]"
     * @return identifier of connection.
     */
    String getKey();

    /**
     * Connect with remote host
     * @throws TransportException
     */
    void connect() throws TransportException;

    /**
     * Disconnect wit remote host
     * @throws InternalError
     */
    void disconnect() throws InternalError;

    /**
     * Send message to remote host
     * @param message diameter message
     * @throws TransportException
     * @throws OverloadException
     */
    void sendMessage(IMessage message) throws TransportException, OverloadException;

    /**
     * Clear all attachec resources (close socket)
     * @throws IOException
     */
    void release() throws IOException;

    /**
     * Return true if connection is incomming
     * @return true if connection is incomming
     */
    boolean isNetworkInitiated();

    /**
     * Return true if is connection is valid
     * @return true if is connection is valid
     */
    boolean isConnected();

    /**
     * Return remote host address
     * @return remote host address
     */
    InetAddress getRemoteAddress();

    /**
     * Return remote socket port
     * @return remote socket port
     */
    int getRemotePort();

    /**
     * Append connection listener
     * @param connectionListener listener instance
     */
    void addConnectionListener(IConnectionListener connectionListener);

    /**
     * Remove all connection listeners
     */
    void remAllConnectionListener();
    
    /**
     * Remove connection listener
     * @param connectionListener listener instance
     */
    void remConnectionListener(IConnectionListener connectionListener);
}
