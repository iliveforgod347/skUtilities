package uk.tim740.skUtilities.files.event;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import uk.tim740.skUtilities.skUtilities;

import javax.annotation.Nullable;
import java.io.File;

/**
 * Created by tim740 on 22/03/2016
 */
public class ExprFile extends SimpleExpression<File> {

    @Override
    protected File[] get(Event f) {
        return new File[]{getFile(f)};
    }

    @Nullable
    private static File getFile(final @Nullable Event e) {
        if (e == null)
            return null;
        if (e instanceof EvtRunApp) {
            return ((EvtRunApp) e).getApp();
        } else if (e instanceof EvtFileDownload) {
            return ((EvtFileDownload) e).getEvtFile();
        } else if (e instanceof EvtFileCreation) {
            return ((EvtFileCreation) e).getEvtFile();
        } else if (e instanceof EvtFileDeletion) {
            return ((EvtFileDeletion) e).getEvtFile();
        } else if (e instanceof EvtFileMove) {
            return ((EvtFileMove) e).getEvtFile();
        } else if (e instanceof EvtFileCopy) {
            return ((EvtFileCopy) e).getEvtFile();
        } else if (e instanceof EvtFileRename) {
            return ((EvtFileRename) e).getEvtFile();
        } else if (e instanceof EvtFileWipe) {
            return ((EvtFileWipe) e).getEvtFile();
        } else if (e instanceof EvtFileWrite) {
            return ((EvtFileWrite) e).getEvtFile();
        } else if (e instanceof EvtUnzip) {
            return ((EvtUnzip) e).getEvtFile();
        } else if (e instanceof EvtFileZip) {
            return ((EvtFileZip) e).getEvtFile();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] arg0, int arg1, Kleenean arg2, SkriptParser.ParseResult arg3) {
        if (!ScriptLoader.isCurrentEvent(EvtRunApp.class, EvtFileDownload.class, EvtFileCreation.class, EvtFileDeletion.class, EvtFileMove.class, EvtFileCopy.class, EvtFileRename.class, EvtFileWipe.class, EvtFileWrite.class, EvtUnzip.class, EvtFileZip.class)) {
            skUtilities.prSysE("Cannot use 'file' outside of file events!", getClass().getSimpleName());
            return false;
        }
        return true;
    }

    @Override
    public Class<? extends File> getReturnType() {
        return File.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String toString(@Nullable Event arg0, boolean arg1) {
        return getClass().getName();
    }
}
