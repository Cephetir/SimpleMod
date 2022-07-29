/*
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * Version 2, December 2004
 *
 * Copyright (C) 2022 Cephetir
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */

package com.jagrosh.discordipc.entities.pipe;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.DiscordBuild;
import com.jagrosh.discordipc.entities.Packet;

/**
 * Constants representing various status that an {@link IPCClient} can have.
 */
public enum PipeStatus
{
    /**
     * Status for when the IPCClient when no attempt to connect has been made.<p>
     *
     * All IPCClients are created starting with this status,
     * and it never returns for the lifespan of the client.
     */
    UNINITIALIZED,

    /**
     * Status for when the Pipe is attempting to connect.<p>
     *
     * This will become set whenever the #connect() method is called.
     */
    CONNECTING,

    /**
     * Status for when the Pipe is connected with Discord.<p>
     *
     * This is only present when the connection is healthy, stable,
     * and reading good data without exception.<br>
     * If the environment becomes out of line with these principles
     * in any way, the IPCClient in question will become
     * {@link PipeStatus#DISCONNECTED}.
     */
    CONNECTED,

    /**
     * Status for when the pipe status is beginning to close.
     *
     * The status that immediately follows is always {@link PipeStatus#CLOSED}
     */
    CLOSING,

    /**
     * Status for when the Pipe has received an {@link Packet.OpCode#CLOSE}.<p>
     *
     * This signifies that the reading thread has safely and normally shut
     * and the client is now inactive.
     */
    CLOSED,

    /**
     * Status for when the Pipe has unexpectedly disconnected, either because
     * of an exception, and/or due to bad data.<p>
     *
     * When the status of an Pipe becomes this, a call to
     * {@link IPCListener#onDisconnect(IPCClient, Throwable)} will be made if one
     * has been provided to the IPCClient.<p>
     *
     * Note that the IPCClient will be inactive with this status, after which a
     * call to {@link IPCClient#connect(DiscordBuild...)} can be made to "reconnect" the
     * IPCClient.
     */
    DISCONNECTED
}