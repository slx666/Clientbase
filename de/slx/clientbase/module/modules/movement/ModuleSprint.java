package de.slx.clientbase.module.modules.movement;

import de.slx.clientbase.module.Module;
import de.slx.clientbase.module.ModuleManifest;
import de.slx.clientbase.module.setting.Setting;
import de.slx.clientbase.util.event.EventTarget;
import de.slx.clientbase.util.event.events.EventTick;
import org.lwjgl.input.Keyboard;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
@ModuleManifest(name = "Sprint", keyBind = Keyboard.KEY_X, category = Module.ModuleCategory.MOVEMENT)
public class ModuleSprint extends Module {

    @Setting("all_directions")
    public boolean allDirections = false;

    @Override
    public void onEnable() {
        this.setSettingValue("all_directions", !this.allDirections);
        /*in this case this:
        this.allDirections = !this.allDirections;
        works too! */
        super.onEnable();
    }

    @EventTarget
    public void onTick(EventTick eventTick) {
        if (eventTick.getType().equals(EventTick.Type.EVERYWHERE)) return;
        if ((this.allDirections || this.mc.thePlayer.moveForward > 0) && this.mc.thePlayer.getFoodStats().getFoodLevel() > 6)
            mc.thePlayer.setSprinting(true);
    }

    @Override
    public void onDisable() {
        mc.thePlayer.setSprinting(false);
        super.onDisable();
    }
}
