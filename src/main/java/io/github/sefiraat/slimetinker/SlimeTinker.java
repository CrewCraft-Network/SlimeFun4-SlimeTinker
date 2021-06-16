package io.github.sefiraat.slimetinker;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.commands.GiveDummyTool;
import io.github.sefiraat.slimetinker.items.Alloys;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Tools;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.recipes.RecipeManager;
import io.github.sefiraat.slimetinker.listeners.ListenerManager;
import io.github.sefiraat.slimetinker.utils.Keys;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlimeTinker extends AbstractAddon {

    private static SlimeTinker instance;
    public static SlimeTinker inst() {
        return instance;
    }

    @Getter
    private RecipeManager recipeManager;

    @Getter
    private Keys keys;

    @Override
    public void onAddonEnable() {

        instance = this;
        keys = new Keys();

        getLogger().info("########################################");
        getLogger().info("              Slime Tinker              ");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("########################################");

        recipeManager = new RecipeManager();

        Categories.set(this);
        Materials.set(this);
        Alloys.set(this);
        Dies.set(this);
        Casts.set(this);
        Parts.set(this);
        Tools.set(this);
        Workstations.set(this);

        new ListenerManager();

    }

    @Override
    protected void onAddonDisable() {
        saveConfig();
        instance = null;
    }

    @Nonnull
    @Override
    protected List<AbstractCommand> setupSubCommands() {
        return Collections.singletonList(new GiveDummyTool());
    }


    @Override
    protected @NotNull String getGithubPath() {
        return "Sefiraat/SlimeTinker/master";
    }

}
