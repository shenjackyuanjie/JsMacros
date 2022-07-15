package xyz.wagyourtail.jsmacros.client.api.classes;

import com.google.common.collect.ImmutableList;
import xyz.wagyourtail.jsmacros.client.api.helpers.CommandNodeHelper;

import java.util.List;

/**
 * @since 1.7.0
 */
public abstract class CommandManager {
    public static CommandManager instance;

    /**
     * @since 1.7.0
     * @return list of commands
     */
    public List<String> getValidCommands() {
        return ImmutableList.of();
    }

    /**
     * @param name
     * @since 1.7.0
     * @return
     */
    public abstract CommandBuilder createCommandBuilder(String name);

    /**
     * @param command
     *
     * @return
     * @since 1.7.0
     * @throws IllegalAccessException
     */
    public abstract CommandNodeHelper unregisterCommand(String command) throws IllegalAccessException;

    /**
     * warning: this method is hacky
     * @since 1.7.0
     * @param node
     */
    public abstract void reRegisterCommand(CommandNodeHelper node);
}
