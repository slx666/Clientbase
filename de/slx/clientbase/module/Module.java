package de.slx.clientbase.module;

import de.slx.clientbase.module.setting.Setting;
import de.slx.clientbase.util.event.EventHandler;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
public class Module {

    protected Minecraft mc = Minecraft.getMinecraft();
    private String name;
    private int keyBind;
    private ModuleCategory moduleCategory;
    private boolean enabled;

    public Module() {
        this.name = this.getManifest().name();
        this.keyBind = this.getManifest().keyBind();
        this.moduleCategory = this.getManifest().category();
    }

    private ModuleManifest getManifest() {
        if (this.getClass().isAnnotationPresent(ModuleManifest.class))
            return this.getClass().getAnnotation(ModuleManifest.class);
        else
            Minecraft.getLogger().warn(this.getClass().getSimpleName() + " has no manifest.");
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getKeyBind() {
        return this.keyBind;
    }

    public ModuleCategory getModuleCategory() {
        return this.moduleCategory;
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled)
            this.onEnable();
        else
            this.onDisable();
    }

    public void onEnable() {
        EventHandler.registerClass(this);
    }

    public void onDisable() {
        EventHandler.unregisterClass(this);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Object getSettingValue(String name) {
        try {
            return Arrays.stream(this.getClass().getFields())
                    .filter(field -> field.isAnnotationPresent(Setting.class))
                    .filter(field -> field.getAnnotation(Setting.class).value().equalsIgnoreCase(name))
                    .findFirst()
                    .get()
                    .get(this);
        } catch (IllegalAccessException e) {
            Minecraft.getLogger().error("Illegal access trying to access setting '" + name + "'. Is the field accessible?", e);
        }
        return null;
    }

    public void setSettingValue(String name, Object value) {
        try {
            Arrays.stream(this.getClass().getFields())
                    .filter(field -> field.isAnnotationPresent(Setting.class))
                    .filter(field -> field.getAnnotation(Setting.class).value().equalsIgnoreCase(name))
                    .findFirst()
                    .get()
                    .set(this, value);
        } catch (IllegalAccessException e) {
            Minecraft.getLogger().error("Illegal access trying to access setting '" + name + "'. Is the field accessible?", e);
        }
    }

    public List<String> getSettings() {
        List<String> settingNameList = new ArrayList<>();
        Arrays.stream(this.getClass().getFields())
                .filter(field -> field.isAnnotationPresent(Setting.class))
                .forEach(field -> settingNameList.add(field.getAnnotation(Setting.class).value()));
        return settingNameList;
    }

    public enum ModuleCategory {
        COMBAT, MOVEMENT, PLAYER, RENDER
    }
}
