package org.example.questengine.npc.sourse.dialogapi;

import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.body.PlainMessageDialogBody;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public class NPCTalkDialog
{
    public void open(Player player, UUID entityUUID)
    {
        if(entityUUID == null)
        {
            return;
        }
        Entity entity = Bukkit.getEntity(entityUUID);

        if(entity == null)
        {
            return;
        }


        Dialog dialog = Dialog.create(builder -> builder.empty()
                .base(DialogBase.builder(Component.text(entity.getName()))
                        .body(List.of(DialogBody.plainMessage(Component.text("Hello(test_message)"))))
                        .build())
                .type(DialogType.notice())
        );

        player.showDialog(dialog);
    }
}
