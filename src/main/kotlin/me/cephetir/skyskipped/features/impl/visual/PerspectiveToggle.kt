/*
 * SkySkipped - Hypixel Skyblock QOL mod
 * Copyright (C) 2023  Cephetir
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.cephetir.skyskipped.features.impl.visual

import me.cephetir.bladecore.utils.TextUtils.containsAny
import me.cephetir.bladecore.utils.minecraft.KeybindUtils.isDown
import me.cephetir.skyskipped.SkySkipped
import me.cephetir.skyskipped.config.Config
import me.cephetir.skyskipped.features.Feature
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.TickEvent


class PerspectiveToggle : Feature() {
    private var keybindLastState = false

    @SubscribeEvent
    fun onTick(event: TickEvent.ClientTickEvent) {
        if (event.phase != TickEvent.Phase.START || mc.thePlayer == null || mc.theWorld == null || !Config.betterPerspective) return

        val down = SkySkipped.perspectiveToggle.isDown()
        if (down == keybindLastState) return
        keybindLastState = down
        if (!down && Config.betterPerspectiveMode == 1) return

        if (Config.betterPerspectiveItems == "" || mc.thePlayer.heldItem == null || mc.thePlayer.heldItem.displayName.containsAny(Config.betterPerspectiveItems.split(", ")))
            mc.gameSettings.thirdPersonView = if (mc.gameSettings.thirdPersonView == 3) 0 else 3
    }
}