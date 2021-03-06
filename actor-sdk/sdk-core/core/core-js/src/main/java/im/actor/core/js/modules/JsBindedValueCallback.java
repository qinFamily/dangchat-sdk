/*
 * Copyright (C) 2015 Actor LLC. <https://actor.im>
 */

package im.actor.core.js.modules;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

@Export
@ExportClosure
public interface JsBindedValueCallback extends Exportable {
    void onChanged(Object obj);
}
