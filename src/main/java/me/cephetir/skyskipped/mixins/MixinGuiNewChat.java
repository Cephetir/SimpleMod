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

package me.cephetir.skyskipped.mixins;

import me.cephetir.skyskipped.SkySkipped;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(GuiNewChat.class)
public class MixinGuiNewChat {
    private final Pattern regex = Pattern.compile("§r(?:§.)+(?:(?:Party §8> |Guild > |G > |P §8> )(?:§.)+)?(?<prefix>\\[.+] )?(?<username>\\w+)(?: §.\\[.+])?(?:§.)+");

    @ModifyArg(method = "drawChat", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"), index = 0)
    private String onDrawString(String text) {
        Matcher matcher = regex.matcher(text);
        if(matcher.find()) {
            String name = matcher.group("username");
            String prefix = matcher.group("prefix");
            if(name != null && prefix != null && SkySkipped.Companion.getCosmetics().containsKey(name.trim())) {
                text = text.replace(name.trim(), SkySkipped.Companion.getCosmetics().get(name.trim()).component1().replace("&", "§"));
                text = text.replace(prefix.trim(), SkySkipped.Companion.getCosmetics().get(name.trim()).component2().replace("&", "§"));
            }
        }
        return text;
    }
}
