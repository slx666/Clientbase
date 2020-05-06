package de.slx.clientbase.module;

import de.slx.clientbase.module.modules.movement.ModuleSprint;
import de.slx.clientbase.util.event.EventHandler;
import de.slx.clientbase.util.event.EventTarget;
import de.slx.clientbase.util.event.events.EventKeyPress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
public class ModuleHandler {

    private List<Module> moduleList = new ArrayList<>();

    public ModuleHandler() {
        this.moduleList.add(new ModuleSprint());

        EventHandler.registerClass(this);
    }

    public List<Module> getModuleList() {
        return this.moduleList;
    }

    @EventTarget
    public void onKeyPress(EventKeyPress eventKeyPress) {
        this.getModuleList().stream()
                .filter(m -> m.getKeyBind() == eventKeyPress.getKey())
                .forEach(Module::toggle);
    }

    public Module getModuleByClass(Class<? extends Module> moduleClass) {
        return this.getModuleList().stream()
                .filter(module -> module.getClass().equals(moduleClass))
                .findFirst()
                .orElse(null);
    }

    public Module getModuleByName(String moduleName) {
        return this.getModuleList().stream()
                .filter(module -> module.getName().equalsIgnoreCase(moduleName))
                .findFirst()
                .orElse(null);
    }
}
