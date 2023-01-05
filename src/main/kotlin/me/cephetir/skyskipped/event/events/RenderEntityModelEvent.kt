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

package me.cephetir.skyskipped.event.events

import me.cephetir.bladecore.core.event.Cancellable
import me.cephetir.bladecore.core.event.Event
import me.cephetir.bladecore.core.event.ICancellable
import net.minecraft.client.model.ModelBase
import net.minecraft.entity.EntityLivingBase

class RenderEntityModelEvent(
    val entity: EntityLivingBase,
    val model: ModelBase,
    val partialTicks: Float
) : Event, ICancellable by Cancellable()