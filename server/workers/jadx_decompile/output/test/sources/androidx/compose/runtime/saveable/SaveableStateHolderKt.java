package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SaveableStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberSaveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/SaveableStateHolder;", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SaveableStateHolderKt {
    public static final SaveableStateHolder rememberSaveableStateHolder(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(15454635);
        ComposerKt.sourceInformation($composer, "C(rememberSaveableStateHolder)*59@2369L111,64@2554L7:SaveableStateHolder.kt#r2ddri");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(15454635, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:58)");
        }
        Object m2596rememberSaveable = RememberSaveableKt.m2596rememberSaveable(new Object[0], SaveableStateHolderImpl.INSTANCE.getSaver(), (String) null, (Function0<? extends Object>) new Function0<SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderKt$rememberSaveableStateHolder$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SaveableStateHolderImpl invoke() {
                return new SaveableStateHolderImpl(null, 1, null);
            }
        }, $composer, 3080, 4);
        SaveableStateHolderImpl $this$rememberSaveableStateHolder_u24lambda_u240 = (SaveableStateHolderImpl) m2596rememberSaveable;
        ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localSaveableStateRegistry);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $this$rememberSaveableStateHolder_u24lambda_u240.setParentSaveableStateRegistry((SaveableStateRegistry) consume);
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) m2596rememberSaveable;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return saveableStateHolderImpl;
    }
}
