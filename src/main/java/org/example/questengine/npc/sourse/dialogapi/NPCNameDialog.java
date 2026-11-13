package org.example.questengine.npc.sourse.dialogapi;

import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import io.papermc.paper.registry.data.dialog.action.DialogAction;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickCallback;
import org.bukkit.entity.Player;
import org.example.questengine.npc.sourse.EditManager;
import org.example.questengine.npc.sourse.gui.panels.MainMenu;

import java.util.List;

public class NPCNameDialog {

    public void open(Player player, EditManager editManager) {

        Dialog dialog = Dialog.create(builder -> builder.empty()

                .base(DialogBase.builder(Component.text("Edit NPC Name")).inputs(List.of(
                        DialogInput.text("npc_name", Component.text("NPC Name"))
                                        .initial("")
                                        .maxLength(64)
                                        .width(250)
                                        .build()))
                        .build())

                .type(DialogType.notice(ActionButton.builder(Component.text("Save")).action(DialogAction.customClick(
                                        (view, audience) -> {
                                            if (!(audience instanceof Player p))
                                                return;

                                            String name = view.getText("npc_name");

                                            if (name == null || name.isBlank()) {
                                                p.sendMessage("Name cannot be empty!");
                                                return;
                                            }

                                            p.sendMessage("New NPC name: " + name);
                                            editManager.setName(name);

                                            MainMenu mainMenu = new MainMenu();
                                            mainMenu.openMenu(p);


                                        },
                                        ClickCallback.Options.builder().uses(1).build()
                                ))
                                .build()
                ))
        );

        player.showDialog(dialog);
    }
}