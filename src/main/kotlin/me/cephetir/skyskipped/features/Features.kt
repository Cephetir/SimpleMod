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

package me.cephetir.skyskipped.features

import me.cephetir.skyskipped.commands.dungeonCommands.FragRun
import me.cephetir.skyskipped.commands.dungeonCommands.LeaveCommand
import me.cephetir.skyskipped.commands.dungeonCommands.PartyCommand
import me.cephetir.skyskipped.features.impl.LastCrit
import me.cephetir.skyskipped.features.impl.chat.AutoMaddoxPhone
import me.cephetir.skyskipped.features.impl.chat.ChatSwapper
import me.cephetir.skyskipped.features.impl.chat.Ping
import me.cephetir.skyskipped.features.impl.dugeons.*
import me.cephetir.skyskipped.features.impl.hacks.ArmorSwap
import me.cephetir.skyskipped.features.impl.hacks.Blocker
import me.cephetir.skyskipped.features.impl.hacks.FailSafe
import me.cephetir.skyskipped.features.impl.visual.*
import net.minecraftforge.common.MinecraftForge

class Features {

    companion object {
        val leaveCommand = LeaveCommand()
        val partyCommand = PartyCommand()
        val petsOverlay = PetsOverlay()
        val termsDisplay = TermsDisplay()
    }

    var features: MutableList<Feature> = mutableListOf(
        ChestCloser(),
        ChatSwapper(),
        PlayerESP(),
        LastCrit(),
        Blocker(),
        Ping(),
        FragRun(),
        Pings(),
        FailSafe(),
        HidePetCandies(),
        petsOverlay,
        PresentHighlight(),
        termsDisplay,
        AutoGhostBlock(),
        PerspectiveToggle(),
        AutoMaddoxPhone(),
        CustomScoreboard(),
        HighlightUnlockedGemSots(),
        ArmorSwap(),
    )

    fun register() = features.forEach { MinecraftForge.EVENT_BUS.register(it) }
}
