package androidx.compose.ui.tooling;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;

/* compiled from: ComposeViewAdapter.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/savedstate/SavedStateRegistryOwner;", "controller", "Landroidx/savedstate/SavedStateRegistryController;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposeViewAdapter$FakeSavedStateRegistryOwner$1 implements SavedStateRegistryOwner {
    private final SavedStateRegistryController controller;
    private final LifecycleRegistry lifecycleRegistry = LifecycleRegistry.INSTANCE.createUnsafe(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeViewAdapter$FakeSavedStateRegistryOwner$1() {
        SavedStateRegistryController $this$controller_u24lambda_u240 = SavedStateRegistryController.INSTANCE.create(this);
        $this$controller_u24lambda_u240.performRestore(new Bundle());
        this.controller = $this$controller_u24lambda_u240;
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.controller.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    /* renamed from: getLifecycle, reason: from getter */
    public LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }
}
